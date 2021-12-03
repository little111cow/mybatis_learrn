package cn.app.dao;

import cn.app.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
//    基本类型和String需要加Param注解，引用类型不加,#{}所取的是param定义的名称
    @Select("select * from user where id = #{id};")
    User getuserById(@Param("id") int id);

    @Select("select * from user limit #{offset},#{pageSize};")
    List<User> getUserListByLimit(@Param("pageSize")int pageSize, @Param("offset") int offeset);

    @Select("select * from user;")
    List<User> getUserListByRowBounds(@Param("pageSize")int pageSize, @Param("offset") int offeset);

    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{pwd});")
    boolean addUser(User user);

    @Delete("delete from user where id=#{uid}")
    boolean delUser(@Param("uid")int id);

    @Update("update user set name=#{name},pwd=#{pwd} where id = #{id}")
    boolean updateUser(User user);
}
