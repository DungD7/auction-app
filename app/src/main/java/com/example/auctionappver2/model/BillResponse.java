package com.example.auctionappver2.model;

import java.io.Serializable;

public class BillResponse implements Serializable {
    int id;
    String createdDate;
    String createdTime;
    double price;

    ContentAuctionSchedule auctionSchedule;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
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
