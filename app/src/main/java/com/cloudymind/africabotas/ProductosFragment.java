package com.cloudymind.africabotas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cloudymind.africabotas.api.ProductosApi;
import com.cloudymind.africabotas.api.Servicio;
import com.cloudymind.africabotas.databinding.FragmentProductosBinding;
import com.cloudymind.africabotas.model.Producto;
import com.cloudymind.africabotas.model.RespuestaLogin;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProductosFragment extends Fragment {

    private FragmentProductosBinding binding;
    private RecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mlaLayoutManager;
    private ArrayList<Producto> productos;
    private Retrofit retrofit;
    private Servicio service;

    public ProductosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProductosBinding.inflate(inflater, container, false);
        service = new Servicio();
        initAdapter();
        getProductos();
        return binding.getRoot();
    }

    private void initAdapter(){
        productos = new ArrayList<>();
        mlaLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new RecyclerViewAdapter(productos, (int position) -> {
            Producto producto = productos.get(position);
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, new DetalleProductoFragment(producto));
            fragmentTransaction.commit();
        });
        binding.recyclerView.setLayoutManager(mlaLayoutManager);
        binding.recyclerView.setAdapter(mAdapter);
    }

    private void getProductos(){
        retrofit = service.createService();
        ProductosApi productosApi = retrofit.create(ProductosApi.class);
        Call<ArrayList<Producto>> call = productosApi.getAll();
        call.enqueue(new Callback<ArrayList<Producto>>() {
            @Override
            public void onResponse(Call<ArrayList<Producto>> call, Response<ArrayList<Producto>> response) {
                if (response.isSuccessful() && response.code() == 200) {
                    if (response.body() != null) {
                        Log.d("PRODUCTOS", productos.toString());
                        int size = productos.size();
                        productos.clear();
                        mAdapter.notifyItemRangeRemoved(0, size);
                        productos.addAll(response.body());
                        mAdapter.notifyItemRangeInserted(0, response.body().size());
                    }else{
                        Toast.makeText(getActivity(), "BODY IS NULL", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "UNSUCCESSFUL RESPONSE", Toast.LENGTH_SHORT).show();
                }
                Log.d("LOGIN", response.toString());
                Log.d("MESSAGE", response.message());
                Log.d("LOGIN", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<ArrayList<Producto>> call, Throwable t) {
                Toast.makeText(getActivity(), "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }

}