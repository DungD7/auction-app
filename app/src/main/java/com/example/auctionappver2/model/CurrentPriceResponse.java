package com.example.auctionappver2.model;

import java.io.Serializable;

public class CurrentPriceResponse implements Serializable {
    double currentPrice;

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
