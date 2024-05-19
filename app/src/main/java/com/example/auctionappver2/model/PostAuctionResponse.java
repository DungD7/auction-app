package com.example.auctionappver2.model;

import java.io.Serializable;

public class PostAuctionResponse implements Serializable {
    int id;
    double price;
    ContentAuctionSchedule auctionSchedule;

    String defaultMessage;

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ContentAuctionSchedule getAuctionSchedule() {
        return auctionSchedule;
    }

    public void setAuctionSchedule(ContentAuctionSchedule auctionSchedule) {
        this.auctionSchedule = auctionSchedule;
    }
}
