<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/student?cmd=edit" method="post">
		<input type="hidden" name="id" value="${stu.id}">
		姓名：<input type="text" name="name" value="${stu.name}"><br>
		密码：<input type="password" name="password"><br>
		年龄：<input type="text" name="age" value="${stu.age}"><br>
		<input type="submit" value="确定">
	</form>
</body>
</html>