package cn.zjc;

import cn.zjc.dao.UserRepository;
import cn.zjc.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @author zhangjinci
 * @version 2016/9/22 20:47
 * @function
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void Test1() {
        User u = userRepository.findByName("zjc");
        assertTrue(u != null);
        assertEquals("zjc", u.getName());

        u = userRepository.findByNameAndAge("zjc", 23);
        assertTrue(u != null);
        assertEquals("zjc", u.getName());

        u = userRepository.findUser(1);
        assertTrue(u != null);
        assertEquals("zjc", u.getName());
    }



    @Test
    @Transactional  //开启事务
    public void TestRollback() throws Exception{
        // 创建10条记录
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("DDD", 40));
        userRepository.save(new User("EEE", 50));
        userRepository.save(new User("FFF", 60));
        userRepository.save(new User("GGG", 70));
        userRepository.save(new User("HHHHHHHHHH", 80)); //长度超过5，全部回滚
        userRepository.save(new User("III", 90));
        userRepository.save(new User("JJJ", 100));
    }
}
