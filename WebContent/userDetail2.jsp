<%@page import="java.sql.*"%>
<%@page import="com.example.util.DBHelper"%>
<%@page import="com.example.entity.User"%>
<%@page import="com.example.dao.impl.UserDAOImpl01"%>
<%@page import="com.example.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户详情页</title>
</head>
<body>
	<%
		String id=request.getParameter("id");
		Connection conn=DBHelper.getConnection();
		Statement stmt=conn.createStatement();
		String sql="select * from user where id="+id;
		ResultSet rs=stmt.executeQuery(sql);
		User user=new User();
		if(rs.next()){
			user.setAge(rs.getInt("age"));
			user.setName(rs.getString("name"));
			user.setId(rs.getInt("id"));
		}
		
	%>
	<h1>用户详情</h1>
	<hr/>
	<h3>用户名:<%=user.getName() %></h3>
	<h3>年龄:<%=user.getAge() %></h3>
</body>
</html>