package com.example.auctionappver2.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.auctionappver2.R;
import com.example.auctionappver2.databinding.ItemRoomAuctionBinding;
import com.example.auctionappver2.model.ContentAuctionSchedule;
import com.example.auctionappver2.model.Product;

import java.util.List;

public class AuctionScheduleAdapter extends RecyclerView.Adapter<AuctionScheduleAdapter.AuctionScheduleAdapterViewHolder> {
    private Context mContext;

    private List<ContentAuctionSchedule> mScheduleResponseList;

    private ScheduleCallBack mCallBack;

    public AuctionScheduleAdapter(Context mContext, List<ContentAuctionSchedule> mScheduleResponseList, ScheduleCallBack mCallBack) {
        this.mContext = mContext;
        this.mScheduleResponseList = mScheduleResponseList;
        this.mCallBack = mCallBack;
    }

    @NonNull
    @Override
    public AuctionScheduleAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRoomAuctionBinding binding = ItemRoomAuctionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new AuctionScheduleAdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AuctionScheduleAdapterViewHolder holder, int position) {
        ContentAuctionSchedule item = mScheduleResponseList.get(position);
        if (item != null) {
            holder.mBinding.tvTitle.setText(item.getProduct().getName());
            holder.mBinding.tvAmount.setText(Double.toString(item.getStartPrice()) + "đ");
            holder.mBinding.tvDes.setText(Html.fromHtml(item.getDescription()));
            holder.mBinding.tvStartTime.setText(item.getAuctionTime() + " " + item.getAuctionDate());
            holder.mBinding.tvEndTime.setText(item.getEndTime() + " " + item.getEndDate());
            holder.mBinding.llAuction.setOnClickListener(view -> {
                mCallBack.onClickJoinCallBack(item);
            });
            Glide.with(mContext)
                    .load(item.getProduct().getImageBanner())
                    .placeholder(R.drawable.uiv2_img_default_square)
                    .into(holder.mBinding.ivImage);
            holder.mBinding.tvDetail.setOnClickListener(view -> {
                mCallBack.detailProductCallBack(item.getProduct());
            });
        }
    }

    @Override
    public int getItemCount() {
        return null == mScheduleResponseList ? 0 : mScheduleResponseList.size();
    }

    class AuctionScheduleAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemRoomAuctionBinding mBinding;


        public AuctionScheduleAdapterViewHolder(@NonNull ItemRoomAuctionBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }

    public interface ScheduleCallBack {
        void detailProductCallBack(Product product);
        void onClickJoinCallBack(ContentAuctionSchedule ContentAuctionSchedule);
    }
}
