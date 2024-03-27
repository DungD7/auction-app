package com.example.auctionapp.api;

import java.io.Serializable;

public class CoreAppHelper {

    public interface OnCoreAppListener {
        void onSuccess(Serializable result);

        void onFail(Serializable result);

        void onExpire(String message);
    }

}
