package me.gaopeng.springboot.controller;

import me.gaopeng.springboot.bean.User;
import me.gaopeng.springboot.mapper.UserMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by gaopeng on 2017/10/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

    private MockMvc mvc;

    @Autowired
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void index() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Spring Boot!"));
    }

    @Test
    public void testMysqlInsert() {
        userMapper.insert("test", 1010);
    }

    @Test
    public void testMysqlMapInsert() {
        Map userInfo = new HashMap();
        userInfo.put("name", "map");
//        userInfo.put("age", "123");
        userMapper.insertByMap(userInfo);
    }

    @Test
    public void testMysqlSelect() {
        try {
            User u = userMapper.findByName("map");
            if (u == null) {
                System.out.println("not found");
            } else {
                System.out.println("found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}