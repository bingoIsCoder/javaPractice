<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	function changeCode(img) {
		img.src="/randomCode?code=" + Math.random();
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/token" method="post">
		<input type="hidden" name="token" value="${TOKEN_IN_SESSION}">
		工资：<input type="text" name="salary" value="8000"><br>
		<input type="submit" value="确定">
	</form>
</body>
</html>