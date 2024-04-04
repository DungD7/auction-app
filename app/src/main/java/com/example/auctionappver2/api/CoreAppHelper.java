package com.example.auctionappver2.api;

import android.text.TextUtils;
import android.util.Log;

import com.example.auctionappver2.model.PostRegisterAccountRequest;
import com.example.auctionappver2.model.PostRegisterAccountResponse;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CoreAppHelper {

    public interface OnCoreAppListener {
        void onSuccess(Serializable result);

        void onFail(Serializable result);

        void onExpire(String message);
    }

    public static void postRegisterAccount(PostRegisterAccountRequest request, final OnCoreAppListener listener) {
        try {
            String requestDate = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
            CoreAppClient.getClient().create(CoreAppInterface.class).postRegisterAccount(request)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(new Observer<PostRegisterAccountResponse>() {
                        @Override
                        public void onSubscribe(Disposable d) {
//                            pDialog.show();
                        }

                        @Override
                        public void onNext(PostRegisterAccountResponse result) {
                            if (result != null) {
                                if (result.getErrorCode() == 330) {
                                    if (listener != null) {
                                        listener.onExpire(result.getDefaultMessage());
                                    }
                                } else {
                                    if (listener != null) {
                                        if (result.getErrorCode() == 0) {
                                            listener.onSuccess(result);
                                        } else {
                                            listener.onFail(result);
                                        }
                                    } else {
                                        listener.onFail(null);
                                    }
                                }
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            listener.onExpire("Tài khoản chưa được kích hoạt");
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        } catch (Exception e) {
        }

    }

}
