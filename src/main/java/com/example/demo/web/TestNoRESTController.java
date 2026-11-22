package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestNoRESTController {

    @GetMapping("/index")
    public String mainPage(){
        return "index.html";
    }
}
