package com.cloudymind.africabotas;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudymind.africabotas.databinding.CardProductoBinding;
import com.cloudymind.africabotas.model.Producto;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private final ArrayList<Producto> productos;

    public RecyclerViewAdapter(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(CardProductoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        Producto producto = productos.get(position);
        holder.binding.txtNombre.setText(producto.getNombre());
        holder.binding.txtPrecio.setText(String.valueOf(producto.getPrecio()));
        holder.binding.txtMarca.setText(producto.getMarca());
        holder.binding.txtModelo.setText(producto.getModelo());
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private CardProductoBinding binding;

        public MyViewHolder(CardProductoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
