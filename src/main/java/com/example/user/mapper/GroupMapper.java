package com.example.user.mapper;

import com.example.user.entity.Group;
import com.example.user.vo.GroupUserVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface GroupMapper {
    
    @Insert("insert into t_group(id,name) values(#{id},#{groupName})")
    void insertGroup(Group group);

    @Delete("delete from t_group where id = #{gId}")
    void deleteGroup(String gId);

    @Update("update t_group set name=#{groupName} where id=#{id}")
    int updateGroup(Group group);

    @Select("select * from t_group where id = #{id}")
    @Results({
            @Result(property = "groupName",  column = "name", javaType = String.class),
    })
    Group findGroupById(@Param("id") String uId);

    @Select("select * from t_group")
    @Results({
            @Result(property = "groupName",  column = "name", javaType = String.class),
    })
    List<Group> findAllGroup();

    @Select("select * from t_group where id=#{gid}")
    @Results({
            @Result(property="gid",column="id"),
            @Result(property = "groupName",  column = "name", javaType = String.class),
            //users映射List<User> users，many=@Many是调用关联查询方法，"id"是关联查询条件，FetchType.LAZY是延迟加载  这里不能延迟加载  json序列化会错误
            @Result(property="users",column="id", many=@Many(select="com.example.user.mapper.UserMapper.findUserByGid",fetchType= FetchType.DEFAULT))
    })
    GroupUserVo findGroupUsersByGid(String gid);

}
