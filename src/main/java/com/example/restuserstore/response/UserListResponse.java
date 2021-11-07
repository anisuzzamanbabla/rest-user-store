package com.example.restuserstore.response;

import java.util.List;

/**
 * @author : anisuzzaman
 * @created : 7/11/21, Sunday
 **/
public class UserListResponse {

    List<UserTag> users;

    public List<UserTag> getUsers() {
        return users;
    }

    public void setUsers(List<UserTag> users) {
        this.users = users;
    }

}
