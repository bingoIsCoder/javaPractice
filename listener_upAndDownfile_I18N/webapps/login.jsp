<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<fmt:setBundle basename="system"/>
	<form action="#" method="post" >
		<fmt:message key="userName"/>: <input type="text" name="name"><br>
		<fmt:message key="password"/>: <input type="password" name="password"><br>
		<input type="submit" value='<fmt:message key="login"/>'>
	</form>
</body>
</html>