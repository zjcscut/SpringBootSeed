package cn.zjc.service;

import cn.zjc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;

/**
 * @author zhangjinci
 * @version 2016/9/22 18:11
 * @function
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("INSERT INTO user(name,age) VALUES(?,?)", name, age);
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update("DELETE FROM user WHERE id = ?", id);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM user", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("DELETE FROM user");
    }

    @Override
    public User getById(Integer id) {
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.queryForObject("SELECT * FROM user WHERE id = ?", new Object[]{id}, rowMapper);
    }
}
