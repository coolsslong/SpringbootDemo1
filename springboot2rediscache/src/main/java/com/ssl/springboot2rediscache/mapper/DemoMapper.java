package com.ssl.springboot2rediscache.mapper;

import com.ssl.springboot2rediscache.entity.Users;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DemoMapper {
    @Select("select * from users where id=#{id}")
    Users findById(Integer id);

    @Update("update users set name=#{name},password=#{password},age=#{age} where id=#{id}")
    void updateUser(Users users);

    @Delete("delete from users where id=#{id}")
    void deleteUserById(Integer id);

    @Insert("insert into users(name,password,age) values(#{name},#{password},#{age})")
    void insertUser(Users users);
}
