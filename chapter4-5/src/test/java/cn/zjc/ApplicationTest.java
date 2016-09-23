package cn.zjc;

import cn.zjc.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 * @author zhangjinci
 * @version 2016/9/23 11:00
 * @function
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    @Test
    public void Test1(){
        stringRedisTemplate.opsForValue().set("name","zjc");
        assertEquals(stringRedisTemplate.opsForValue().get("name"),"zjc");
    }


    @Autowired
    private RedisTemplate<String,User> redisTemplate;

    @Test
    public void Test2(){
        User u1 = new User(1,"zjc1",23);
        User u2 = new User(2,"zjc2",24);
        User u3 = new User(3,"zjc3",25);
        redisTemplate.opsForValue().set(u1.getName(),u1);
        redisTemplate.opsForValue().set(u2.getName(),u2);
        redisTemplate.opsForValue().set(u3.getName(),u3);

        assertEquals(23,redisTemplate.opsForValue().get("zjc1").getAge().intValue());
        assertEquals(24,redisTemplate.opsForValue().get("zjc2").getAge().intValue());
        assertEquals(25,redisTemplate.opsForValue().get("zjc3").getAge().intValue());
    }
}
