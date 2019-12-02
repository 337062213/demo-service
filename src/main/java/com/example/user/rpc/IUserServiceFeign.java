 package com.example.user.rpc;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.user.entity.Group;
import com.example.user.entity.User;
import com.example.user.vo.GroupUserVo;
import com.example.user.vo.Page;
import com.example.user.vo.UserGroupVo;

@FeignClient(value="demo-service-rpc")
 public interface IUserServiceFeign{
     
     @RequestMapping(value = "/api/user/addUser",method = RequestMethod.POST)
     public User insertUser(@RequestBody User user);

     @RequestMapping(value = "/api/user/deleteUser/{uid}",method = RequestMethod.GET)
     public void deleteUser(@PathVariable("uid") String uid);

     @RequestMapping(value = "/api/user/updateUser",method = RequestMethod.POST)
     public User updateUser(@RequestBody User user);

     @RequestMapping(value = "/api/user/{uid}",method = RequestMethod.GET)
     public User findUserById(@PathVariable("uid") String uid);

     @RequestMapping(value = "/api/user/findAllUserByPage",method = RequestMethod.GET)
     public List<User> findAllUserByPage(@RequestBody Page page);

     @RequestMapping(value = "/api/user/find/{uid}",method = RequestMethod.GET)
     public UserGroupVo findUserGroupVo(@PathVariable("uid") String uid);

     @RequestMapping(value = "/api/user/findUserByCondition",method = RequestMethod.GET)
     public List<User> findUserByCondition(@RequestBody User user);

     @RequestMapping(value = "/api/user/findAllUserByGroupId",method = RequestMethod.GET)
     public List<User> findAllUser(@RequestParam(defaultValue = "") String name,
                            @RequestParam(defaultValue = "") String gid);
   
     @RequestMapping(value = "/api/user/findAllUser",method = RequestMethod.GET)
     public List<User> findAllUser();
     
     @RequestMapping(value = "/api/hello",method = RequestMethod.GET)
     public String sayHiFromClientOne(@RequestParam(value = "name") String name);
     
     @RequestMapping(value = "/api/group//{id}",method = RequestMethod.GET)
     public Group findGroupById(@PathVariable("id") String id);
     
     @RequestMapping(value = "/api/group/add",method = RequestMethod.POST)
     public Group addGroup(@RequestBody Group group);
     
     @RequestMapping(value = "/api/group/update",method = RequestMethod.POST)
     public Group updateGroup(@RequestBody Group group);
     
     @RequestMapping(value = "/api/group/delete/{id}",method = RequestMethod.GET)
     void deleteGroup(@PathVariable(value = "id") String name);
     
     @RequestMapping(value = "/api/group/",method = RequestMethod.GET)
     public List<Group> findAllGroup();
     
     @RequestMapping(value = "/api/group//find/{id}",method = RequestMethod.GET)
     public GroupUserVo findGroupUsersByGid(@PathVariable(value = "id") String name);
 }
