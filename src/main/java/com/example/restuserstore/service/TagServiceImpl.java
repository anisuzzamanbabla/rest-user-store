package com.example.restuserstore.service;

import com.example.restuserstore.model.Tag;
import com.example.restuserstore.model.User;
import com.example.restuserstore.repository.TagRepository;
import com.example.restuserstore.repository.UserRepository;
import com.example.restuserstore.request.TagModificationRequest;
import com.example.restuserstore.response.UserListResponse;
import com.example.restuserstore.response.UserTag;
import com.example.restuserstore.util.NumberCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author : anisuzzaman
 * @created : 7/11/21, Sunday
 **/
@Service
public class TagServiceImpl implements TagService {

    Logger logger=Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    UserRepository userRepository;

    @Autowired
    TagRepository tagRepository;

    @Override
    public void mapTagWithUser(String id, TagModificationRequest tagModificationRequest) throws Exception {

        if (!NumberCheck.isNumeric(id))
            throw new Exception("Invalid Request");


        Long longID = Long.parseLong(id);
        Optional<User> optionalUser = userRepository.findById(longID);
        if (!optionalUser.isPresent())
            throw new Exception("User Not Found");

        User user = optionalUser.get();


        if (tagModificationRequest.getTags() == null || tagModificationRequest.getTags().size() == 0) {
            throw new Exception("Invalid Request");
        }

        if (tagModificationRequest.getExpiry() == null || !NumberCheck.isNumeric(tagModificationRequest.getExpiry())) {
            throw new Exception("Invalid Request");
        }

        List<Tag> tagList = new ArrayList<>();
        for (String receivedTag : tagModificationRequest.getTags()) {
            Tag tag = new Tag();
            tag.setTagName(receivedTag);
            tag.setExpiry(Long.parseLong(tagModificationRequest.getExpiry()));
            List<User> userList=new ArrayList<>();
            userList.add(user);
            tag.setUsers(userList);
            tagList.add(tag);

        }
        user.setTags(tagList);
        userRepository.save(user);

        logger.info("Tag Updated");

    }

    @Override
    public UserListResponse getUsersByTag(ArrayList<String> tags) throws Exception {

       Optional<List<Tag>> tagOptional=tagRepository.findAllByTagNameIn(tags);
       if(!tagOptional.isPresent()||tagOptional.get().size()==0){
           throw new Exception("No Data Found");
       }

       UserListResponse userListResponse=new UserListResponse();
       List<Tag> tagList=tagOptional.get();
       List<UserTag> userTagList=new ArrayList<>();


       Optional<List<User>>  optionalUserList= userRepository.findByTagsIn(tagList);
        List<User> users=optionalUserList.get();
        for (User user:users) {
            UserTag userTag=new UserTag();
            userTag.setId(user.getId());
            userTag.setName(user.getFirstName()+" "+user.getLastName());
            List<String> userTags=new ArrayList<>();
            for (Tag tag:user.getTags()
                 ){
                userTags.add(tag.getTagName());
            }
            userTag.setTags(userTags);
            userTagList.add(userTag);
        }

        userListResponse.setUsers(userTagList);

        return userListResponse;
    }
}
