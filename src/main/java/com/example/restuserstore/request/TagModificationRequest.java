package com.example.restuserstore.request;

import java.util.ArrayList;

/**
 * @author : anisuzzaman
 * @created : 7/11/21, Sunday
 **/
public class TagModificationRequest {

    private ArrayList<String> tags;
    private String expiry;

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
}
