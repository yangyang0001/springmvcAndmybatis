<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>查询商品列表</title>
	</head>
	<body>
		<select>
			<c:forEach var="itemType" items="${itemType}">
				<option value="${itemType.key}">${itemType.value}</option>
			</c:forEach>
		</select>
		<br />
		<form action="${pageContext.request.contextPath}/updateItem.action"
			method="post" enctype="multipart/form-data">
			<table width="800px" border="1px">
				<tr align="center">
					<td>主键</td>
					<td>商品名称</td>
					<td>商品价格</td>
					<td>出厂日期</td>
					<td>商品描述</td>
					<td>上传图片</td>
				</tr>
				<tr align="center">
					<td><input type="text" value="${item.id }" name="id" /></td>
					<td><input type="text" value="${item.name }" name="name" /></td>
					<td><input type="text" value="${item.price }" name="price" /></td>
					<td><input type="text" name="createtime"
						value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>" /></td>
					<td><input type="text" value="${item.detail }" name="detail" /></td>
					<td><input type="file" name="item_pic" /></td>
				</tr>
				<tr align="center">
					<td colspan="6"><input type="submit" value="更新" /></td>
				</tr>
			</table>
	
		</form>
	</body>

</html>