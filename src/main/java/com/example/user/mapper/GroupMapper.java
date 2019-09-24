package com.example.user.mapper;

import com.example.user.entity.Group;
import com.example.user.vo.GroupUserVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface GroupMapper {
    
    @Insert("insert into p_group(id, name, creatTime, updateTime) values(#{id}, #{groupName}, #{creatTime}, #{updateTime})")
    void insertGroup(Group group);

    @Delete("delete from p_group where id = #{gId}")
    Integer deleteGroup(String gId);

    @Update("update p_group set name=#{groupName}, updateTime=#{updateTime} where id=#{id}")
    int updateGroup(Group group);

    @Select("select * from p_group where id = #{id}")
    @Results({
            @Result(property = "groupName",  column = "name", javaType = String.class),
    })
    Group findGroupById(@Param("id") String uId);

    @Select("select * from p_group")
    @Results({
            @Result(property = "groupName",  column = "name", javaType = String.class),
    })
    List<Group> findAllGroup();

    @Select("select * from p_group where id=#{gid}")
    @Results({
            @Result(property="gid",column="id"),
            @Result(property = "groupName",  column = "name", javaType = String.class),
            //users映射List<User> users，many=@Many是调用关联查询方法，"id"是关联查询条件，FetchType.LAZY是延迟加载  这里不能延迟加载  json序列化会错误
            @Result(property="users",column="id", many=@Many(select="com.example.user.mapper.UserMapper.findUserByGid",fetchType= FetchType.DEFAULT))
    })
    GroupUserVo findGroupUsersByGid(String gid);

}
