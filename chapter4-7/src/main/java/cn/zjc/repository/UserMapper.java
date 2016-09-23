package cn.zjc.repository;

import cn.zjc.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author zhangjinci
 * @version 2016/9/23 16:46
 * @function
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user where name= #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO user(name,age) values(#{name},#{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Update("UPDATE user set age = #{age} where name = #{name}")
    void update(User u);

    @Delete("DELETE FROM user where id = #{id}")
    void delete(Integer id);

    @Results(id = "id",
            value = {
                    @Result(property = "name", column = "name"),
                    @Result(property = "age", column = "age")
            })
    @Select("SELECT * FROM user")
    List<User> findAll();
}
