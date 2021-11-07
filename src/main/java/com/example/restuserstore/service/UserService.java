package com.example.restuserstore.service;

import com.example.restuserstore.request.UserCreateRequest;
import com.example.restuserstore.response.UserCreateResponse;
import com.example.restuserstore.response.UserResponse;

/**
 * @author : anisuzzaman
 * @created : 7/11/21, Sunday
 **/
public interface UserService {
    UserCreateResponse createUser(UserCreateRequest userCreateRequest);

    UserResponse getUserById(String id) throws Exception;
}
