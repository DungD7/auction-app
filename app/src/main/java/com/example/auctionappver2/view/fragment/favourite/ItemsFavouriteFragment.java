package com.example.auctionappver2.view.fragment.favourite;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.auctionappver2.R;
import com.example.auctionappver2.adapter.FavoriteProductAdapter;
import com.example.auctionappver2.adapter.ItemDiscoverAdapter;
import com.example.auctionappver2.databinding.FragmentItemsFavouriteBinding;
import com.example.auctionappver2.model.Product;
import com.example.auctionappver2.view.fragment.discover.ProductDetailFragment;
import com.example.auctionappver2.viewmodel.ItemsFavouriteViewModel;

public class ItemsFavouriteFragment extends Fragment {
    FragmentItemsFavouriteBinding binding;

    ItemsFavouriteViewModel viewModel;

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
        viewModel = new ItemsFavouriteViewModel(getContext(), getActivity());
        viewModel.products.observe(getViewLifecycleOwner(), products -> {
            if (products.size() != 0) {
                binding.tvEmpty.setVisibility(View.GONE);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                layoutManager.setReverseLayout(false);
                binding.rcvFavorite.setLayoutManager(layoutManager);
                viewModel.toast.observe(getViewLifecycleOwner(), message -> {
                    if (!TextUtils.isEmpty(message)) {
                        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
                    }
                });
                FavoriteProductAdapter adapter = new FavoriteProductAdapter(getContext(), products, new FavoriteProductAdapter.FavoriteProductCallBack() {
                    @Override
                    public void OnClickProduct(Product product) {
                        ProductDetailFragment fragment = new ProductDetailFragment();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("product", product);
                        fragment.setArguments(bundle);
                        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, fragment).addToBackStack(null).commitAllowingStateLoss();
                    }

                    @Override
                    public void OnClickFavouriteIcon(int id) {
                        viewModel.deleteFavoriteProduct(id);

                        Log.d("123abc", String.valueOf(id));
                    }
                });
                binding.rcvFavorite.setAdapter(adapter);
            } else {
                binding.tvEmpty.setVisibility(View.VISIBLE);
            }
        });

        return binding.getRoot();
    }
}
