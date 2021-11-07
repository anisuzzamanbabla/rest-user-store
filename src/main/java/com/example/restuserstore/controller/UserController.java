package com.example.restuserstore.controller;

import com.example.restuserstore.request.TagModificationRequest;
import com.example.restuserstore.request.UserCreateRequest;
import com.example.restuserstore.response.*;
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
    ResponseEntity<?> getUser(@PathVariable String id) {

        UserResponse userResponse = null;
        try {
            userResponse = userService.getUserById(id);
        } catch (Exception e) {
            ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage());
            return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "users/{id}/tags", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<?> mapTagWithUser(@RequestBody TagModificationRequest tagModificationRequest, @PathVariable String id) {
        try {
            tagService.mapTagWithUser(id, tagModificationRequest);
        } catch (Exception e) {
            ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage());
            return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new EmptyJsonResponse(), HttpStatus.OK);
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<?> getUsersByTag(@RequestParam(name = "tags") ArrayList<String> tags) {
        UserListResponse userListResponse = null;

        try {
            userListResponse = tagService.getUsersByTag(tags);
        } catch (Exception e) {
            ExceptionResponse exceptionResponse = new ExceptionResponse(e.getMessage());
            return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<UserListResponse>(userListResponse, HttpStatus.OK);
    }
}
