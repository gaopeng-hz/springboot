package me.gaopeng.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gaopeng on 2017/10/11.
 */
@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        return "Hello Spring Boot!";
    }
}
