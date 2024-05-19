package com.example.auctionappver2.model;

import java.io.Serializable;
import java.util.List;

public class GetAuctionScheduleResponse implements Serializable {
    private List<ContentAuctionSchedule> content;

    public List<ContentAuctionSchedule> getContent() {
        return content;
    }

    public void setContent(List<ContentAuctionSchedule> content) {
        this.content = content;
    }
}
