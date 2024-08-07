package com.example.auctionappver2.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;

import com.example.auctionappver2.MainActivity;
import com.example.auctionappver2.api.CoreAppInterface;
import com.example.auctionappver2.hepper.DataLocalManager;
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

    public MutableLiveData<String> toast;
    public LoginViewModel(Context context, FragmentActivity activity) {
        this.context = context;
        this.activity = activity;
        this.toast = new MutableLiveData<>();
    }

    public void LoginByEmail(String email, String password, String tokenFcm) {
        LoginRequest request = new LoginRequest(email, password, tokenFcm);
        CoreAppInterface.coreAppInterface.postLogin(request).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                try {
                    if(response.isSuccessful()){
                        if (response.body().getUser().isActived()){
                            DataLocalManager.setTokenJwtLocal(response.body().getToken());
                            Intent myIntent = new Intent( activity, MainActivity.class);
                            activity.startActivity(myIntent);
                        } else {
                            toast.setValue("Tài khoản chưa được kích hoạt");
                        }
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
