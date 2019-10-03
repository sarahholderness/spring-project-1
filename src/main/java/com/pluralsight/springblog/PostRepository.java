package com.pluralsight.springblog;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class PostRepository {
    private static final List<Post> ALL_POSTS = Arrays.asList(
            new Post(1, "Spring File Uploads", "This is the body ... ...", "Sarah Holderness", new Date()),
            new Post(2, "Spring User Authentication", "This is the body ... ...", "Sarah Holderness", new Date()),
            new Post(3, "Spring Security", "This is the body ... ...", "Sarah Holderness", new Date()),
            new Post(4, "Spring Boot Testing", "This is the body ... ...", "Sarah Holderness", new Date()),
            new Post(5, "Spring Data REST Configuration", "This is the body ... ...", "Sarah Holderness", new Date())
    );

//    public Post findByTitle(String title) {
//        for(Post post : ALL_POSTS) {
//            if(post.getTitle().equals(title)) {
//                return post;
//            }
//        }
//        return null;
//    }

    public List<Post> getAllPosts() {
        return ALL_POSTS;
    }
}
