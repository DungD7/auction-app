package com.example.auctionappver2.model;

import java.io.Serializable;

public class PostRegisterAccountRequest implements Serializable {
    private String email;
    private String password;
    private String fullname;
    private String phone;
    private String tokenFcm;

    public PostRegisterAccountRequest(String email, String password, String fullname, String phone, String tokenFcm) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
        this.tokenFcm = tokenFcm;
    }
}
