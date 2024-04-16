package com.example.auctionappver2.model;

import java.io.Serializable;

public class SearchProductResponse implements Serializable {
    private Content content;
}

class Content {
    private int id;
    private String name;
    private String imageBanner;
    private double price;
    private String description;
    private String createdDate;
    private String createdTime;
}
