package com.example.restuserstore.service;

import com.example.restuserstore.model.User;
import com.example.restuserstore.repository.UserRepository;
import com.example.restuserstore.request.UserCreateRequest;
import com.example.restuserstore.response.UserCreateResponse;
import com.example.restuserstore.response.UserResponse;
import com.example.restuserstore.util.NumberCheck;
import com.example.restuserstore.util.PasswordAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author : anisuzzaman
 * @created : 7/11/21, Sunday
 **/

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    Logger logger=Logger.getLogger(UserServiceImpl.class.getName());

    @Override
    public UserCreateResponse createUser(UserCreateRequest userCreateRequest) {
        User user = new User();
        user.setFirstName(userCreateRequest.getFirstName());
        user.setLastName(userCreateRequest.getLastName());
        PasswordAuthentication passwordAuthentication = new PasswordAuthentication(16);
        passwordAuthentication.hash(userCreateRequest.getPassword());
        user.setPassword(userCreateRequest.getPassword());

        userRepository.save(user);

        logger.info("User Saved");

        UserCreateResponse userCreateResponse = new UserCreateResponse();
        userCreateResponse.setId(user.getId());
        return userCreateResponse;
    }

    @Override
    public UserResponse getUserById(String id) throws Exception {
        if (!NumberCheck.isNumeric(id))
            throw new Exception("Invalid Request");
        Long longID = Long.parseLong(id);
        Optional<User> optionalUser=userRepository.findById(longID);
        if(!optionalUser.isPresent())
            throw new Exception("User Not Found");

        logger.info("User Found");

        User user=optionalUser.get();
        UserResponse  userResponse=new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getFirstName()+" "+user.getLastName());
        return userResponse;
    }


}
