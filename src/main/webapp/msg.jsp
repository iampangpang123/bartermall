<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'msg.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/login2.css" rel="stylesheet" type="text/css" />
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- <style type="text/css">

body {
	font-family:"Microsoft Yahei";
	font-size:12px;
	margin:0;
	background: #fff url(/imgs/loginbackimage.jpg) ;
	background-repeat: no-repeat;

    background-size:cover;  
    background-position: fixed;
}
</style>
 -->
</head>

<body>
	<center>

		<h1 style="color: #4BC0A5">
			易货二手交易平台<sup>2019</sup>
		</h1>


		<h1 style="color: red;">${msg }</h1>
		<ul>
			<h2>
				<li><a   style="color: green" href="<c:url value='/index.jsp'/>">点击回到主页面！</a></li>
			</h2>
		</ul>
	</center>
</body>
</html>
