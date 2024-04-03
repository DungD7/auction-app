package com.example.auctionappver2.viewmodel;


import android.content.Context;
import android.text.TextUtils;

import androidx.databinding.BaseObservable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;

import com.example.auctionappver2.api.CoreAppHelper;
import com.example.auctionappver2.model.PostRegisterAccountRequest;
import com.example.auctionappver2.model.PostRegisterAccountResponse;

import java.io.Serializable;

public class SignupViewModel extends BaseObservable {
    public Context mContext;
    public FragmentActivity mActivity;
    public MutableLiveData<Boolean> showLoadingDialog;
    public MutableLiveData<String> toast;

    public SignupViewModel(Context mContext, FragmentActivity mActivity) {
        this.mContext = mContext;
        this.mActivity = mActivity;
        this.showLoadingDialog = new MutableLiveData<>();
        this.toast = new MutableLiveData<>();
    }

    public void RegisterAccountByEmail(String email, String password, String fullname, String phone, String tokenFcm) {
        PostRegisterAccountRequest request = new PostRegisterAccountRequest(email, password, fullname, phone, tokenFcm);
        CoreAppHelper.postRegisterAccount(request, new CoreAppHelper.OnCoreAppListener() {
            @Override
            public void onSuccess(Serializable result) {
                PostRegisterAccountResponse response = (PostRegisterAccountResponse) result;
                if (response != null) {
                    toast.postValue("dccccc");

                }
            }

            @Override
            public void onFail(Serializable result) {
                PostRegisterAccountResponse response = (PostRegisterAccountResponse) result;
                if (response != null) {
                    toast.postValue("faillll");

                }
            }

            @Override
            public void onExpire(String message) {
                if (!TextUtils.isEmpty(message)) {
                    toast.postValue(message);
                }
            }
        });
    }
}
