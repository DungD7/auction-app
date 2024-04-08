package com.example.auctionappver2.api;

public class APIConst {
    public static final String BASE_URL = "http://10.144.14.196:8080";
    public static final String POST_REGISTER_ACCOUNT = BASE_URL + "/api/user/public/regis";
    public static final String POST_ACTIVE_ACCOUNT = BASE_URL + "/api/user/public/active-account";
    public static final String POST_LOGIN = BASE_URL + "/api/user/public/login";
    public static final String POST_RESEND_OTP = BASE_URL + "/api/user/public/send-new-key-active";
}
