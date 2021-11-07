package com.example.restuserstore.repository;

import com.example.restuserstore.model.Tag;
import com.example.restuserstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author : anisuzzaman
 * @created : 7/11/21, Sunday
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<List<User>> findByTagsIn(List<Tag> tagList);
}
