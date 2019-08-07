package com.example.user.service.impl;

import com.example.user.entity.Group;
import com.example.user.mapper.GroupMapper;
import com.example.user.service.GroupService;
import com.example.user.vo.GroupUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public Group insertGroup(Group group) {
        group.setId(UUID.randomUUID().toString().replaceAll("-",""));
        groupMapper.insertGroup(group);
        return groupMapper.findGroupById(group.getId());
    }

    @Override
    public void deleteGroup(String uId) {
        groupMapper.deleteGroup(uId);
    }

    @Override
    public Group updateGroup(Group group) {
        groupMapper.updateGroup(group);
        return groupMapper.findGroupById(group.getId());
    }

    @Override
    public Group findGroupById(String uId) {
        return groupMapper.findGroupById(uId);
    }

    @Override
    public List<Group> findAllGroup() {
        return groupMapper.findAllGroup();
    }

    @Override
    public GroupUserVo findGroupUsersByGid(String gid) {

        GroupUserVo groupUserVo = groupMapper.findGroupUsersByGid(gid);
        return groupUserVo;

    }
}
