package com.example.auctionappver2.view.fragment.discover;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.auctionappver2.R;
import com.example.auctionappver2.adapter.ItemProductSearchAdapter;
import com.example.auctionappver2.databinding.FragmentSearchUtilitiesBinding;
import com.example.auctionappver2.model.Product;
import com.example.auctionappver2.viewmodel.SearchUtilitiesViewModel;

public class SearchUtilitiesFragment extends Fragment {
    private FragmentSearchUtilitiesBinding binding;

    private SearchUtilitiesViewModel viewModel;

    public SearchUtilitiesFragment() {
    }

    public static SearchUtilitiesFragment newInstance() {
        Bundle args = new Bundle();
        SearchUtilitiesFragment fragment = new SearchUtilitiesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSearchUtilitiesBinding.inflate(inflater, container, false);
        viewModel = new SearchUtilitiesViewModel(getContext(), getActivity());
        binding.ivBack.setOnClickListener(v ->  getActivity().onBackPressed());
        binding.edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                viewModel.searchItem(s.toString());
            }
        });
        viewModel.products.observe(getViewLifecycleOwner(), products -> {
            if (products.size() != 0) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                layoutManager.setReverseLayout(false);
                binding.rcvProducts.setLayoutManager(layoutManager);
                ItemProductSearchAdapter adapter = new ItemProductSearchAdapter(products, getContext(), new ItemProductSearchAdapter.ProductSearchCallBack() {
                    @Override
                    public void OnClickProduct(Product product) {
                        ProductDetailFragment fragment = new ProductDetailFragment();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("product", product);
                        fragment.setArguments(bundle);
                        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, fragment).addToBackStack(null).commitAllowingStateLoss();

                    }
                });
                binding.rcvProducts.setAdapter(adapter);
            }
        });
        return binding.getRoot();
    }
}
