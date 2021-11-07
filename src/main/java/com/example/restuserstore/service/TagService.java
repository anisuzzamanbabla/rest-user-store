package com.example.restuserstore.service;

import com.example.restuserstore.request.TagModificationRequest;
import com.example.restuserstore.response.UserListResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author : anisuzzaman
 * @created : 7/11/21, Sunday
 **/

public interface TagService {
    void mapTagWithUser(String id, TagModificationRequest tagModificationRequest) throws Exception;

    UserListResponse getUsersByTag(ArrayList<String> tags) throws Exception;
}
