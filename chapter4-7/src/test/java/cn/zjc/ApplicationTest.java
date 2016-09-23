package cn.zjc;

import cn.zjc.entity.User;
import cn.zjc.repository.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhangjinci
 * @version 2016/9/23 16:49
 * @function
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
public class ApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void Test1() {
        userMapper.insert("zjc2222222", 244);
        User u = userMapper.findByName("zjc2222222");
        assertEquals(244, u.getAge().intValue());

        u.setAge(100);
        userMapper.update(u);

        u = userMapper.findByName("zjc2222222");
        assertEquals(100, u.getAge().intValue());

        userMapper.delete(u.getId());
        u = userMapper.findByName("zjc2222222");
        assertEquals(null, u);
    }

    @Test
    @Rollback
    public void testAll() throws Exception {
        List<User> list = userMapper.findAll();
        for (User u : list) {
            System.out.println(u.getName());
        }
    }

    @Test
    public void testRollBack() {

    }
}
