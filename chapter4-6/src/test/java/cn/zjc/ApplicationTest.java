package cn.zjc;

import cn.zjc.entity.User;
import cn.zjc.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author zhangjinci
 * @version 2016/9/23 16:15
 * @function
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void Setup() {
        userRepository.deleteAll();
    }

    @Test
    public void Test1() throws Exception {
        userRepository.save(new User(1, "zjc1", 23));
        userRepository.save(new User(2, "zjc2", 24));
        userRepository.save(new User(3, "zjc3", 25));

        assertEquals(3, userRepository.findAll().size());

        User u = userRepository.findOne(1);
        userRepository.delete(u);
        assertEquals(2, userRepository.findAll().size());

        u = userRepository.findByName("zjc2");
        userRepository.delete(u);
        assertEquals(1, userRepository.findAll().size());
    }
}
