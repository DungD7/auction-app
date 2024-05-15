package com.example.auctionappver2.hepper;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharePreferences {
    private static final String MY_SHARE_PREFERENCES = "MY_SHARE_PREFERENCES";
    private Context mContext;

    public MySharePreferences(Context mContext) {
        this.mContext = mContext;
    }

    public void putStringValue(String key, String value) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SHARE_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getStringValue(String key) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SHARE_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,"");
    }
}
