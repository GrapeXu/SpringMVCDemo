<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/14
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%-- 请求参数绑定 --%>
    <h3>基本数据类型 & String</h3>
    <a href="/SpringMVC001/param/testParam?username=hehe&password=123">请求参数绑定</a>

    <hr>


    <%--  请求参数绑定实体类型  --%>
    <h3>实体类 JavaBean</h3>
    <form action="/SpringMVC001/param/saveAccount" method="post">
        姓名:<input type="text" name="username"><br><%-- 此处name 须和 JavaBean属性相同 --%>
        密码:<input type="text" name="password"><br>
        金额:<input type="text" name="money"><br>
        用户姓名:<input type="text" name="user.uname"><br>
        用户年龄:<input type="text" name="user.age"><br>
<%--        用户姓名:<input type="text" name="list[0].uname"><br>--%>
<%--        用户年龄:<input type="text" name="list[0].age"><br>--%>
<%--        用户姓名:<input type="text" name="map['one'].uname"><br>--%>
<%--        用户年龄:<input type="text" name="map['one'].age"><br>--%>
        <input type="submit" value="提交">
    </form>


    <h3>集合数据类型</h3>
    <form action="/SpringMVC001/param/saveCollection" method="post">
        用户姓名:<input type="text" name="list[0].uname"><br>
        用户年龄:<input type="text" name="list[0].age"><br>
        用户姓名:<input type="text" name="map['one'].uname"><br>
        用户年龄:<input type="text" name="map['one'].age"><br>
        <input type="submit" value="提交">
    </form>

    <h3>自定义 类型转换器</h3>
    <%-- 自定义类型转换器 --%>
    <form action="/SpringMVC001/param/saveUser" method="post">
        用户姓名:<input type="text" name="uname"><br>
        用户年龄:<input type="text" name="age"><br>
        用户生日:<input type="text" name="date"><br>
        <input type="submit" value="提交">
    </form>

    <h3>Servlet 原生API</h3>
    <a href="/SpringMVC001/param/testServlet">Servlet</a>

</body>
</html>
