package cn.zjc.repository.p;

import cn.zjc.domain.p.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangjinci
 * @version 2016/9/23 10:25
 * @function
 */
public interface UserRepository extends JpaRepository<User,Integer>{
}
