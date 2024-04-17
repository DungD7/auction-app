package com.example.auctionappver2.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;

import com.example.auctionappver2.R;
import com.example.auctionappver2.api.CoreAppInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordViewModel extends BaseObservable {
    Context context;
    FragmentActivity activity;

    public MutableLiveData<String> toast;
    public MutableLiveData<Boolean> showLoadingDialog;



    public ForgotPasswordViewModel(Context context, FragmentActivity activity) {
        this.context = context;
        this.activity = activity;
        this.toast = new MutableLiveData<>();
        this.showLoadingDialog = new MutableLiveData<>();
    }

    public void forgotPassword(String email) {
        showLoadingDialog.setValue(true);
        CoreAppInterface.coreAppInterface.postForgotPassword(email).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, Response<Response> response) {
                showLoadingDialog.setValue(true);
                if(response.isSuccessful() && response.code() == 200){
                    toast.setValue(response.toString());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                showLoadingDialog.setValue(true);
                toast.setValue(context.getString(R.string.toast_error_api));
            }
        });
    }
}
