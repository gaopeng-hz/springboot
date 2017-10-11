package me.gaopeng.springboot.controller;

import io.swagger.annotations.ApiOperation;
import me.gaopeng.springboot.MyException;
import me.gaopeng.springboot.bean.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.condition.ConsumesRequestCondition;

/**
 * Created by gaopeng on 2017/10/11.
 */
@RestController
public class HelloController {

    @ApiOperation(value = "欢迎语")
    @GetMapping("/")
    public String index() throws Exception {
        try {
            int m = 100/0;
        } catch (ArithmeticException e) {
            throw new MyException(e.getMessage());
        }

        return "Hello world!";
    }

    @GetMapping("/{name}")
    public String greet(@PathVariable String name) {
        return "Welcome " + name + "!";
    }

    @PostMapping(value = "/user", consumes = "application/x-www-form-urlencoded")
    public User newUser(@RequestParam String name, @RequestParam Integer age) {
        System.out.println("------------ new user start ------------------");
        System.out.println("new user with name: " + name + "; age: " + age + ";");
        System.out.println("------------ new user end ------------------");

        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }


    @PostMapping("/jsonuser")
    public User newJsonUser(@RequestBody User user) {
        System.out.println("------------ new user start ------------------");
        System.out.println("new json user with name: " + user.getName() + "; age: " + user.getAge() + ";");
        System.out.println("------------ new user end ------------------");
        return user;
    }

}
