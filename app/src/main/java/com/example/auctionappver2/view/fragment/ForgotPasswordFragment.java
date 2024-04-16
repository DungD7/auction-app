package com.example.auctionappver2.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.auctionappver2.databinding.FragmentForgotPasswordBinding;
import com.example.auctionappver2.view.fragment.favourite.FavouriteFragment;


public class ForgotPasswordFragment extends FavouriteFragment {
    private FragmentForgotPasswordBinding binding;

    public ForgotPasswordFragment() {
    }

    public static ForgotPasswordFragment newInstance() {

        Bundle args = new Bundle();

        ForgotPasswordFragment fragment = new ForgotPasswordFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false);
        binding.btnSend.setOnClickListener(view -> {

        });
        return binding.getRoot();
    }


}
