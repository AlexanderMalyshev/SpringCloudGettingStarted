package com.home.controller;

import com.home.data.Post;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.home.repository.PostRepository;

@Slf4j
@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostRepository postRepository;

    @RequestMapping(value="", method= RequestMethod.GET)
    public Iterable<Post> listAll() {
        log.info("received request for listAll");
        return postRepository.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Post getPostById(@PathVariable long id) {
        return postRepository.findOne(id);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity createNew(@RequestBody Post post) {
        postRepository.save(post);
        return new ResponseEntity(post, HttpStatus.CREATED);
    }

    @RequestMapping(value="", method=RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Post post) {
        if (postRepository.exists(post.getId())) {
            postRepository.save(post);
        } else {
            return new ResponseEntity<String>("Post #" + post.getId() + " does not exist.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable long id) {
        if (postRepository.exists(id)) {
            postRepository.delete(id);
        } else {
            return new ResponseEntity<String>("Post #" + id + " does not exist.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
