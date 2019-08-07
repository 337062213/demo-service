package com.example.user.service.impl;

import com.example.user.entity.User;
import com.example.user.mapper.UserMapper;
import com.example.user.service.UserService;
import com.example.user.vo.Page;
import com.example.user.vo.UserGroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User insertUser(User user) {
        user.setId(UUID.randomUUID().toString().replaceAll("-",""));
        userMapper.insertUser(user);
        return userMapper.findUserById(user.getId());
    }

    @Override
    public void deleteUser(String uId) {
        userMapper.deleteUser(uId);
    }

    @Override
    public User updateUser(User user) {
        userMapper.updateUser(user);
        return userMapper.findUserById(user.getId());
    }

    @Override
    public User findUserById(String uId) {
        return userMapper.findUserById(uId);
    }

    @Override
    public List<User> findAllUser(Page page) {
        return userMapper.findAllUser(page);
    }

    @Override
    public UserGroupVo findUserGroupVo(String uId) {
        return userMapper.findUserGroupVo(uId);
    }

    @Override
    public List<User> findUserByCondition(User user) {
        List<User> userList = userMapper.findUserByCondition(user);
        return userList;
    }

    @Override
    public List<User> findAllUser(String name, String gid) {
        return userMapper.findAllUserTotal(name, gid);
    }
}
