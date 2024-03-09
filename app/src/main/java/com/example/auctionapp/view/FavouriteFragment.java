package com.example.auctionapp.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.auctionapp.R;
import com.example.auctionapp.databinding.FragmentFavouriteBinding;
import com.example.auctionapp.viewmodel.FavouriteViewModel;
import com.ogaclejapan.smarttablayout.SmartTabLayout;


public class FavouriteFragment extends Fragment {

    private FragmentFavouriteBinding binding;

    private SmartTabLayout smartTabLayout;
    private ViewPager viewPager;


    private FavouriteViewModel viewModel;
    public FavouriteFragment() {
        // Required empty public constructor
    }


    public static FavouriteFragment newInstance() {
        FavouriteFragment fragment = new FavouriteFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFavouriteBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}