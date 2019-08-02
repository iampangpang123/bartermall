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
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">


<script src="../../js/bootstrap.min.js"></script>

<link href="../../css/bootstrap.min.css" rel="stylesheet" media="screen">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link media="all"
	href="${pageContext.request.contextPath}/css/index.css" type="text/css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>



<script src="${pageContext.request.contextPath}/js/add.js"></script>
<script src="${pageContext.request.contextPath}/js/hm.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script src="${pageContext.request.contextPath}/js/common_001.js"></script>


</head>
<!--   <body style="background: rgb(254,238,189);"> -->
<h1>所有订单</h1>
<%@ include file="../common/shop_header.jsp"%>
	<%@ include file="../common/shop_left.jsp"%>
	<div class="container">
		<div class="main center">
<table border="1" width="100%" cellspacing="0" background="black">
	<tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white;">
		<td colspan="6">
			订单：8691b4150a0641e7a8729fd5e668820c　成交时间：2019-03-04 15:56:53　金额：<font color="red"><b>2888</b></font>	已收货（完成）
		</td>
	</tr>
	<tr bordercolor="rgb(78,78,78)" align="center" > 
		<td width="15%">
			<div><img src="<c:url value='/imgs_products/sangxings9.jpg'/>" height="75"/></div>
		</td>
		<td>商品名：三星s9</td>
		<td>单价：2888</td>
		<td>购买者：唐涛</td>
		<td>数量：1</td>
		<td>小计：2888</td>
	</tr>
  
 


	<tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white;">
		<td colspan="6">
			订单：153839427aa94f359fe51932d9f9e383 &nbsp;　成交时间：2019-03-06 15:02:31　金额：<font color="red"><b>500</b></font>　
				 未收货  <a href="" style="color: red;margin-left: 950px">确认收货</a>
		</td>
	</tr>
	<tr bordercolor="rgb(78,78,78)" align="center">
		<td width="15%">
			<div><img src="<c:url value='/imgs_products/595087ee5d7644ada8a71e181ad6218b.jpg'/>" height="75"/></div>
		</td>
		<td>商品名：匡威1970</td>
		<td>单价：500</td>
		<td>购买者：唐涛</td>
		<td>数量：1</td>
		<td>小计：500</td>
	</tr>
  


 
	

	<tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white;">
		<td colspan="6">
			订单：15633591aa959135951e518d9f9e326    &nbsp; &nbsp;  成交时间：2019-05-04 12:47:41　金额：<font color="red"><b>4088</b></font>　未付款  <a href="" style="color: red;margin-left: 960px">去支付</a>
		</td>
	</tr>
	<tr bordercolor="rgb(78,78,78)" align="center">
		<td width="15%">
			<div><img src="<c:url value='/imgs_products/5b57fffcc11346e78705acd64dade335.jpg'/>" height="75"/></div>
		</td>
		<td>商品名：OPPO R17</td>
		<td>单价：1200</td>
		<td>购买者：唐涛</td>
		<td>数量：1</td>
		<td>小计：1200</td>
	</tr>	<tr bordercolor="rgb(78,78,78)" align="center">
		<td width="15%">
			<div><img src="<c:url value='/imgs_products/e42a7ffe9c654830b9efbfe2fb8e5f2c.jpg'/>" height="75"/></div>
		</td>
		<td>商品名：华为Mate 20</td>
		<td>单价：2888</td>
		<td>购买者：唐涛</td>
		<td>数量：1</td>
		<td>小计：2888</td>
	</tr>
  
</table>
</div>
</div>
<%@ include file="../common/shop_footer.jsp"%>
  </body>
</html>
