package com.example.restuserstore.model;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.Size;

/**
 * @author : anisuzzaman
 * @created : 7/11/21, Sunday
 **/
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 120)
    private String firstName;
    @Size(max = 120)
    private String lastName;

    @Size(max = 120)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "tag_id")
    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
