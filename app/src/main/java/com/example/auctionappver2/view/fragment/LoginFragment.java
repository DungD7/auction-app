package com.example.auctionappver2.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.auctionappver2.MainActivity;
import com.example.auctionappver2.R;
import com.example.auctionappver2.databinding.FragmentLoginBinding;
import com.example.auctionappver2.viewmodel.LoginViewModel;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    private LoginViewModel viewModel;

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
//        binding.btnLogin.setOnClickListener(v -> {
//            if(!validateUsername() | !validatePassword()){
//
//            } else {
//                checkUser();
//            }
//        });
//
//        binding.signupRedirectText.setOnClickListener(v -> {
//            SignUpFragment fragment = new SignUpFragment();
//            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).addToBackStack(null).commitAllowingStateLoss();
//        });
//        return binding.getRoot();
//    }
//
//    public boolean validateUsername() {
//        String val = binding.edtUsername.getText().toString();
//        if (val.isEmpty()) {
//            binding.edtUsername.setError("username can not be empty");
//            return false;
//        } else {
//            binding.edtUsername.setError(null);
//            return true;
//        }
//    }
//
//    public boolean validatePassword() {
//        String val = binding.edtPassword.getText().toString();
//        if (val.isEmpty()) {
//            binding.edtPassword.setError("password can not be empty");
//            return false;
//        } else {
//            binding.edtUsername.setError(null);
//            return true;
//        }
//    }
//
//    public void checkUser() {
//        String userUsername = binding.edtUsername.getText().toString().trim();
//        String userPassword = binding.edtPassword.getText().toString().trim();
//
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
//        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);
//
//        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//                    binding.edtUsername.setError(null);
//                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
//
//                    if (!Objects.equals(passwordFromDB, userPassword)) {
//                        binding.edtUsername.setError(null);
//                        String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
//                        String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
//                        String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
//                        Intent intent = new Intent(getActivity(), MainActivity.class);
//                        intent.putExtra("name", nameFromDB);
//                        intent.putExtra("email", emailFromDB);
//                        intent.putExtra("username", usernameFromDB);
//                        intent.putExtra("password", passwordFromDB);
//                        startActivity(intent);
//                    } else {
//                        binding.edtPassword.setError("Invalid credentials");
//                        binding.edtPassword.requestFocus();
//                    }
//                } else {
//                    binding.edtUsername.setError("User do not exit");
//                    binding.edtUsername.requestFocus();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
        viewModel = new LoginViewModel(getContext(), getActivity());
        binding.setViewmodel(viewModel);
        binding.signupRedirectText.setOnClickListener(v -> {
            SignupFragment fragment = new SignupFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragment).addToBackStack(null).commitAllowingStateLoss();
        });
        binding.btnLogin.setOnClickListener(v -> {
            String email = binding.edtEmail.getText().toString();
            String password = binding.edtPassword.getText().toString();
            Intent myIntent = new Intent(getActivity(), MainActivity.class);
            startActivity(myIntent);
//            viewModel.LoginByEmail(email, password);
        });
        return binding.getRoot();
    }
}
