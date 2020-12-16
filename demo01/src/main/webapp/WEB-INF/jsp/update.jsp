<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
//获取ID
var id = ${param.id};
	$(function(){
				$.ajax({
						url:"<%=request.getContextPath()%>/queryById",
						data:{id:id},
						type:"get",
						dataType:"json",
						success:function(obj){
								console.log(obj)
								$("#id").val(obj.id);
								$("#name").val(obj.name);
							}
					})
		})
</script>
</head>
<body>
<form action="update" method="post">
	<table>
		<tr>
			<td>姓名
			<input type="hidden" name="id" id="id">
			<input type="text" name="name" id="name">
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="提交">
			</td>
		</tr>
	</table>
</form>
</body>
</html>