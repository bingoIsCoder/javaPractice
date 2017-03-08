<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" cellspacing="0" width="600" height="60">
		<tr align="center" valign="middle">
			<th>商品名称</th>
			<th>商品数量</th>
			<th>商品价格</th>
			<th>操作</th>
		</tr>
		<c:choose>
			<c:when test="${empty BUYCART_IN_SESSION.items}">
				<tr align="center" valign="middle">
					<td colspan="4">当前购物车中没有商品</td>
				</tr>
			</c:when>
			<c:when test="${!empty BUYCART_IN_SESSION.items}">
				<c:forEach items="${BUYCART_IN_SESSION.items}" var="item">
					<tr align="center" valign="middle">
						<td>${item.name}</td>
						<td>${item.num}</td>
						<td>${item.totalPrice}</td>
						<td><a href="/shoppingCart?cmd=delete&id=${item.id}">删除</a></td>
					</tr>					
				</c:forEach>
				<tr align="center" valign="middle">
						<td colspan="4">总价：${BUYCART_IN_SESSION.totalPrice}</td>
					</tr>
			</c:when>
		</c:choose>
	</table>
	<a href="/buySomething.jsp">继续买买买...</a>
</body>
</html>