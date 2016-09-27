package cn.zjc.dao;

import cn.zjc.domain.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author zhangjinci
 * @version 2016/9/27 16:44
 * @function
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Integer> {

    @Cacheable
    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    @Query("FROM User u where u.name = :name")
    User find(@Param("name") String name);
}
