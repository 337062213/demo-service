package com.example.user.controller;

import com.example.user.entity.Group;
import com.example.user.service.GroupService;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GroupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GroupService groupService;

    private Group groupTemp;

    @Before
    public void before() {
        Group group = new Group();
        group.setGroupName("测试组");
        groupTemp = groupService.insertGroup(group);
    }

    @After
    public void after() {

    }

    @Test
    public void findGroupById() throws Exception {
        String content = mockMvc.perform(get("/group/" + groupTemp.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn()
                .getResponse()
                .getContentAsString();
        JSONObject retJson = new JSONObject(content);
        assertEquals(groupTemp.getId(), retJson.getString("id"));
    }

    @Test
    public void addGroup() throws Exception {

//        Group group = new Group();
//        group.setGroupName("一组");

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("groupName", "测试组一");

        String content = this.mockMvc.perform(post("/group/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonObject.toString())
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn()
                .getResponse()
                .getContentAsString();
        JSONObject retJson = new JSONObject(content);
        assertEquals("测试组一", retJson.getString("groupName"));
    }

    @Test
    public void updateGroup() throws Exception {

        groupTemp.setGroupName("修改测试组");
        String content = this.mockMvc.perform(post("/group/update")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(groupTemp.toString())
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn()
                .getResponse()
                .getContentAsString();

        JSONObject retJson = new JSONObject(content);
        assertEquals("修改测试组", retJson.getString("groupName"));
    }

    @Test
    public void deleteGroup() throws Exception {
        mockMvc.perform(get("/group/delete/" + groupTemp.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertNull(groupService.findGroupById(groupTemp.getId()));
    }

    @Test
    public void findAllGroup() {
    }

    @Test
    public void findGroupUsersByGid() {
    }
}