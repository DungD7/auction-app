package com.example.auctionappver2.view.application;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.util.Log;

import com.example.auctionappver2.firebase.FCMNotificationService;
import com.example.auctionappver2.hepper.DataLocalManager;
import com.google.firebase.messaging.RemoteMessage;

public class MyApplication extends Application {
    public static final String FCM_CHANNEL_ID = "FCM_CHANNEL_ID";
    @Override
    public void onCreate() {
        super.onCreate();
        DataLocalManager.init(getApplicationContext());



    }

}
