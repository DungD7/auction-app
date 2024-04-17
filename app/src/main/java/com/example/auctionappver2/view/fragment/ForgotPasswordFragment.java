package com.example.auctionappver2.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.auctionappver2.databinding.FragmentForgotPasswordBinding;
import com.example.auctionappver2.view.fragment.favourite.FavouriteFragment;
import com.example.auctionappver2.viewmodel.ForgotPasswordViewModel;


public class ForgotPasswordFragment extends FavouriteFragment {
    private FragmentForgotPasswordBinding binding;
    private ForgotPasswordViewModel viewModel;


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
        viewModel = new ForgotPasswordViewModel(getContext(), getActivity());
        binding.btnSend.setOnClickListener(view -> {
            viewModel.forgotPassword(binding.edtEmail.getText().toString());
        });
//        viewModel.showLoadingDialog.observe(getViewLifecycleOwner(), status -> {
//            if (status) {
//                try {
//                    ((BaseActivity) getContext()).showLoadingWithout();
//                } catch (Exception e) {
//
//                }
//            } else {
//                try {
//                    ((BaseActivity) getContext()).hideLoadingWithout();
//                } catch (Exception e) {
//
//                }
//            }
//        });
        viewModel.toast.observe(getViewLifecycleOwner(), toast -> {

        });
        binding.ivBack.setOnClickListener(view -> getActivity().onBackPressed());
        return binding.getRoot();
    }


}
