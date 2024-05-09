package com.example.auctionappver2.model;

import java.io.Serializable;

public class SendNewOtpResponse implements Serializable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
