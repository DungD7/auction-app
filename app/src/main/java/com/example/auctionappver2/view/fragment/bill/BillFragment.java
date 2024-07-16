package com.example.auctionappver2.view.fragment.bill;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.auctionappver2.adapter.ItemBillAdapter;
import com.example.auctionappver2.databinding.FragmentBillBinding;
import com.example.auctionappver2.viewmodel.BillViewModel;

public class BillFragment extends Fragment {
    FragmentBillBinding binding;

    BillViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentBillBinding.inflate(inflater, container, false);
        viewModel = new BillViewModel(getContext(), getActivity());
        viewModel.billResponses.observe(getViewLifecycleOwner(), billResponses -> {
            if (billResponses.size() != 0) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                layoutManager.setReverseLayout(false);
                binding.rcv.setLayoutManager(layoutManager);
                ItemBillAdapter adapter = new ItemBillAdapter(getContext(), billResponses);
                binding.rcv.setAdapter(adapter);
            }
        });
        return binding.getRoot();
    }
}
