package com.example.auctionappver2.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.auctionappver2.databinding.FragmentLoginInputOtpBinding;
import com.example.auctionappver2.viewmodel.LoginInputOtpViewModel;

public class LoginInputOtpFragment extends Fragment {

    private FragmentLoginInputOtpBinding binding;
    private LoginInputOtpViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginInputOtpBinding.inflate(inflater, container, false);
        binding.setLoginInputOtpViewModel(viewModel);
        return binding.getRoot();
    }
}
