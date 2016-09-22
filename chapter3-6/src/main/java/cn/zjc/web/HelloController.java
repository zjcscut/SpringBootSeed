package cn.zjc.web;

import cn.zjc.exception.CustomException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangjinci
 * @version 2016/9/22 15:46
 * @function
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("抛出异常");
    }

    @RequestMapping("/hello2")
    public String hello2() throws CustomException {
        throw new CustomException("抛出自定义异常");
    }
}
