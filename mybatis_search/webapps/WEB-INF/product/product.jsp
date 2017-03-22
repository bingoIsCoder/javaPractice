<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
	table {		
		border-collapse: collapse;
		width: 700px;
	}
	
	table, td, th {
		border: 1px solid black;
		text-align: center;
		vertical-align: middle;
		height: 30px;
	}
</style>

<script type="text/javascript">
	function goPage(currentPage) {
		var form = document.searchForm;
		form.currentPage.value = currentPage;
		form.submit();
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/product" method="post" name="searchForm">
		<input type="hidden" name="currentPage" >
		<input type="text" name="name" placeholder="商品名称" 
		value="${query.name}">
		<input type="number" name="minPrice" placeholder="最低价格" 
		value="${query.minPrice}">
		<input type="number" name="maxPrice" placeholder="最高价格" 
		value="${query.maxPrice}">
		<input type="submit" value="确定">
	</form><br>
	<table>
		<tr>
			<th>ID</th>
			<th>商品名称</th>
			<th>商品代号</th>
			<th>商品售价</th>
			<th>供应商</th>
			<th>品牌</th>
			<th>折扣</th>
			<th>进价</th>
		</tr>
		<c:forEach items="${pageList.data}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.productName}</td>
				<td>${product.dir_id}</td>
				<td>${product.salePrice}</td>
				<td>${product.supplier}</td>
				<td>${product.brand}</td>
				<td>${product.cutoff}</td>
				<td>${product.costPrice}</td>
			</tr>
		</c:forEach>
	</table><br>
	<c:if test="${pageList.totalPages > 1}">
		<a href="javascript:goPage(1)">首页</a>
		<a href="javascript:goPage(${pageList.prePage})">上一页</a>  | 
		<a href="javascript:goPage(${pageList.nextPage})">下一页</a>  
		<a href="javascript:goPage(${pageList.totalPages})">尾页</a>  
	</c:if>
	当前第${pageList.currentPage}页/共${pageList.totalPages}页  一共有${pageList.totalCount}条数据
</body>
</html>