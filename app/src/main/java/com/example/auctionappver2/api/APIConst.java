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
    public static final String GET_FAVOURITE_PRODUCT = BASE_URL + "/api/favorite/user/find-by-user";
    public static final String DELETE_FAVOURITE_PRODUCT = BASE_URL + "/api/favorite/user/delete";
    public static final String GET_AUCTION_SCHEDULE = BASE_URL + "/api/AuctionSchedule/public/findAll-page";
    public static final String ADD_USER_AUCTION_ROOM = BASE_URL + "/api/auction-schedule-user/user/add";
    public static final String POST_CURRENT_PRICE = BASE_URL + "/api/auction-price/user/current-price";
    public static final String POST_AUCTION = BASE_URL + "/api/auction-price/user/add";
    public static final String GET_CHECK_STATUS = BASE_URL + "/api/AuctionSchedule/public/check-status";
}
