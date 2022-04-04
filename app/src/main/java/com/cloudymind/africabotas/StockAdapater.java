package com.cloudymind.africabotas;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cloudymind.africabotas.databinding.CardStockBinding;
import com.cloudymind.africabotas.model.Stock;

import java.util.ArrayList;

public class StockAdapater extends RecyclerView.Adapter<StockAdapater.MyViewHolder> {

    private final ArrayList<Stock> stocks;

    public StockAdapater(ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StockAdapater.MyViewHolder(CardStockBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Stock stock = stocks.get(position);
        holder.binding.txtTalla.setText(stock.getTalla().getTalla());
        holder.binding.txtExistencias.setText(stock.getExistencias());
    }

    @Override
    public int getItemCount() {
        return stocks.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private CardStockBinding binding;

        public MyViewHolder(CardStockBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
