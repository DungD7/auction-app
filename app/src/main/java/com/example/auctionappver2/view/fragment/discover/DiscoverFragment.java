package com.example.auctionappver2.view.fragment.discover;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.auctionappver2.R;
import com.example.auctionappver2.databinding.FragmentDiscoverBinding;
import com.example.auctionappver2.viewmodel.DiscoverViewModel;

public class DiscoverFragment extends Fragment {
    FragmentDiscoverBinding binding;

    DiscoverViewModel viewModel;


    public DiscoverFragment() {
        // Required empty public constructor
    }


    public static DiscoverFragment newInstance(String param1, String param2) {
        DiscoverFragment fragment = new DiscoverFragment();
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
        binding =  FragmentDiscoverBinding.inflate(inflater, container, false);
        viewModel = new DiscoverViewModel(getContext(), getActivity());
        binding.tvSearch.setOnClickListener(v -> {
            SearchUtilitiesFragment fragment = SearchUtilitiesFragment.newInstance();
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment, fragment).addToBackStack(null).commitAllowingStateLoss();
        });

        return binding.getRoot();
    }
}