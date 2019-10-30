package com.ssl.springboot_jdbc.dao;

import com.ssl.springboot_jdbc.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface UserDao {
    int save(User user, JdbcTemplate jdbcTemplate);

    int save(User user);

    int update(User user);

    int delete(long id);

    List<User> findAll();

    User findById(long id);
}
