package cn.zjc.dao;

import cn.zjc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author zhangjinci
 * @version 2016/9/22 20:43
 * @function
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query("FROM User u where u.id =:id")
    User findUser(@Param("id") Integer id);
}
