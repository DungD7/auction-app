package com.example.auctionappver2.model;

import java.io.Serializable;
import java.util.List;

public class Product implements Serializable {
    private int id;
    private String name;
    private String imageBanner;
    private double price;
    private String description;
    private String createdDate;
    private String createdTime;
    private boolean deleted;

    private List<ProductImage> productImages;
}
