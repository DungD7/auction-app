package com.example.auctionappver2.view.favourite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.auctionappver2.databinding.FragmentItemsFavouriteBinding;

public class ItemsFavouriteFragment extends Fragment {
    FragmentItemsFavouriteBinding binding;
    public ItemsFavouriteFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentItemsFavouriteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
