 package com.example.util.test;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.user.DemoServiceApplication;

 @RunWith(value = SpringRunner.class)
 @SpringBootTest(classes = {DemoServiceApplication.class})
 public class JasyptApplicationTests {

     @Autowired
     private StringEncryptor stringEncryptor;

     @Test
     public void contextLoads() {
         //加密方法
         System.out.println(stringEncryptor.encrypt("123456"));
         System.out.println(stringEncryptor.encrypt("123456"));
         //解密方法
         System.out.println(stringEncryptor.decrypt("uaNBj4ZmzCD83uedRYUXqQ=="));
         System.out.println(stringEncryptor.decrypt("oKBQENfbbQiMyPvECAgPGA=="));
     }

 }
