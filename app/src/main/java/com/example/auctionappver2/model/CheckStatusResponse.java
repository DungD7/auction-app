package com.example.auctionappver2.model;

import java.io.Serializable;

public class CheckStatusResponse implements Serializable {
    String statusSchedule;

    public String getStatus() {
        return statusSchedule;
    }

    public void setStatus(String statusSchedule) {
        this.statusSchedule = statusSchedule;
    }
}
