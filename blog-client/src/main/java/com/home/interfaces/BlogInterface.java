package com.home.interfaces;

import com.home.data.Post;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("restful-blog")
public interface BlogInterface {
    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    public List<Post> getAllPosts();

}
