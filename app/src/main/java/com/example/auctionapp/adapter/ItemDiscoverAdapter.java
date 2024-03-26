package com.example.auctionapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.auctionapp.databinding.ItemDiscoverBinding;

public class ItemDiscoverAdapter extends RecyclerView.Adapter<ItemDiscoverAdapter.ItemDiscoverAdapterViewHolder>{

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
