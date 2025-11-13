package com.leo.srpingmongodb.resources;

import com.leo.srpingmongodb.domain.Post;
import com.leo.srpingmongodb.domain.User;
import com.leo.srpingmongodb.dto.UserDTO;
import com.leo.srpingmongodb.resources.util.URL;
import com.leo.srpingmongodb.service.PostService;
import com.leo.srpingmongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResouce {

    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findByID(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam (value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> list  = service.findByysTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam (value = "text", defaultValue = "") String text, @RequestParam (value = "minDate", defaultValue = "") String minDate,@RequestParam (value = "maxDate", defaultValue = "")String maxDate){
        text = URL.decodeParam(text);
        Date min = URL.covertDate(minDate, new Date(0L));
        Date max = URL.covertDate(maxDate, new Date(0L));
        List<Post> list  = service.fullSearch(text,min,max);
        return ResponseEntity.ok().body(list);
    }


}
