<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>查询商品列表</title>
	</head>
	<body>
		<h3>当前用户:${username }</h3>
		<a href="${pageContext.request.contextPath}/logout.action">退出</a>
		<form
			action="${pageContext.request.contextPath }/queryItem.action"
			method="post">
			<table width="100%" border=1>
				<tr align="center">
					<td>查询条件：</td>
					<td>商品类型　:　
						<select>
							<c:forEach var="itemType" items="${itemType}">
								<option value="${itemType.key}">${itemType.value}</option>
							</c:forEach>
						</select>
					</td>
					<td><input type="submit" value="查询" /></td>
				</tr>
			</table>
			商品列表：
			<table width="100%" border=1>
				<tr align="center">
					<td>商品图片</td>
					<td>商品名称</td>
					<td>商品价格</td>
					<td>生产日期</td>
					<td>商品描述</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${itemsList }" var="item">
					<tr align="center">
						<td>
							<c:if test="${!empty item.pic }">
								<img width="100" src="${pageContext.request.contextPath }/image/${item.pic}"> 
							</c:if>
						</td>
						<td>${item.name }</td>
						<td>${item.price }</td>
						<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${item.detail }</td>
						<td><a href="${pageContext.request.contextPath }/editItem.action?id=${item.id}">修改</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</body>
</html>