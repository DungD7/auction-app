package com.example.auctionappver2.api;

public class APIConst {
    public static final String BASE_URL = "http://192.168.1.4:8080";
//    public static final String BASE_URL = "http://10.144.14.13:8080";
//    public static final String BASE_URL = "http://10.144.14.91:8080";
    public static final String POST_REGISTER_ACCOUNT = BASE_URL + "/api/user/public/regis";
    public static final String POST_ACTIVE_ACCOUNT = BASE_URL + "/api/user/public/active-account";
    public static final String POST_LOGIN = BASE_URL + "/api/user/public/login";
    public static final String POST_RESEND_OTP = BASE_URL + "/api/user/public/send-new-key-active";
    public static final String GET_SEARCH_PRODUCT = BASE_URL + "/api/product/public/search-product";
    public static final String POST_FORGOT_PASSWORD = BASE_URL + "/api/user/public/request-forgot-password";
    public static final String GET_ALL_CATEGORY = BASE_URL + "/api/category/public/findAll";
    public static final String GET_PRODUCT_BY_CATEGORY = BASE_URL + "/api/product/public/product-by-category";
    public static final String ADD_FAVORITE_PRODUCT = BASE_URL + "/api/favorite/user/add-favorite";
}
