package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.service.UserService;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    private User userTemp;

    @Before
    public void before() {
        User user = new User();
        user.setAge(20);
        user.setName("张三");
        user.setGid(UUID.randomUUID().toString().replaceAll("-", ""));
        userTemp = userService.insertUser(user);
    }

    @Test
    public void findUserById() throws Exception {
        String content = mockMvc.perform(get("/user/" + userTemp.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn()
                .getResponse()
                .getContentAsString();
        JSONObject retJson = new JSONObject(content);
        assertEquals(userTemp.getId(), retJson.getString("id"));
    }

    @Test
    public void addUser() throws Exception {
        for(int i=0; i<50; i++ ) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "张三");
            jsonObject.put("age", 20);
            jsonObject.put("gid", "a53433b00ab44e96b9e484b06a24b242");

            String content = this.mockMvc.perform(post("/user/add")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(jsonObject.toString())
                    .accept(MediaType.APPLICATION_JSON_UTF8))
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
            JSONObject retJson = new JSONObject(content);
            assertEquals("张三", retJson.getString("name"));
        }
    }

    @Test
    public void updateUser() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", userTemp.getId());
        jsonObject.put("name", "修改测试");
        jsonObject.put("age", 20);
        jsonObject.put("gid", UUID.randomUUID().toString().replaceAll("-", ""));

        String content = this.mockMvc.perform(post("/user/update")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonObject.toString())
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn()
                .getResponse()
                .getContentAsString();

        JSONObject retJson = new JSONObject(content);
        assertEquals("修改测试", retJson.getString("name"));
    }

    @Test
    public void deleteUser() throws Exception {
        mockMvc.perform(get("/user/delete/" + userTemp.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertNull(userService.findUserById(userTemp.getId()));
    }

    @Test
    public void findAllUser() {
    }

    @Test
    public void findUserGroupVo() {
    }

    @Test
    public void findUserByCondition() {
    }
}