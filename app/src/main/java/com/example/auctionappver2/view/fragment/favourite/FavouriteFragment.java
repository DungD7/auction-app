package com.example.auctionappver2.view.fragment.favourite;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.auctionappver2.R;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.example.auctionappver2.databinding.FragmentFavouriteBinding;
import com.example.auctionappver2.viewmodel.ItemsFavouriteViewModel;

public class FavouriteFragment extends Fragment {

    private FragmentFavouriteBinding binding;
    private ItemsFavouriteViewModel viewModel;
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
//        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
//        binding.tagTopViewpager.setAdapter(adapter);
//        adapter.addFragment(new ItemsFavouriteFragment(), "Items");
//        adapter.addFragment(new AuctioneersFavouriteFragment(), "Auctioneers");
//        binding.tagTopViewpagertab.setViewPager(binding.tagTopViewpager);

        com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems pages = new com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems(getActivity());
        pages.add(FragmentPagerItem.of("Tác phẩm", ItemsFavouriteFragment.class));
        pages.add(FragmentPagerItem.of("Tác giả", AuctioneersFavouriteFragment.class));
        com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter adapter = new com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter(
                getChildFragmentManager(), pages);
        binding.tagTopViewpager.setOffscreenPageLimit(1);
        binding.tagTopViewpager.setAdapter(adapter);
        binding.tagTopViewpagertab.setViewPager(binding.tagTopViewpager);
        binding.tagTopViewpagertab.setCustomTabColorizer(new SmartTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                if (position == binding.tagTopViewpager.getCurrentItem()) {
                    return getResources().getColor(R.color.primary_500);
                } else {
                    return getResources().getColor(R.color.neural_500);
                }
            }

            @Override
            public int getDividerColor(int position) {
                return 0;
            }
        });
        return binding.getRoot();
    }
}