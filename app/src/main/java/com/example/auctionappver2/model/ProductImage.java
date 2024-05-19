package com.example.auctionappver2.model;

import java.io.Serializable;

public class ProductImage implements Serializable {
    private int id;
    private String linkImage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }
}
