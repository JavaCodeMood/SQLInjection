<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
	<h1>欢迎您！<%=((User)request.getSession().getAttribute("user")).getName() %></h1>
	<hr/>
	<h3>年龄：${user.age }</h3>
	<a href="alterPassword.jsp">修改密码</a>
	<br/>
	<a href="searchAge.do?age=${user.age }">查看与自己同龄的小伙伴</a>
</body>
</html>