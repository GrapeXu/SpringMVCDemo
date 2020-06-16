package com.learn.cotroller;

import com.learn.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model) {//参数列表声明model
        System.out.println("testString方法执行了");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("财富密码");
        user.setPassword("123");
        user.setAge(30);
        //model对象 存入request域
        model.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/testVoid")//没有返回值，默认请求转发路径.jsp：testVoid.jsp
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid方法执行了");
        //请求转发
        //request.getRequestDispatcher("/WEB-INF/pages/success.jpg").forward(request, response);

        //重定向
        //response.sendRedirect(request.getContextPath() + "/index.jsp");

        //直接进行响应
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");//浏览器打开,解析的编码
        response.getWriter().print("你好");

        return;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView方法执行了");
        ModelAndView mv = new ModelAndView();
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("财富密码");
        user.setPassword("123");
        user.setAge(30);
        //把user对象存储到mv对象中，也会把user对象存入到request对象
        mv.addObject("user", user);
        //跳转到哪个页面
        //通过视图解析器
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字的方式进行转发或者重定向
     * @param model
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(Model model) {
        System.out.println("testForwardOrRedirect方法执行了");

        //请求的转发,不能使用视图解析器
//        return "forward:/WEB-INF/pages/success.jsp";

        //重定向.请求不到上面的
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求响应
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax方法执行了");
        //客户端 发送ajax请求 传的是 json字符串
        //后端把 json字符串 封装到 对象user中 @RequestBody
        System.out.println(user);

        //模拟查询数据库
        user.setUsername("hhhh");
        user.setAge(40);
        //做响应,返回的是对象,但jsp那里接收的是JSON。
        //@ResponseBody转成JSON串
        return user;
    }
}
