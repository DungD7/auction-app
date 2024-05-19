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
import com.example.auctionappver2.model.ResultFavoriteProduct;

import java.util.List;

public class FavoriteProductAdapter extends RecyclerView.Adapter<FavoriteProductAdapter.FavoriteProductAdapterViewHolder> {
    List<ResultFavoriteProduct> mProductList;
    Context mContext;

    private FavoriteProductCallBack mCallBack;

    public FavoriteProductAdapter(Context context, List<ResultFavoriteProduct> productList, FavoriteProductCallBack callBack) {
        this.mProductList = productList;
        this.mContext = context;
        this.mCallBack = callBack;
    }

    @NonNull
    @Override
    public FavoriteProductAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemProductBinding binding = ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FavoriteProductAdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteProductAdapterViewHolder holder, int position) {
        ResultFavoriteProduct favoriteProduct = mProductList.get(position);
        if (favoriteProduct != null) {
            holder.mBinding.tvName.setText(favoriteProduct.getProduct().getName());
            holder.mBinding.tvDes.setText(Html.fromHtml(favoriteProduct.getProduct().getDescription()));
            holder.mBinding.tvAmount.setText(Double.toString(favoriteProduct.getProduct().getPrice()) + "đ");
            Glide.with(mContext)
                    .load(favoriteProduct.getProduct().getImageBanner())
                    .placeholder(R.drawable.uiv2_img_default_square)
                    .into(holder.mBinding.ivAvatar);
            holder.mBinding.rlContent.setOnClickListener(v -> {
                mCallBack.OnClickProduct(favoriteProduct.getProduct());
            });
            holder.mBinding.ivFavorite.setOnClickListener(v -> {
                mCallBack.OnClickFavouriteIcon(favoriteProduct.getId());
                mProductList.remove(position);
                notifyDataSetChanged();
            });
        }
    }

    @Override
    public int getItemCount() {
        return null == mProductList ? 0 : mProductList.size();
    }

    class FavoriteProductAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemProductBinding mBinding;

        public FavoriteProductAdapterViewHolder(@NonNull ItemProductBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }
    }

    public interface FavoriteProductCallBack {
        void OnClickProduct(Product product);

        void OnClickFavouriteIcon(int id);
    }
}
