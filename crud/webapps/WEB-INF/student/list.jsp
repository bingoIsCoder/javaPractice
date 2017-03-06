<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	欢迎您： ${USER_IN_SENSSION.name}<br>
	<a href="${pageContext.request.contextPath}/input">添加</a>
	<table border="1" cellspacing="0" width="400">
		<tr align="center">
			<th>id</th>
			<th>name</th>
			<th>age</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${stus}" var="stu" varStatus="vs">
			<tr align="center">
				<td>${stu.id}</td>
				<td>${stu.name}</td>
				<td>${stu.age}</td>
				<td><a href="${pageContext.request.contextPath}/input?id=${stu.id}">修改</a>/<a href="${pageContext.request.contextPath}/delete?id=${stu.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>