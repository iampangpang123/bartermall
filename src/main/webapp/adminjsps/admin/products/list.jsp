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

<body style="background: rgb(254,238,189);">

	<c:forEach items="${findProductsList }" var="product">
		<div class="icon">
			<a href="<c:url value='/admin/loadBookById.action?pid=${product.pid }'/>"><img
				src="<c:url value="${product.pimage }"/>"
				style="width: 160px; height: 180px" border="0" /></a> <br /> <a
				href="<c:url value='/admin/loadBookById.action?pid=${product.pid }'/>">${product.pname }</a>
		</div>
	</c:forEach>


</body>

</html>

