package com.example.auctionappver2.view.activity;

import android.os.Bundle;

import com.example.auctionappver2.view.fragment.SignupFragment;
import com.example.auctionappver2.viewmodel.SignupViewModel;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import com.example.auctionappver2.databinding.ActivitySignupBinding;

import com.example.auctionappver2.R;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;
    private Fragment mFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowInsetsControllerCompat windowInsetsController =
                WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        windowInsetsController.setSystemBarsBehavior(
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        );
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initFragment();
    }
    private void initFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.findFragmentById(R.id.frame);
        mFragment = new SignupFragment();
        mFragment.setArguments(getIntent().getExtras());
        fragmentManager.beginTransaction().replace(R.id.frame, mFragment).addToBackStack(null).commitAllowingStateLoss();
    }
}