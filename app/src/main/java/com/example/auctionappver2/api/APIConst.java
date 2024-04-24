package com.example.auctionappver2.api;

public class APIConst {
    public static final String BASE_URL = "http://192.168.1.3:8080";
//    public static final String BASE_URL = "http://10.144.14.13:8080";
    public static final String POST_REGISTER_ACCOUNT = BASE_URL + "/api/user/public/regis";
    public static final String POST_ACTIVE_ACCOUNT = BASE_URL + "/api/user/public/active-account";
    public static final String POST_LOGIN = BASE_URL + "/api/user/public/login";
    public static final String POST_RESEND_OTP = BASE_URL + "/api/user/public/send-new-key-active";
    public static final String GET_SEARCH_PRODUCT = BASE_URL + "/api/product/public/search-product";
    public static final String POST_FORGOT_PASSWORD = BASE_URL + "/api/user/public/request-forgot-password";
}
