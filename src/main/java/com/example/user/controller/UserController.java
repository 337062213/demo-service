package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.service.UserService;
import com.example.user.vo.UserGroupVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping("/{uid}")
    public User findUserById(@PathVariable("uid") String uid) {
        User user = userService.findUserById(uid);
        logger.info("findUserById =>" + user.toString());
        return user;
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user) {
        return userService.insertUser(user);

    }

    @PostMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/delete/{uid}")
    public void deleteUser(@PathVariable("uid") String uid) {
        userService.deleteUser(uid);

    }

    @GetMapping("/findByParams")
    public List<User> findAllUser(@RequestParam(defaultValue = "") String name,
                                  @RequestParam(defaultValue = "") String gid) {

        List<User> users = userService.findAllUser(name,gid);
        return users;

    }

    @GetMapping("/find/{uid}")
    public UserGroupVo findUserGroupVo(@PathVariable("uid") String uid) {
        UserGroupVo userGroupVo = userService.findUserGroupVo(uid);
        logger.info("findUserGroupVo =>" + userGroupVo.toString());
        return userGroupVo;
    }

    @GetMapping("/find")
    public List<User> findUserByCondition(User user) {
        return userService.findUserByCondition(user);
    }


}
