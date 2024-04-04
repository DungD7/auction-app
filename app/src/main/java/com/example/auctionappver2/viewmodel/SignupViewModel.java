package com.example.auctionappver2.viewmodel;


import android.content.Context;
import android.text.TextUtils;

import androidx.databinding.BaseObservable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;

import com.example.auctionappver2.api.CoreAppHelper;
import com.example.auctionappver2.api.CoreAppInterface;
import com.example.auctionappver2.model.PostRegisterAccountRequest;
import com.example.auctionappver2.model.PostRegisterAccountResponse;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
//        CoreAppHelper.postRegisterAccount(request, new CoreAppHelper.OnCoreAppListener() {
//            @Override
//            public void onSuccess(Serializable result) {
//                PostRegisterAccountResponse response = (PostRegisterAccountResponse) result;
//                if (response != null) {
//                    toast.postValue("dccccc");
//
//                }
//            }
//
//            @Override
//            public void onFail(Serializable result) {
//                PostRegisterAccountResponse response = (PostRegisterAccountResponse) result;
//                if (response != null) {
//                    toast.postValue("faillll");
//
//                }
//            }
//
//            @Override
//            public void onExpire(String message) {
//                if (!TextUtils.isEmpty(message)) {
//                    toast.postValue(message);
//                }
//            }
//        });
        CoreAppInterface.coreAppInterface.postRegisterAccount1(request).enqueue(new Callback<PostRegisterAccountResponse>() {
            @Override
            public void onResponse(Call<PostRegisterAccountResponse> call, Response<PostRegisterAccountResponse> response) {
                try {
                    if(response.isSuccessful()){
                        if(response.body() != null && response.body().getErrorCode() == 0) {
                            toast.setValue("success");
                        }
                    }
                    else {
                        toast.setValue(response.body().getDefaultMessage());
//                        toast.setValue("Tài khoản chưa kích hoạt");
                        toast.setValue(String.valueOf(response.code()));

                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<PostRegisterAccountResponse> call, Throwable t) {
                toast.setValue("false");

            }
        });
    }
}
