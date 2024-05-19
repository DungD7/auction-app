package com.example.auctionappver2.view.fragment.auction;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.auctionappver2.R;
import com.example.auctionappver2.databinding.FragmentDetailAuctionRoomBinding;
import com.example.auctionappver2.model.ContentAuctionSchedule;
import com.example.auctionappver2.viewmodel.DetailAuctionRoomViewModel;

public class DetailActionRoomFragment extends Fragment {

    FragmentDetailAuctionRoomBinding binding;
    DetailAuctionRoomViewModel viewModel;
    ContentAuctionSchedule schedule;

    public static DetailActionRoomFragment newInstance() {

        Bundle args = new Bundle();

        DetailActionRoomFragment fragment = new DetailActionRoomFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            schedule = (ContentAuctionSchedule) getArguments().getSerializable("schedule");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDetailAuctionRoomBinding.inflate(inflater, container, false);
        viewModel = new DetailAuctionRoomViewModel(getContext(), getActivity());
        viewModel.reSetPrice(schedule.getId());
        binding.ivBack.setOnClickListener(view -> requireActivity().onBackPressed());
        Glide.with(getContext())
                .load(schedule.getProduct().getImageBanner())
                .placeholder(R.drawable.uiv2_img_default_square)
                .into(binding.ivAvatar);
        binding.tvName.setText(schedule.getProduct().getName());
        viewModel.toast.observe(getViewLifecycleOwner(), message -> {
            if (!TextUtils.isEmpty(message)) {
                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
            }
        });

        binding.btnContinue.setOnClickListener(view -> {
            if (binding.edtAmount.getText() != null) {
                viewModel.onClickAuction(schedule.getId(), new Double(binding.edtAmount.getText().toString()).doubleValue());
            }
        });

        viewModel.currentPrice.observe(getViewLifecycleOwner(), price -> {
            binding.tvAmount.setText(Double.toString(price) + "đ");
        });
        return binding.getRoot();
    }
}
