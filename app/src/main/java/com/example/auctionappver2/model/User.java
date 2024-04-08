package com.example.auctionappver2.model;

public class User {
    private int id;
    private String username;
    private String email;
    private String fullname;
    private String phone;
    private boolean actived;
    private String createDate;
    private String tokenFcm;

    public User(int id, String username, String email, String fullname, String phone, boolean actived, String createDate, String tokenFcm) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.phone = phone;
        this.actived = actived;
        this.createDate = createDate;
        this.tokenFcm = tokenFcm;
    }
}
