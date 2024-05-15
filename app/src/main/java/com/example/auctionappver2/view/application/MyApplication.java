package com.example.auctionappver2.view.application;

import android.app.Application;

import com.example.auctionappver2.hepper.DataLocalManager;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DataLocalManager.init(getApplicationContext());
    }
}
