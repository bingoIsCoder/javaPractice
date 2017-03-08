<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/shoppingCart?cmd=add" method="post">
		商品：<select name="name">
					<option value="手机">手机</option>
					<option value="电脑">电脑</option>
					<option value="显示器">显示器</option>
					<option value="平板">平板</option>
					<option value="耳机">耳机</option>
			  </select> <br>
		数量：<input type="text" name="num"><br>
		<input type="submit" value="确定">
	</form>
</body>
</html>