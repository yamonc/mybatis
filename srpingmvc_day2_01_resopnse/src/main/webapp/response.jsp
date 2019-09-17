<%--
  Created by IntelliJ IDEA.
  User: 陈亚萌
  Date: 2019/8/26
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>

</head>
<body>
<a href="user/testString">testString</a><br>

<a href="user/testVoid">testString</a>
<br>
<a href="user/testModelAndView">testmodelandview</a><br>
<a href="user/testForwardOrRedirect">testmodelandview</a>
<br>

<button id="btn">发送ajax请求</button>

</body>

<script>
    $(function () {
        alert("123");
        $("#btn").click(function () {
            //alert("hello btn");
            $.ajax(
                {
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehe","password":"123","age":30}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //服务器端相应的json数据，进行解析

                    }
                }
            )
        });
    });
</script>
</html>
