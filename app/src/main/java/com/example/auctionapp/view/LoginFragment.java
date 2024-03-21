package com.example.auctionapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.auctionapp.MainActivity;
import com.example.auctionapp.databinding.FragmentLoginBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;

    public LoginFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        binding.btnLogin.setOnClickListener(v -> {
            if(!validateUsername() | !validatePassword()){

            } else {
                checkUser();
            }
        });

        binding.signupRedirectText.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), SignUpFragment.class);
            startActivity(intent);
        });
        return binding.getRoot();
    }

    public boolean validateUsername() {
        String val = binding.edtUsername.getText().toString();
        if (val.isEmpty()) {
            binding.edtUsername.setError("username can not be empty");
            return false;
        } else {
            binding.edtUsername.setError(null);
            return true;
        }
    }

    public boolean validatePassword() {
        String val = binding.edtPassword.getText().toString();
        if (val.isEmpty()) {
            binding.edtPassword.setError("password can not be empty");
            return false;
        } else {
            binding.edtUsername.setError(null);
            return true;
        }
    }

    public void checkUser() {
        String userUsername = binding.edtUsername.getText().toString().trim();
        String userPassword = binding.edtPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    binding.edtUsername.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);

                    if (!Objects.equals(passwordFromDB, userPassword)) {
                        binding.edtUsername.setError(null);
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        binding.edtPassword.setError("Invalid credentials");
                        binding.edtPassword.requestFocus();
                    }
                } else {
                    binding.edtUsername.setError("User do not exit");
                    binding.edtUsername.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
