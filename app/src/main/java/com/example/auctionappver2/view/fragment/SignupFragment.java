package com.example.auctionappver2.view.fragment;

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

import com.example.auctionappver2.R;
import com.example.auctionappver2.databinding.FragmentSignupBinding;
import com.example.auctionappver2.viewmodel.SignupViewModel;


public class SignupFragment extends Fragment {
    FragmentSignupBinding binding;

    SignupViewModel viewModel;

    public SignupFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSignupBinding.inflate(inflater, container, false);
        viewModel = new SignupViewModel(getContext(), getActivity());
        binding.setViewmodel(viewModel);
        viewModel.toast.observe(getViewLifecycleOwner(), message -> {
            if (!TextUtils.isEmpty(message)) {
                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
            }
        });
        binding.loginRedirectText.setOnClickListener(v -> {
            LoginFragment fragment = new LoginFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).addToBackStack(null).commitAllowingStateLoss();
        });
        binding.btnSignup.setOnClickListener(v -> {
            String email = binding.edtEmail.getText().toString();
            String password = binding.edtPassword.getText().toString();
            String name = binding.edtName.getText().toString();
            String phoneNumber = binding.edtPhone.getText().toString();
            viewModel.RegisterAccountByEmail(email, password , name, phoneNumber, "");
        });

        return binding.getRoot();
    }
}
