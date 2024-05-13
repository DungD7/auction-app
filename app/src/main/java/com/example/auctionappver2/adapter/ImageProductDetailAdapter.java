package com.example.auctionappver2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.auctionappver2.databinding.ItemImageProductDetailBinding;
import com.example.auctionappver2.model.ProductImage;

import java.util.List;

public class ImageProductDetailAdapter extends RecyclerView.Adapter<ImageProductDetailAdapter.ImageProductDetailAdapterViewHolder> {
    List<ProductImage> mImageList;

    Context context;

    @NonNull
    @Override
    public ImageProductDetailAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemImageProductDetailBinding binding = ItemImageProductDetailBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        return new ImageProductDetailAdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageProductDetailAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return null == mImageList ? 0 : mImageList.size();
    }

    class ImageProductDetailAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemImageProductDetailBinding mBinding;

        public ImageProductDetailAdapterViewHolder(@NonNull ItemImageProductDetailBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }
    }
}
