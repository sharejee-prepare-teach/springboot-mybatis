package com.techprimers.mybatis.springbootmybatis.mapper;

import com.techprimers.mybatis.springbootmybatis.model.Users;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Select("select * from users")
    List<Users> findAll();

    @Insert("insert into users(name,salary) values(#{name},#{salary})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
    void insert(Users users);

    @Delete("delete from users where id=#{id}")
    void delete(Integer id);

    @Update("update users set name=#{name}, salary=#{salary} where id=#{id}")
    void update(Users users);

    /*@Update("update users set salary=#{salary} where name=#{name}")
    void update(Users users);*/
}
