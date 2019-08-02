<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>图书列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body {
	font-size: 10pt;
}

.icon {
	margin: 10px;
	border: solid 2px gray;
	width: 160px;
	height: 180px;
	text-align: center;
	float: left;
}
</style>
</head>

<body style="background: rgb(254, 238, 189);">

	<%-- 	<c:forEach items="${userList }" var="user">
		<div class="icon">
			<a href="<c:url value='/admin/loadBookById.action?bid=${user.id }'/>"><img
				src="<c:url value="imgs/${user.photo }"/>"
				style="width: 160px; height: 180px" border="0" /></a> <br /> <a
				href="<c:url value='/admin/loadBookById.action?bid=${user.id }'/>">${user.name }</a>
		</div>
	</c:forEach> --%>
	 <table border="1" width="100%" cellspacing="0" background="black">
	   <tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white; " align="center">
		
			<td  colspan="8">头像</td>
			<td>ID</td>
			<td>用户名</td>
			<td>所在地</td>
			<td>电话</td>
			<td>积分</td>
			<td>QQ</td>
			<td>操作</td>
		
	</tr>

	<c:forEach items="${userList }" var="user">
	

			<tr bordercolor="rgb(78,78,78)" align="center" >
				<td width="15%" colspan="8">
					<div>
						<img src="<c:url value="imgs/${user.photo }"/>" height="75" />
					</div>
				</td>
				<td>${user.id }</td>
				<td>${user.name }</td>
				<td>${user.area }</td>
				<td>${user.tel }</td>
				<td>${user.point }</td>
				<td>${user.qq }</td>
				<td>
					  <a style="color: red" href="">封禁账号</a></br> 
				   <a style="color: red" href="">修改用户</a>
				</td>
			</tr>
	
	</c:forEach>
	</table>

</body>

</html>

