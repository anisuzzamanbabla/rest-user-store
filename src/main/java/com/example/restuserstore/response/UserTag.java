package com.example.restuserstore.response;

import java.util.List;

/**
 * @author : anisuzzaman
 * @created : 7/11/21, Sunday
 **/

public class UserTag {
    private Long id;
    private String name;
    private List<String> tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
