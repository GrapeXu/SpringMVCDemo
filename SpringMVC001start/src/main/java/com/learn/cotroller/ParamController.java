package com.learn.cotroller;

import com.learn.domain.Account;
import com.learn.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请求参数绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 请求参数绑定入门
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username, String password) {
        System.out.println("用户名:" + username);
        System.out.println("密码:" + password);
        return "success";
    }

    /**
     * 请求参数绑定
     *      把数据封装到JavaBean的类中
     *          参数列表写个类,完事
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println(account);
        return "success";
    }

    @RequestMapping("/saveCollection")
    public String saveCollection(ArrayList<User> list, HashMap<String, User> map) {
        System.out.println(list);
        System.out.println(map);
        return "success";
    }

    /**
     * 自定义类型转换器
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user) {
        System.out.println(user);
        return "success";
    }

    /**
     * 原生API获取
     * @return
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("执行了...");
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext context = session.getServletContext();
        System.out.println(context);

        System.out.println(response);
        return "success";
    }
}
