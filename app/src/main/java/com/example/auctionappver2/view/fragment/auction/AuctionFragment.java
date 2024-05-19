package com.example.auctionappver2.view.fragment.auction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.auctionappver2.R;
import com.example.auctionappver2.adapter.AuctionScheduleAdapter;
import com.example.auctionappver2.databinding.FragmentAuctionBinding;
import com.example.auctionappver2.model.ContentAuctionSchedule;
import com.example.auctionappver2.model.Product;
import com.example.auctionappver2.view.fragment.discover.ProductDetailFragment;
import com.example.auctionappver2.viewmodel.AuctionViewModel;

public class AuctionFragment extends Fragment {

    FragmentAuctionBinding binding;
    AuctionViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAuctionBinding.inflate(inflater, container, false);
        viewModel = new AuctionViewModel(getContext(), getActivity());
        viewModel.listSchedule.observe(getViewLifecycleOwner(), contentAuctionSchedules -> {
            if (contentAuctionSchedules != null) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                layoutManager.setReverseLayout(false);
                binding.rcv.setLayoutManager(layoutManager);
                AuctionScheduleAdapter adapter = new AuctionScheduleAdapter(getContext(), contentAuctionSchedules, new AuctionScheduleAdapter.ScheduleCallBack() {
                    @Override
                    public void detailProductCallBack(Product product) {
                        ProductDetailFragment fragment = new ProductDetailFragment();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("product", product);
                        fragment.setArguments(bundle);
                        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, fragment).addToBackStack(null).commitAllowingStateLoss();
                    }

                    @Override
                    public void onClickJoinCallBack(ContentAuctionSchedule contentAuctionSchedule) {
                        viewModel.getStatusSchedule(contentAuctionSchedule.getId());
                        viewModel.isStart.observe(getViewLifecycleOwner(), status -> {
                            if(status) {
                                viewModel.addUserToAuctionRoom(contentAuctionSchedule.getId());
                                DetailActionRoomFragment fragment = new DetailActionRoomFragment();
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("schedule", contentAuctionSchedule);
                                fragment.setArguments(bundle);
                                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, fragment).addToBackStack(null).commitAllowingStateLoss();
                            } else {
                                viewModel.toast.setValue("Phòng đấu giá chưa bắt đầu");
                            }
                        });
                    }
                });
                binding.rcv.setAdapter(adapter);
            }
        });
        return binding.getRoot();
    }
}
