package com.example.auctionapp.view.favourite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.auctionapp.databinding.FragmentAuctioneersFavouriteBinding;
import com.example.auctionapp.databinding.FragmentItemsFavouriteBinding;


public class AuctioneersFavouriteFragment extends Fragment {
    FragmentAuctioneersFavouriteBinding binding;
    public AuctioneersFavouriteFragment() {
    }

    public AuctioneersFavouriteFragment(int contentLayoutId) {
        super(contentLayoutId);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAuctioneersFavouriteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
