package com.example.user.utils;

import java.util.List;

public class TreeTemp {

    private String id;

    private String pid;

    private String name;

    private List<TreeTemp> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeTemp> getChildren() {
        return children;
    }

    public void setChildren(List<TreeTemp> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeTemp{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", children=" + children +
                '}';
    }
}
