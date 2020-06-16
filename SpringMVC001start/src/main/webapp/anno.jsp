<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/15
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="/SpringMVC001/anno/testRequestParam?usernameXX=haha">RequestParam</a>

    <hr>

    <form action="/SpringMVC001/anno/testRequestBody" method="post">
        用户姓名:<input type="text" name="username"><br>
        用户年龄:<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>

    <hr>

    <a href="/SpringMVC001/anno/testPathVariable/10">PathVariable</a>

    <hr>

    <a href="/SpringMVC001/anno/testRequestHeader">RequestHeader</a>

    <hr>

    <a href="/SpringMVC001/anno/testCookieValue">CookieValue</a>

    <hr>

    <form action="/SpringMVC001/anno/testModelAttribute" method="post">
        用户姓名:<input type="text" name="uname"><br>
        用户年龄:<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>

    <hr>

    <a href="/SpringMVC001/anno/testSessionAttributes">setSessionAttributes</a>

    <a href="/SpringMVC001/anno/getSessionAttributes">getSessionAttributes</a>

    <a href="/SpringMVC001/anno/delSessionAttributes">delSessionAttributes</a>
</body>
</html>
