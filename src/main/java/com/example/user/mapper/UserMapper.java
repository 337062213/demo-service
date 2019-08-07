package com.example.user.mapper;

import com.example.user.entity.User;
import com.example.user.vo.Page;
import com.example.user.vo.UserGroupVo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into t_user(id, name, age, gid) values(#{id}, #{name}, #{age}, #{gid})")
//    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insertUser(User user);

    @Delete("delete from t_user where id = #{uId}")
    void deleteUser(String uId);

    @Update("update t_user set name=#{name},age=#{age},gid=#{gid} where id=#{id}")
    int updateUser(User user);

    @Select("select * from t_user where id = #{id}")
    User findUserById(@Param("id") String uId);

    @Select("select * from t_user limit #{pageSize} offset #{pageSize} * #{pageNo}")
    List<User> findAllUser(Page page);

    @Select("select u.*,g.name as groupname from t_user u left join t_group g on u.gid=g.id where u.id=#{id}")
    @Results({
            @Result(property = "uid",  column = "id", javaType = String.class),
            @Result(property = "groupName",  column = "groupname", javaType = String.class),
    })
    UserGroupVo findUserGroupVo(String uid);

    @Select("select * from t_user where gid=#{gid}")
    List<User> findUserByGid(String gid);


    /**
     * 根据id age gid 查找用户
     */
    @SelectProvider(type = mybatisSql.class, method = "findUserByCondition")
    List<User> findUserByCondition(User user);

//    @Select("select * from t_user order by id")
    @SelectProvider(type = mybatisSql.class, method = "findAllUserTotal")
    List<User> findAllUserTotal(String name, String gid);


    class mybatisSql {
        public String findUserByCondition(User user) {

            return new SQL(){{
                SELECT("*");
                FROM("t_user");
                if(user.getId() != null) {
                    WHERE("id = #{id}");
                }
                if(user.getAge() != null) {
                    WHERE("age = #{age}");
                }
                if(user.getGid() != null) {
                    WHERE("gid = #{gid}");
                }

            }}.toString();
        };

        public String findAllUserTotal(String name, String gid) {

            return new SQL(){{
                SELECT("*");
                FROM("t_user");
                if(!StringUtils.isEmpty(name)) {
                    WHERE("name like #{name}");
                }
                if(!StringUtils.isEmpty(gid)) {
                    WHERE("gid = #{gid}");
                }
            }}.toString();
        }
    }

}
