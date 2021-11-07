package com.example.restuserstore.controller;

import com.example.restuserstore.request.TagModificationRequest;
import com.example.restuserstore.request.UserCreateRequest;
import com.example.restuserstore.response.EmptyJsonResponse;
import com.example.restuserstore.response.UserCreateResponse;
import com.example.restuserstore.response.UserListResponse;
import com.example.restuserstore.response.UserResponse;
import com.example.restuserstore.service.TagService;
import com.example.restuserstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author : anisuzzaman
 * @created : 7/11/21, Sunday
 **/

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private TagService tagService;

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody UserCreateRequest userCreateRequest) {

        UserCreateResponse userCreateResponse = userService.createUser(userCreateRequest);

        return new ResponseEntity<>(userCreateResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "users/{id}", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getUser(@PathVariable String id) throws Exception {

        UserResponse userResponse = userService.getUserById(id);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "users/{id}/tags", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<?> mapTagWithUser(@RequestBody TagModificationRequest tagModificationRequest, @PathVariable String id) throws Exception {

        tagService.mapTagWithUser(id,tagModificationRequest);

        return new ResponseEntity<>(new EmptyJsonResponse(),HttpStatus.OK);
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getUsersByTag(@RequestParam(name = "tags") ArrayList<String> tags) throws Exception {

        UserListResponse  userListResponse=tagService.getUsersByTag(tags);

        return new ResponseEntity<UserListResponse>(userListResponse, HttpStatus.OK);
    }
}
