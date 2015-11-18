package com.home.controller;

import com.home.data.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/gateway")
public class BlogGatewayController {
    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @RequestMapping("/messages")
    public List<String> getAllPosts() {
        ParameterizedTypeReference<List<Post>> ptr = new ParameterizedTypeReference<List<Post>>() { };
        final ResponseEntity<List<Post>> response = restTemplate.exchange("http://restful-blog/posts", HttpMethod.GET, null, ptr);
        return response.getBody().stream().map(Post::getMessage).collect(Collectors.toList());
    }


}
