package cn.zjc.repository;

import cn.zjc.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author zhangjinci
 * @version 2016/9/23 15:59
 * @function
 */
public interface UserRepository extends MongoRepository<User,Integer> {

    User findByName(String name);
}
