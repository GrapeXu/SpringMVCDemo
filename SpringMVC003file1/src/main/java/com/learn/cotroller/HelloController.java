package com.learn.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器类
 */
@Controller
@RequestMapping(path = "/hello")
public class HelloController {

    @RequestMapping(path = "/sayHello")
    public String sayHello() {
        System.out.println("Hello SpringMVC");
        return "success";
    }

}
