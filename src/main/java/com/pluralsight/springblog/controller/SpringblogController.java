package com.pluralsight.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringblogController {

    @RequestMapping("/")
    //@ResponseBody
    public String listPosts() {
        //return "Hello World";
        return "home";
    }
}
