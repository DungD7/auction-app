package com.example.auctionappver2.model;

import java.io.Serializable;

public class PostAddUserResponse implements Serializable {
    int id;
    ContentAuctionSchedule auctionSchedule;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContentAuctionSchedule getAuctionSchedule() {
        return auctionSchedule;
    }

    public void setAuctionSchedule(ContentAuctionSchedule auctionSchedule) {
        this.auctionSchedule = auctionSchedule;
    }
}
