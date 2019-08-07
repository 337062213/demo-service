package com.example.user.controller;

import com.example.user.entity.Group;
import com.example.user.service.GroupService;
import com.example.user.vo.GroupUserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GroupService groupService;

    @GetMapping("/{gid}")
    public Group findGroupById(@PathVariable("gid") String gid) {
        Group group = groupService.findGroupById(gid);
        logger.info("findGroupById =>" + group.toString());
        return group;
    }

    @PostMapping("/add")
    public Group addGroup(@RequestBody Group group) {
        return groupService.insertGroup(group);
    }

    @PostMapping("/update")
    public Group updateGroup(@RequestBody Group group) {
        return groupService.updateGroup(group);
    }

    @GetMapping("/delete/{gid}")
    public void deleteGroup(@PathVariable("gid") String gid) {
        groupService.deleteGroup(gid);
    }

    @GetMapping("")
    public List<Group> findAllGroup() {
        List<Group> groups = groupService.findAllGroup();
        logger.info("findAllGroup =>" + groups.toString());
        return groups;
    }

    @GetMapping("/find/{gid}")
    public GroupUserVo findGroupUsersByGid(@PathVariable("gid") String gid) {
        GroupUserVo groupUserVo = groupService.findGroupUsersByGid(gid);
        logger.info("findGroupUsersByGid =>" + groupUserVo.toString());
        return groupUserVo;
    }

}
