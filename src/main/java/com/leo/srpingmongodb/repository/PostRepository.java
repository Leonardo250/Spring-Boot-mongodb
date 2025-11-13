package com.leo.srpingmongodb.repository;

import com.leo.srpingmongodb.domain.Post;
import com.leo.srpingmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
}
