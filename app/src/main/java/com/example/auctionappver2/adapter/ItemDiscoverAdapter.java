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
import com.example.auctionappver2.databinding.ItemProductBinding;
import com.example.auctionappver2.model.Product;

import java.util.List;

public class ItemDiscoverAdapter extends RecyclerView.Adapter<ItemDiscoverAdapter.ItemDiscoverAdapterViewHolder> {
    List<Product> mProductList;
    Context mContext;

    private ProductCallBack mCallBack;

    public ItemDiscoverAdapter(Context context, List<Product> productList, ProductCallBack callBack) {
        this.mProductList = productList;
        this.mContext = context;
        this.mCallBack = callBack;
    }

    @NonNull
    @Override
    public ItemDiscoverAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductBinding binding = ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemDiscoverAdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemDiscoverAdapterViewHolder holder, int position) {
        Product product = mProductList.get(position);
        if (product != null) {
            holder.mBinding.tvName.setText(product.getName());
            holder.mBinding.tvDes.setText(Html.fromHtml(product.getDescription()));
            holder.mBinding.tvAmount.setText(Double.toString(product.getPrice()) + "đ");
            Glide.with(mContext)
                    .load(product.getImageBanner())
                    .placeholder(R.drawable.uiv2_img_default_square)
                    .into(holder.mBinding.ivAvatar);
            holder.mBinding.rlContent.setOnClickListener(v -> {
                mCallBack.OnClickProduct(product);
            });
            holder.mBinding.ivFavorite.setOnClickListener(v -> {
                mCallBack.OnClickFavouriteIcon(product);
            });
        }
    }

    @Override
    public int getItemCount() {
        return null == mProductList ? 0 : mProductList.size();
    }

    class ItemDiscoverAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemProductBinding mBinding;

        public ItemDiscoverAdapterViewHolder(@NonNull ItemProductBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }
    }

    public interface ProductCallBack {
        void OnClickProduct(Product product);

        void OnClickFavouriteIcon(Product product);
    }
}
