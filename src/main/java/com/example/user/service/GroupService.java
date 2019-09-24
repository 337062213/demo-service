package com.example.user.service;

import com.example.user.entity.Group;
import com.example.user.vo.GroupUserVo;

import java.util.List;

public interface GroupService {
    
    Group insertGroup(Group group);
    
    Integer deleteGroup(String gId);
    
    Group updateGroup(Group group);
    
    Group findGroupById(String gId);
    
    List<Group> findAllGroup();

    GroupUserVo findGroupUsersByGid(String gid);
    
}
