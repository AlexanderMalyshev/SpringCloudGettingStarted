package com.home.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Comment {
    private long id;
    private String message;
    private Post post;

    public Comment(Post post, String message) {
        this.post = post;
        this.message = message;
    }
}
