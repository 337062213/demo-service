package com.example.user.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {

    private String fid;

    private String name;

    private Integer age;
    
    private String sex;
    
    private String address;

    private String gid;
    
    @JsonFormat(timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date creatTime; 
    @JsonFormat(timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public User() {
        super();
    }  

    public User(String fid, String name, Integer age, String sex, String address, String gid, Date creatTime,
        Date updateTime) {
        super();
        this.fid = fid;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.gid = gid;
        this.creatTime = creatTime;
        this.updateTime = updateTime;
    }
    
    public Date getCreatTime() {
        return creatTime;
    }


    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }


    public Date getUpdateTime() {
        return updateTime;
    }


    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "User [fid=" + fid + ", name=" + name + ", age=" + age + ", sex=" + sex + ", address=" + address
            + ", gid=" + gid + ", creatTime=" + creatTime + ", updateTime=" + updateTime + "]";
    }    

}
