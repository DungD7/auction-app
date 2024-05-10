package com.example.auctionappver2.model;

import java.io.Serializable;
import java.util.List;

public class GetProductByCategoryResponse implements Serializable {
    private List<Product> content;

    public List<Product> getContent() {
        return content;
    }

    public void setContent(List<Product> content) {
        this.content = content;
    }
}
