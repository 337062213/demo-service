 package com.example.util.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.user.DemoServiceApplication;

 @RunWith(SpringRunner.class)
 @SpringBootTest(classes = {DemoServiceApplication.class})
 @AutoConfigureMockMvc
 public class UserControllerTest {

     @Autowired
     private MockMvc mvc;

     @Test
     public void testHome() throws Exception {
         mvc.perform(MockMvcRequestBuilders.get("/api/user/findByParams")).andExpect(MockMvcResultMatchers.status().isOk());
     }
 }
