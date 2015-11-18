package com.home.data;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
public class Post {
    private long id;
    private String title;
    private String message;

    private List<Comment> comments = new ArrayList<>();

    public Post(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public boolean addComment(Comment comment) {
        return comments.add(comment);
    }

    public boolean removeComment(Comment comment) {
        return this.comments.remove(comment);
    }

    public Iterable<Comment> getComments() {
        return Collections.unmodifiableList(comments);
    }
}
