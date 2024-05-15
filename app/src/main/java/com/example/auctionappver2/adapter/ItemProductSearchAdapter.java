package com.example.auctionappver2.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.auctionappver2.R;
import com.example.auctionappver2.databinding.ItemProductSearchBinding;
import com.example.auctionappver2.model.Product;

import java.util.List;

public class ItemProductSearchAdapter extends RecyclerView.Adapter<ItemProductSearchAdapter.ItemProductSearchAdapterViewHolder> {
    List<Product> mProductList;
    Context mContext;
    private ProductSearchCallBack mCallBack;

    public ItemProductSearchAdapter(List<Product> mProductList, Context mContext, ProductSearchCallBack mCallBack) {
        this.mProductList = mProductList;
        this.mContext = mContext;
        this.mCallBack = mCallBack;
    }

    @NonNull
    @Override
    public ItemProductSearchAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductSearchBinding binding = ItemProductSearchBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemProductSearchAdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemProductSearchAdapterViewHolder holder, int position) {
        Product product = mProductList.get(position);
        if (product != null) {
            holder.mBinding.tvName.setText(product.getName());
            holder.mBinding.tvAmount.setText(Double.toString(product.getPrice()) + "đ");
            Glide.with(mContext)
                    .load(product.getImageBanner())
                    .placeholder(R.drawable.uiv2_img_default_square)
                    .into(holder.mBinding.ivImage);
            holder.mBinding.rlContent.setOnClickListener(v -> {
                mCallBack.OnClickProduct(product);
            });
        }
    }

    @Override
    public int getItemCount() {
        return null == mProductList ? 0 : mProductList.size();
    }

    class ItemProductSearchAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemProductSearchBinding mBinding;

        public ItemProductSearchAdapterViewHolder(@NonNull ItemProductSearchBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }
    }
    public interface ProductSearchCallBack {
        void OnClickProduct(Product product);
    }

}
