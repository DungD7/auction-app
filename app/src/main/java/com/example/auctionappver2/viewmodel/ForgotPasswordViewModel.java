package com.example.auctionappver2.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.fragment.app.FragmentActivity;

import com.example.auctionappver2.api.CoreAppInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordViewModel extends BaseObservable {
    Context context;
    FragmentActivity activity;

    public ForgotPasswordViewModel(Context context, FragmentActivity activity) {
        this.context = context;
        this.activity = activity;
    }

    public void forgotPassword(String email) {
        CoreAppInterface.coreAppInterface.postForgotPassword(email).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, Response<Response> response) {

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }
}
