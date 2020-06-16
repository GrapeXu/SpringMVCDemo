<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/5/15
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //加载页面,绑定单击事件
        $(function () {
            $("#btn").click(function () {
                //发送ajax请求
                $.ajax(
                    {
                        //编写json格式,设置属性和值
                        url:"user/testAjax",
                        contentType:"application/json;charset=UTF-8",
                        data:'{"username":"hehe", "password":"123","age":30}',
                        // data:{"username":"hehe", "password":"123","age":30},不是字符串就报错
                        dataType:"json",
                        type:"post",
                        success:function (data) {
                            //data:服务器端响应的数据,这里是json
                            alert(data);
                            alert(data.username);
                            alert(data.password);
                            alert(data.age);
                        }
                    }
                );
            });
        });
    </script>
</head>
<body>
    <a href="user/testString">testString</a>

    <a href="user/testVoid">testVoid</a>

    <a href="user/testModelAndView">testModelAndView</a>

    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a>

    <button id="btn">发送AJAX请求</button>
</body>
</html>
