package cn.zjc.service;

import cn.zjc.entity.User;

/**
 * @author zhangjinci
 * @version 2016/9/22 18:11
 * @function
 */
public interface UserService {

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name, Integer age);


    void deleteById(Integer id);

    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();



    User getById(Integer id);
}
