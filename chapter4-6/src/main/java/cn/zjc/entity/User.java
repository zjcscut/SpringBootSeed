package cn.zjc.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author zhangjinci
 * @version 2016/9/23 16:11
 * @function
 */
public class User implements Serializable{

    @Id
    private Integer id;

    private String name;
    private Integer age;

    public User() {
    }

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
