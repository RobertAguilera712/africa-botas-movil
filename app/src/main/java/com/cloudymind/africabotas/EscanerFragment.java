package com.cloudymind.africabotas;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.ConditionVariable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.DecodeCallback;
import com.budiyev.android.codescanner.ScanMode;
import com.cloudymind.africabotas.api.ProductosApi;
import com.cloudymind.africabotas.api.Servicio;
import com.cloudymind.africabotas.databinding.FragmentEscanerBinding;
import com.cloudymind.africabotas.model.Producto;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.zxing.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class EscanerFragment extends Fragment {

    private FragmentEscanerBinding binding;
    private CodeScanner codeScanner;
    private final BottomNavigationView bottomNavigationView;
    private Retrofit retrofit;
    private Servicio service;

    public EscanerFragment(BottomNavigationView bottomNavigationView) {
        this.bottomNavigationView = bottomNavigationView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEscanerBinding.inflate(inflater, container, false);
        final FragmentActivity activity = getActivity();
        service = new Servicio();
        codeScanner = new CodeScanner(activity, binding.scannerView);
        codeScanner.setAutoFocusEnabled(true);
        codeScanner.setFormats(CodeScanner.ALL_FORMATS);
        codeScanner.setScanMode(ScanMode.CONTINUOUS);

        codeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull Result result) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String id = result.getText();
                        retrofit = service.createService();
                        ProductosApi productosApi = retrofit.create(ProductosApi.class);
                        Call<Producto> call = productosApi.get(id);
                        call.enqueue(new Callback<Producto>() {
                            @Override
                            public void onResponse(Call<Producto> call, Response<Producto> response) {
                                if (response.isSuccessful() && response.code() == 200) {
                                    if (response.body() != null) {
                                        bottomNavigationView.setSelectedItemId(R.id.productosFragment);
                                        Producto producto = response.body();
                                        producto.setUrlFoto();
                                        FragmentManager fragmentManager = activity.getSupportFragmentManager();
                                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                        fragmentTransaction.replace(R.id.frameLayout, new DetalleProductoFragment(producto));
                                        fragmentTransaction.commit();
                                    }else{
                                        Toast.makeText(activity, "Producto no encontrado", Toast.LENGTH_SHORT).show();
                                    }
                                }else{
                                    Toast.makeText(activity, "UNSUCCESSFUL RESPONSE", Toast.LENGTH_SHORT).show();
                                }
                                Log.d("LOGIN", response.toString());
                                Log.d("MESSAGE", response.message());
                                Log.d("LOGIN", String.valueOf(response.code()));
                            }

                            @Override
                            public void onFailure(Call<Producto> call, Throwable t) {
                                Toast.makeText(activity, "Error de conexión", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });

        codeScanner.startPreview();

        return binding.getRoot();
    }
}