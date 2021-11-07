package com.example.restuserstore.repository;

import com.example.restuserstore.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : anisuzzaman
 * @created : 7/11/21, Sunday
 **/
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<List<Tag>> findAllByTagNameIn(ArrayList<String> tags);
}
