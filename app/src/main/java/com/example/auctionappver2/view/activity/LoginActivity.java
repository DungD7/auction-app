package com.example.auctionappver2.view.activity;

import android.os.Bundle;

import com.example.auctionappver2.databinding.ActivityLoginBinding;


import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }
}