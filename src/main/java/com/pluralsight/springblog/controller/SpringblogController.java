package com.pluralsight.springblog.controller;

import com.pluralsight.springblog.Post;
import com.pluralsight.springblog.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SpringblogController {

    @Autowired
    PostRepository postRepository;

    @RequestMapping("/")
    public String listPosts(ModelMap modelMap) {
        List<Post> postList = postRepository.getAllPosts();
        modelMap.put("posts", postList);
        return "home";
    }
}
