package com.mypack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
   /* @GetMapping("/") // Jab aap localhost:8080 kholenge
    public String showIndex() {
        return "index";
    }*/

    @GetMapping("/home") // Jab aap localhost:8080/home kholenge
    public String showHome() {
        return "index";
    }
}
