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
	<form action="${pageContext.request.contextPath}/student?cmd=edit" method="post">
		<input type="hidden" name="id" value="${stu.id}">
		姓名：<input type="text" name="name" value="${stu.name}"><br/>
		年纪：<input type="text" name="age" value="${stu.age}"><br/>
		<input type="submit" value="确定">
	</form>
</body>
</html>