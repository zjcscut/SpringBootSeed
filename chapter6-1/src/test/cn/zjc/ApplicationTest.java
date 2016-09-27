package cn.zjc;

import cn.zjc.dao.UserRepository;
import cn.zjc.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhangjinci
 * @version 2016/9/27 16:47
 * @function
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void Test1() throws Exception {
        User u1 = userRepository.findByName("zjc");
        System.out.println("第一次查询: " + u1.getAge());

        User u2 = userRepository.findByName("zjc");
        System.out.println("第二次查询: " + u2.getAge());
    }
}
