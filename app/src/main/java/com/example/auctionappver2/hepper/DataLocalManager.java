package com.example.auctionappver2.hepper;

import android.content.Context;
import android.content.SharedPreferences;

public class DataLocalManager {
    private static final String TOKEN_JWT_LOCAL = "TOKEN_JWT_LOCAL";
    private static DataLocalManager instance;
    private static MySharePreferences mySharePreferences;

    public static void init(Context context) {
        instance = new DataLocalManager();
        mySharePreferences = new MySharePreferences(context);
    }

    public static DataLocalManager getInstance() {
        if (instance == null) {
            instance = new DataLocalManager();
        }
        return instance;
    }

    public static void setTokenJwtLocal(String tokenJwt) {
        DataLocalManager.getInstance().mySharePreferences.putStringValue(TOKEN_JWT_LOCAL, "");
    }

    public static String getTokenJwtLocal() {
        return DataLocalManager.getInstance().mySharePreferences.getStringValue(TOKEN_JWT_LOCAL);
    }
}
