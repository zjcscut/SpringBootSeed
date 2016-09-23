package cn.zjc.repository.s;

import cn.zjc.domain.s.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhangjinci
 * @version 2016/9/23 10:26
 * @function
 */
public interface MessageRepository extends JpaRepository<Message, Integer> {
}
