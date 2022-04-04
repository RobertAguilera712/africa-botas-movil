package com.cloudymind.africabotas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloudymind.africabotas.databinding.FragmentDetalleProductoBinding;
import com.cloudymind.africabotas.model.Producto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetalleProductoFragment extends Fragment {


    private FragmentDetalleProductoBinding binding;
    private Producto producto;
    private StockAdapater mAdapter;
    private RecyclerView.LayoutManager mlaLayoutManager;

    public DetalleProductoFragment(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetalleProductoBinding.inflate(inflater, container, false);
        Picasso.get().load(producto.getUrlFoto()).into(binding.imvFoto);
        binding.txtNombre.setText(producto.getNombre());
        binding.txtPrecio.setText(String.valueOf(producto.getPrecio()));
        binding.txtMarca.setText(producto.getMarca());
        binding.txtModelo.setText(producto.getModelo());
        initAdapter();
        return binding.getRoot();
    }

    private void initAdapter(){
        mlaLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new StockAdapater(producto.getStock());
        binding.rvStock.setLayoutManager(mlaLayoutManager);
        binding.rvStock.setAdapter(mAdapter);
    }

}