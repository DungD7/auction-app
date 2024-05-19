package com.example.auctionappver2.model;

import java.io.Serializable;

public class AddFavoriteProductResponse implements Serializable {
    String defaultMessage;

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}
