package com.example.auctionappver2.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.fragment.app.FragmentActivity;

public class LoginViewModel extends BaseObservable {
    private String email;
    private String password;
    Context context;
    FragmentActivity activity;
    public LoginViewModel(Context context, FragmentActivity activity) {
        this.context = context;
        this.activity = activity;
    }

    public void LoginByEmail(String email, String password) {

    }
}
