package com.example.auctionappver2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.auctionappver2.databinding.ItemDiscoverBinding;
import com.example.auctionappver2.model.Product;

import java.util.List;

public class ItemDiscoverAdapter extends RecyclerView.Adapter<ItemDiscoverAdapter.ItemDiscoverAdapterViewHolder>{
    List<Product> mProductList;
    public ItemDiscoverAdapter(List<Product> productList) {
        this.mProductList = productList;
    }

    @NonNull
    @Override
    public ItemDiscoverAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemDiscoverBinding binding = ItemDiscoverBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemDiscoverAdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemDiscoverAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ItemDiscoverAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemDiscoverBinding mBinding;
        public ItemDiscoverAdapterViewHolder(@NonNull ItemDiscoverBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }
    }
}
