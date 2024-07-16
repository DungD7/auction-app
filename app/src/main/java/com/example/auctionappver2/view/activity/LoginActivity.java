package com.example.auctionappver2.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.auctionappver2.R;
import com.example.auctionappver2.databinding.ActivityLoginBinding;
import com.example.auctionappver2.databinding.ActivitySignupBinding;
import com.example.auctionappver2.view.fragment.LoginFragment;
import com.example.auctionappver2.view.fragment.SignupFragment;
import com.google.firebase.messaging.FirebaseMessaging;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    private Fragment mFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowInsetsControllerCompat windowInsetsController =
                WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        windowInsetsController.setSystemBarsBehavior(
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        );
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initFragment();
    }

    private void initFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.findFragmentById(R.id.fragment);
        mFragment = new LoginFragment();
        mFragment.setArguments(getIntent().getExtras());
        fragmentManager.beginTransaction().replace(R.id.fragment, mFragment).addToBackStack(null).commitAllowingStateLoss();
    }


}