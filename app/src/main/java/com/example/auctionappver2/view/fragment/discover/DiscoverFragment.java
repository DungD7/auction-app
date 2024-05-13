package com.example.auctionappver2.view.fragment.discover;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.auctionappver2.R;
import com.example.auctionappver2.adapter.ItemDiscoverAdapter;
import com.example.auctionappver2.databinding.FragmentDiscoverBinding;
import com.example.auctionappver2.model.Product;
import com.example.auctionappver2.view.fragment.LoginFragment;
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
        binding = FragmentDiscoverBinding.inflate(inflater, container, false);
        viewModel = new DiscoverViewModel(getContext(), getActivity());
        binding.tvSearch.setOnClickListener(v -> {
            SearchUtilitiesFragment fragment = SearchUtilitiesFragment.newInstance();
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment, fragment).addToBackStack(null).commitAllowingStateLoss();
        });

        viewModel.toast.observe(getViewLifecycleOwner(), message -> {
            if (!TextUtils.isEmpty(message)) {
                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
            }
        });
        viewModel.list1.observe(getViewLifecycleOwner(), products -> {
            if (products.size() != 0) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                layoutManager.setReverseLayout(false);
                binding.rcv1.setLayoutManager(layoutManager);
                ItemDiscoverAdapter adapter1 = new ItemDiscoverAdapter(getContext(), products, new ItemDiscoverAdapter.ProductCallBack() {
                    @Override
                    public void OnClickProduct(Product product) {
                        ProductDetailFragment fragment = new ProductDetailFragment();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("product", product);
                        fragment.setArguments(bundle);
                        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, fragment).addToBackStack(null).commitAllowingStateLoss();
                    }

                    @Override
                    public void OnClickFavouriteIcon(Product product) {

                    }
                });
                binding.rcv1.setAdapter(adapter1);
            }
        });

//        if (viewModel.list2.getContent() != null) {
//            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//            layoutManager.setReverseLayout(false);
//            binding.rcv2.setLayoutManager(layoutManager);
//            ItemDiscoverAdapter adapter2 = new ItemDiscoverAdapter(getContext(),viewModel.list2.getContent());
//            binding.rcv2.setAdapter(adapter2);
//        }
//
//        if (viewModel.list3.getContent() != null) {
//            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//            layoutManager.setReverseLayout(false);
//            binding.rcv3.setLayoutManager(layoutManager);
//            ItemDiscoverAdapter adapter3 = new ItemDiscoverAdapter(getContext(),viewModel.list3.getContent());
//            binding.rcv3.setAdapter(adapter3);
//        }


        return binding.getRoot();
    }
}