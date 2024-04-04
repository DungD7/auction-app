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

import com.example.auctionappver2.databinding.FragmentSignupBinding;
import com.example.auctionappver2.viewmodel.SignupViewModel;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

public class SignupFragment extends Fragment {
    FragmentSignupBinding binding;

    SignupViewModel viewModel;

//    FirebaseDatabase database;
//    DatabaseReference reference;

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
//        binding.btnSignup.setOnClickListener(v -> {
//            database = FirebaseDatabase.getInstance();
//            reference = database.getReference("users");
//            String name = binding.edtName.getText().toString();
//            String email = binding.edtEmail.getText().toString();
//            String username = binding.edtUsername.getText().toString();
//            String password = binding.edtPassword.getText().toString();
//
//            HelperClass helperClass = new HelperClass(name, email, username, password);
//            reference.child(name).setValue(helperClass);
//            Toast.makeText(getContext(), "You have sign up successfully", Toast.LENGTH_LONG).show();
//            LoginFragment fragment = new LoginFragment();
//            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).addToBackStack(null).commitAllowingStateLoss();
//        });
//        binding.loginRedirectText.setOnClickListener(v -> {
//            LoginFragment fragment = new LoginFragment();
//            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).addToBackStack(null).commitAllowingStateLoss();
//        });
        viewModel = new SignupViewModel(getContext(), getActivity());
        binding.setViewmodel(viewModel);
        viewModel.toast.observe(getViewLifecycleOwner(), message -> {
            if (!TextUtils.isEmpty(message)) {
                Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
            }
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
