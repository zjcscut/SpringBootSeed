package cn.zjc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangjinci
 * @version 2016/9/22 15:33
 * @function
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(ModelMap modelMap){
        modelMap.addAttribute("name","zjcscut");
        return "index";
    }
}
