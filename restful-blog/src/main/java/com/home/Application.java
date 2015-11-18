package com.home;

import com.home.data.Comment;
import com.home.data.Post;
import com.home.repository.CommentRepository;
import com.home.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.home")
public class Application implements CommandLineRunner {
    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    public static void main(String[] args) {
        ConfigurableApplicationContext cac = SpringApplication.run(Application.class, args);
        cac.registerShutdownHook();
    }

    @Override
    public void run(String... strings) throws Exception {

        Post post1 = new Post("My Post #1", "This post totally rocks v.1");
        Post post2 = new Post("My Post #2", "This post totally rocks v.2");
        Post post3 = new Post("My Post #3", "This post totally rocks v.3");

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);

        Comment c1 = new Comment(post1, "Comment1");
        Comment c2 = new Comment(post1, "Comment2");
        Comment c3 = new Comment(post1, "Comment3");
        Comment c4 = new Comment(post3, "Comment1");

        commentRepository.save(c1);
        commentRepository.save(c2);
        commentRepository.save(c3);
        commentRepository.save(c4);

        post1.addComment(c1);
        post1.addComment(c2);
        post1.addComment(c3);
        post3.addComment(c4);

        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
    }

}
