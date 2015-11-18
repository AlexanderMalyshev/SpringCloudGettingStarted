package com.home.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String message;

    @JsonBackReference
    @ManyToOne
    private Post post;

    public Comment(Post post, String message) {
        this.post = post;
        this.message = message;
    }
}
