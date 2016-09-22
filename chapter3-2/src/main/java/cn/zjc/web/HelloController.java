package cn.zjc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhangjinci
 * @version 2016/9/22 14:18
 * @function
 */
@Controller
public class HelloController {

    @ModelAttribute
    public void modelAttrVal(@RequestParam("abc")String abc, Model model){
        model.addAttribute("attrVal",abc);
    }

    @RequestMapping("/hello")
    public String hello() {
        return "index";
    }
}
