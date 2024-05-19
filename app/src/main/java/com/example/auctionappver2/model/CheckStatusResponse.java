package com.example.auctionappver2.model;

import java.io.Serializable;

public class CheckStatusResponse implements Serializable {
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
