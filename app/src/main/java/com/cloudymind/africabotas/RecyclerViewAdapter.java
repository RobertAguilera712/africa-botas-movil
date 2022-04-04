package com.cloudymind.africabotas;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudymind.africabotas.databinding.CardProductoBinding;
import com.cloudymind.africabotas.model.Producto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    public interface OnClickCallback {
        void onItemClick(int position);
    }

    private final ArrayList<Producto> productos;
    private final OnClickCallback onClickCallback;

    public RecyclerViewAdapter(ArrayList<Producto> productos, OnClickCallback onClickCallback) {
        this.productos = productos;
        this.onClickCallback = onClickCallback;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(CardProductoBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false), onClickCallback);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        Producto producto = productos.get(position);
        holder.binding.txtNombre.setText(producto.getNombre());
        holder.binding.txtPrecio.setText(String.valueOf(producto.getPrecio()));
        holder.binding.txtMarca.setText(producto.getMarca());
        holder.binding.txtModelo.setText(producto.getModelo());
        producto.setUrlFoto();
        Picasso.get().load(producto.getUrlFoto()).into(holder.binding.imvFoto);
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private CardProductoBinding binding;

        public MyViewHolder(CardProductoBinding binding, OnClickCallback clickCallback) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.getRoot().setOnClickListener(v -> {
                if (clickCallback != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        clickCallback.onItemClick(position);
                    }
                }
            });
        }
    }
}
