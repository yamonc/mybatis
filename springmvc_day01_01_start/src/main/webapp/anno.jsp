<%--
  Created by IntelliJ IDEA.
  User: 陈亚萌
  Date: 2019/8/26
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--常用注解--%>
<a href="anno/testRequestParam?name=haha">RequestParam</a>
    <h3></h3>
<br>

<form action="/anno/testRequestBody" method="post">
    用户姓名：<input type="text" name="username"><br>
    用户年龄：<input type="text" name="age"><br>
    <input type="submit" value="提交">
</form>
<a href="/anno/testPathVariable/10">RequestParam</a>
<a href="/anno/testCookieValue">CookieValue</a><br>
<form action="/anno/testModelAttribute" method="post">
    用户姓名：<input type="text" name="uname"><br>
    用户年龄：<input type="text" name="age"><br>
    <input type="submit" value="提交">
</form>

<br>
<a href="/anno/testSessionAttributes">SessionAttributes</a>
</body>
</html>
