<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/student?cmd=input">添加</a><br>
	<table cellspacing="0" border="1">
		<tr align="center">
			<th>ID</th>
			<th>姓名</th>
			<th>密码</th>
			<th>年龄</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${stus}" var="stu">
			<tr align="center">
				<td>${stu.id}</td>
				<td>${stu.name}</td>
				<td>${stu.password}</td>
				<td>${stu.age}</td>
				<td>
					<a href="/student?cmd=input&id=${stu.id}">修改</a>
					| 
					<a href="/student?cmd=delete&id=${stu.id}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>