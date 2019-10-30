package com.ssl.springboot_jdbc.dao;

import com.ssl.springboot_jdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate primaryJdbcTemplate;

    @Override
    public int save(User user) {
        return 0;
    }

    @Override
    public int save(User user, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = primaryJdbcTemplate;
        }
        String sql = "INSERT INTO users(name,password,age) values(?,?,?)";
        System.out.println("save");
        return jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getAge());

    }

    @Override
    public int update(User user) {
        String sql = "UPDATE users SET name=?,password=?,age=? WHERE id=?";
        return primaryJdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getAge(), user.getId());
    }

    @Override
    public int delete(long id) {
        String sql = "DELETE FROM users WHERE id=?";
        return primaryJdbcTemplate.update(sql, id);
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return primaryJdbcTemplate.query(sql, new UserRowMapper());

    }

    @Override
    public User findById(long id) {
        String sql = "select * from users where id=?";
        return primaryJdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<User>(User.class));
    }

    /**
     * 创建内部类封装结果集
     */
    class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setPassword(resultSet.getString("password"));
            user.setAge(resultSet.getInt("age"));
            return user;
        }
    }
}
