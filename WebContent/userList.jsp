<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<h1>用户列表</h1>
	<hr/>
	<c:forEach items="${userList }" var="user">
		<h3><a href="userDetail.do?id=${user.id }">${user.name }</a></h3>
		<hr/>
	</c:forEach>
</body>
</html>