package cn.zjc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author zhangjinci
 * @version 2016/9/22 11:43
 * @function
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private ProComponent proComponent;

    @Autowired
    private ProComponetAdvance proComponetAdvance;

    @Test
    public void TestValue(){
        System.out.println(proComponent.getName());
        System.out.println(proComponent.getTitle());
        System.out.println(proComponent.getDesc());

        System.out.println("------------------------");

        System.out.println(proComponetAdvance.getName());
        System.out.println(proComponetAdvance.getTitle());
        System.out.println(proComponetAdvance.getDesc());
    }
}
