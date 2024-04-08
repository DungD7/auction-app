package com.example.auctionappver2.viewmodel;

import android.content.Context;
import android.content.Intent;

import androidx.databinding.BaseObservable;
import androidx.fragment.app.FragmentActivity;

import com.example.auctionappver2.MainActivity;
import com.example.auctionappver2.api.CoreAppInterface;
import com.example.auctionappver2.model.LoginRequest;
import com.example.auctionappver2.model.LoginResponse;
import com.example.auctionappver2.view.activity.LoginActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        LoginRequest request = new LoginRequest(email, password, "");
        CoreAppInterface.coreAppInterface.postLogin(request).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                try {
                    if(response.isSuccessful()){
                        Intent myIntent = new Intent( activity, MainActivity.class);
                        activity.startActivity(myIntent);
                    }

                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }
}
