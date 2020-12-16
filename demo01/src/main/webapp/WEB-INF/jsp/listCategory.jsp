<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
		$(function(){
				$("#add").click(function(){
					location.href="<%=request.getContextPath()%>/toadd";	
				})
				
				$(".update").click(function(){
					var id=$(this).next().val();
					location.href="<%=request.getContextPath()%>/toupdate?id="+id;
					})
				$(".delete").click(function(){
					var id=$(this).prev().val();
					location.href="<%=request.getContextPath()%>/deletes?id="+id;
					})
			})	
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="form">
		<table>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>
					<input type="button" value="添加" id="add"/>
				</td>
			</tr>
			<c:forEach items="${pageInfo.list}" var="l">
				<tr>
					<td>${l.id}</td>
					<td>${l.name}</td>
					<td>
						<input type="button" value="修改" class="update"/>
						<input type="hidden" value="${l.id}"/>
						<input type="button" value="删除"  class="delete"/>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>