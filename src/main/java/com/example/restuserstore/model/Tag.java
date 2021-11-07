package com.example.restuserstore.model;

import javax.persistence.*;
import java.util.List;

/**
 * @author : anisuzzaman
 * @created : 7/11/21, Sunday
 **/

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long expiry;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExpiry() {
        return expiry;
    }

    public void setExpiry(Long expiry) {
        this.expiry = expiry;
    }

    @ManyToMany(mappedBy = "tag")
    private List<User> users;
}
