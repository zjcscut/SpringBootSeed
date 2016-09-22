package cn;

import cn.zjc.Application;
import cn.zjc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhangjinci
 * @version 2016/9/22 18:24
 * @function
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class TestScope {


    @Autowired
    private UserService userService;

    @Test
    public void Test1(){
        userService.create("zjc",23);
    }

    @Test
    public void Test2(){
        System.out.println(userService.getById(1));
    }
}
