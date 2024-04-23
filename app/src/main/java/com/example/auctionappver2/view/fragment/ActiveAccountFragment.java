package com.example.auctionappver2.view.fragment;

import android.os.Bundle;
import android.os.TokenWatcher;
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
    String mEmail;

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
        binding.tvError.setVisibility(View.GONE);
        binding.ivBack.setOnClickListener(view -> requireActivity().onBackPressed());
        binding.btnSend.setOnClickListener(v -> {
            mEmail = binding.edtEmail.getText().toString();
            if (checkEmail(mEmail)) {
                binding.tvError.setVisibility(View.GONE);
                OtpActiveAccountFragment fragment = new OtpActiveAccountFragment();
                Bundle bundle = new Bundle();
                bundle.putString("email", mEmail);
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment, fragment).addToBackStack(null).commitAllowingStateLoss();
            } else{
                binding.tvError.setVisibility(View.VISIBLE);
            }
        });
        return binding.getRoot();
    }

    private boolean checkEmail(String email) {
        boolean valid = EmailValidator.getInstance().isValid(email);
        Log.d("123321", String.valueOf(valid));
        return valid;
    }
}
