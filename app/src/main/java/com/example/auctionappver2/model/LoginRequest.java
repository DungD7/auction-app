package com.example.auctionappver2.model;

import java.io.Serializable;

public class LoginRequest implements Serializable {
    private String username;
    private String password;
    private String tokenFcm;

    public LoginRequest(String username, String password, String tokenFcm) {
        this.username = username;
        this.password = password;
        this.tokenFcm = tokenFcm;
    }
}
