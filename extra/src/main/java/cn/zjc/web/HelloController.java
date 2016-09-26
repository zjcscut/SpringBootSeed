package cn.zjc.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjc
 * @version 2016/9/26 23:55
 * @description
 */
@RestController
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(@RequestParam("name") String name) {
		return "Hello " + name;
	}
}
