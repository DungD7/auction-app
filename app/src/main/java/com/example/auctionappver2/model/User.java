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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActived() {
        return actived;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getTokenFcm() {
        return tokenFcm;
    }

    public void setTokenFcm(String tokenFcm) {
        this.tokenFcm = tokenFcm;
    }
}
