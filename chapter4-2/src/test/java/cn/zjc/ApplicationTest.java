package cn.zjc;

import cn.zjc.dao.UserRepository;
import cn.zjc.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
