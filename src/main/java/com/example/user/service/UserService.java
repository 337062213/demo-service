package com.example.user.service;

import com.example.user.entity.User;
import com.example.user.vo.Page;
import com.example.user.vo.UserGroupVo;

import java.util.List;

public interface UserService {

    User insertUser(User user);

    Integer deleteUser(String uId);

    User updateUser(User user);

    User findUserById(String uId);

    List<User> findAllUser(Page page);

    UserGroupVo findUserGroupVo(String uId);

    List<User> findUserByCondition(User user);

    List<User> findAllUser(String name, String gid);
}
