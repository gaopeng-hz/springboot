package me.gaopeng.springboot.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gaopeng on 2017/10/11.
 */
@RestController
public class HelloController {

    @ApiOperation(value = "欢迎语")
    @GetMapping("/")
    public String index() {
        return "Hello Spring Boot!";
    }
}
