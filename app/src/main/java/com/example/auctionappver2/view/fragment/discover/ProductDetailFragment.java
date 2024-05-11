package com.example.auctionappver2.view.fragment.discover;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.auctionappver2.R;
import com.example.auctionappver2.databinding.FragmentProductDetailBinding;
import com.example.auctionappver2.model.Product;

public class ProductDetailFragment extends Fragment {

    private FragmentProductDetailBinding binding;
    private Product product;

    public ProductDetailFragment() {

    }

    public static ProductDetailFragment newInstance() {
        ProductDetailFragment fragment = new ProductDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            product = (Product) getArguments().getSerializable("product");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProductDetailBinding.inflate(inflater, container, false);
        binding.tvName.setText(product.getName());
        binding.tvDescription.setText(Html.fromHtml(product.getDescription()));
        Glide.with(getContext())
                .load(product.getImageBanner())
                .placeholder(R.drawable.uiv2_img_default_square)
                .into(binding.ivAvatar);
        binding.ivChevron.setOnClickListener(v -> {
            if(binding.tvDescription.getVisibility() == View.GONE) {
                binding.tvDescription.setVisibility(View.VISIBLE);
                binding.ivChevron.setImageResource(R.drawable.chevron_up);
            } else {
                binding.tvDescription.setVisibility(View.GONE);
                binding.ivChevron.setImageResource(R.drawable.chevron_down);
            }
        });



        return binding.getRoot();
    }
}
