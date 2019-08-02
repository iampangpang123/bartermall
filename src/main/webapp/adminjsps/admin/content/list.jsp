<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
    
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
	* {
		font-size: 11pt;
	}
	div {
		border: solid 2px rgb(78,78,78);
		width: 75px;
		height: 75px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
</style>
  </head>
  
  <body style="background: rgb(254,238,189);">
<h1>所有公告</h1>
 <table border="1" width="100%" cellspacing="0" background="black">
	   <tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white; " align="center">
	
			<td  colspan="8">ID</td>
			<td>公告主题</td>
			
			<td>发布时间</td>
		
			<td>优先级</td>
			<td>操作</td>
		
	</tr>

			<tr bordercolor="rgb(78,78,78)" align="center" >
					<td  colspan="8">1</td>
			<td>商品发布规则</td>
			
			<td>2019-03-04 8:56:53</td>
		
			<td>1</td>
			<td>
		<a href="#" style="color: green">查看内容</a></br>
		<a href="#" style="color: green;" >修改优先级</a>
			</td>
			
			</tr>
			<tr bordercolor="rgb(78,78,78)" align="center" >
					<td  colspan="8">2</td>
			<td>购买二手iphone注意事项</td>
			
			<td>2019-03-04 9:06:24</td>
		
			<td>2</td>
			<td>
		<a href="#" style="color: green">查看内容</a></br>
		<a href="#" style="color: green;" >修改优先级</a>
			</td>
			</tr>

	</table>
  </body>
</html>
