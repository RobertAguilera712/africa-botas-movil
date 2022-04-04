package com.cloudymind.africabotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.cloudymind.africabotas.databinding.ActivityDashboardBinding;

public class DashboardActivity extends AppCompatActivity {

    private ActivityDashboardBinding binding;
    private DashboardFragment dashboardFragment;
    private ProductosFragment productosFragment;
    private EscanerFragment escanerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String usuario = getIntent().getStringExtra("USUARIO");

        dashboardFragment = new DashboardFragment(usuario);
        productosFragment = new ProductosFragment();
        escanerFragment = new EscanerFragment(binding.bottomNavigationView);

        replaceFragment(dashboardFragment);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.dashboardFragment) replaceFragment(dashboardFragment);
            if (itemId == R.id.productosFragment) replaceFragment(productosFragment);
            if (itemId == R.id.escanerFragment) replaceFragment(escanerFragment);
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment f = fragmentManager.findFragmentById(R.id.frameLayout);
        if (f instanceof DetalleProductoFragment){
            replaceFragment(productosFragment);
        }else {
            super.onBackPressed();
        }
    }
}