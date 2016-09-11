<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path=request.getContextPath(); %>
<%String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="<%=basePath %>css/bootstrap.min.css">

<title>同龄用户列表</title>
    <style>
        body{
              background:url("<%=basePath%>img/bg.jpg")
        }
    </style>
</head>
<body>
	<nav class="navbar navbar-inverse">
      <a class="navbar-brand" href="#">同龄用户列表</a>
	</nav>
	<div class="row">
	  <div class="col-md-6"><h2>用户名</h2></div>
	  <div class="col-md-6"><h2>年龄</h2></div>
	</div>
	<hr/>   
	<c:forEach items="${userList }" var="user">
		<div class="row ">
		  <div class="col-md-6"><h3>${user.name }</h3></div>
		  <div class="col-md-6"><h3>${user.age }</h3></div>
		</div>
	</c:forEach>
</body>   
</html>