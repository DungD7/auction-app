package com.example.auctionappver2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.auctionappver2.R;
import com.example.auctionappver2.databinding.ItemBillBinding;
import com.example.auctionappver2.model.BillResponse;

import java.util.List;

public class ItemBillAdapter extends RecyclerView.Adapter<ItemBillAdapter.ItemBillAdapterViewHolder> {
    Context context;
    List<BillResponse> billResponseList;

    public ItemBillAdapter(Context context, List<BillResponse> billResponseList) {
        this.context = context;
        this.billResponseList = billResponseList;
    }

    @NonNull
    @Override
    public ItemBillAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBillBinding binding = ItemBillBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ItemBillAdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemBillAdapterViewHolder holder, int position) {
        BillResponse bill = billResponseList.get(position);
        if (bill != null) {
            holder.mBinding.tvName.setText(bill.getAuctionSchedule().getProduct().getName());
            holder.mBinding.tvPriceStart.setText(Double.toString(bill.getAuctionSchedule().getStartPrice()));
            holder.mBinding.tvPriceEnd.setText(Double.toString(bill.getPrice()));
            Glide.with(context)
                    .load(bill.getAuctionSchedule().getProduct().getImageBanner())
                    .placeholder(R.drawable.uiv2_img_default_square)
                    .into(holder.mBinding.ivAvatar);
        }
    }

    @Override
    public int getItemCount() {
        return null == billResponseList ? 0 : billResponseList.size();
    }

    class ItemBillAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemBillBinding mBinding;
        public ItemBillAdapterViewHolder(@NonNull ItemBillBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }
}
