package com.example.auctionappver2.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.auctionappver2.R;
import com.example.auctionappver2.databinding.FragmentActiveAccountBinding;

import org.apache.commons.validator.routines.EmailValidator;

public class ActiveAccountFragment extends Fragment {
    FragmentActiveAccountBinding binding;
    String email;

    public ActiveAccountFragment() {
    }

    public static ActiveAccountFragment newInstance() {
        Bundle args = new Bundle();
        ActiveAccountFragment fragment = new ActiveAccountFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentActiveAccountBinding.inflate(inflater, container, false);
        binding.btnSend.setOnClickListener(v -> {
            email = binding.edtEmail.getText().toString();
            OtpActiveAccountFragment fragment = new OtpActiveAccountFragment();
            getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment, fragment).addToBackStack(null).commitAllowingStateLoss();
        });

        checkEmail();
        return binding.getRoot();
    }

    private boolean checkEmail() {
        String email = "myName@example.com";
        boolean valid = EmailValidator.getInstance().isValid(email);
        Log.d("123321", String.valueOf(valid));
        return valid;
    }
}
