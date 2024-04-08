package com.example.auctionappver2.view.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.auctionappver2.databinding.FragmentLoginInputOtpBinding;
import com.example.auctionappver2.viewmodel.OtpActiveAccountViewModel;
import com.example.auctionappver2.viewmodel.SignupViewModel;

import in.aabhasjindal.otptextview.OTPListener;

public class OtpActiveAccountFragment extends Fragment {

    private FragmentLoginInputOtpBinding binding;
    private OtpActiveAccountViewModel viewModel;
    private String mEmail;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            mEmail = getArguments().getString("email", "");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginInputOtpBinding.inflate(inflater, container, false);
        viewModel = new OtpActiveAccountViewModel(getContext(), getActivity(), mEmail);
        binding.setOtpActiveAccountViewModel(viewModel);
        viewModel.toast.observe(getViewLifecycleOwner(), message -> {
            if (!TextUtils.isEmpty(message)) {
                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
            }
        });
        binding.otpView.setOtpListener(new OTPListener() {
            @Override
            public void onInteractionListener() {
//                binding.buttonContinue.setButtonState(false, false);
                binding.tvError.setText("");
                binding.tvError.setVisibility(View.INVISIBLE);
                binding.otpView.showSuccess();
            }

            @Override
            public void onOTPComplete(String otp) {
//                binding.buttonContinue.setButtonState(true, true);
                viewModel.setmOtp(otp);
                viewModel.onClickContinue();
            }
        });

        binding.tvResend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.reSendOtp(mEmail);
            }
        });
        return binding.getRoot();
    }
}
