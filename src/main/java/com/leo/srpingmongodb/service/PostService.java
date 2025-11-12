package com.leo.srpingmongodb.service;

import com.leo.srpingmongodb.domain.Post;
import com.leo.srpingmongodb.domain.User;
import com.leo.srpingmongodb.dto.UserDTO;
import com.leo.srpingmongodb.repository.PostRepository;
import com.leo.srpingmongodb.repository.UserRepository;
import com.leo.srpingmongodb.service.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findByID(String id) {
        Post user = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return user;
    }


}
