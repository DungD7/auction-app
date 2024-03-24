package com.example.auctionapp.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.auctionapp.R;
import com.example.auctionapp.databinding.FragmentSignupBinding;
import com.example.auctionapp.hepper.HelperClass;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpFragment extends Fragment {
    FragmentSignupBinding binding;

    FirebaseDatabase database;
    DatabaseReference reference;

    public SignUpFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSignupBinding.inflate(inflater, container, false);
        binding.btnSignup.setOnClickListener(v -> {
            database = FirebaseDatabase.getInstance();
            reference = database.getReference("users");
            String name = binding.edtName.getText().toString();
            String email = binding.edtEmail.getText().toString();
            String username = binding.edtUsername.getText().toString();
            String password = binding.edtPassword.getText().toString();

            HelperClass helperClass = new HelperClass(name, email, username, password);
            reference.child(name).setValue(helperClass);
            Toast.makeText(getContext(), "You have sign up successfully", Toast.LENGTH_LONG).show();
            LoginFragment fragment = new LoginFragment();
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, fragment).addToBackStack(null).commitAllowingStateLoss();
        });
        binding.loginRedirectText.setOnClickListener(v -> {
            LoginFragment fragment = new LoginFragment();
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, fragment).addToBackStack(null).commitAllowingStateLoss();
        });

        return binding.getRoot();
    }
}
