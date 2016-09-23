package cn.zjc;

import cn.zjc.domain.p.User;
import cn.zjc.domain.s.Message;
import cn.zjc.repository.p.UserRepository;
import cn.zjc.repository.s.MessageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 * @author zhangjinci
 * @version 2016/9/23 10:27
 * @function
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    //domain必须带空构造
    @Test
    public void Test1()throws Exception{
        userRepository.save(new User("zjc",23));
        userRepository.save(new User("zjc1",23));
        userRepository.save(new User("zjc2",23));
        userRepository.save(new User("zjc3",23));
        userRepository.save(new User("zjc4",23));
        assertEquals(5,userRepository.findAll().size()); //如果这里断言失败不会走到下一步

        messageRepository.save(new Message("msg1","1111"));
        messageRepository.save(new Message("msg2","2222"));
        assertEquals(2,messageRepository.findAll().size());
    }
}
