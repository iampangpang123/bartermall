<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>购物车列表</title>

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

<body >


	<%@ include file="../common/shop_header.jsp"%>
	<%@ include file="../common/shop_left.jsp"%>
	<div class="container">
		<div class="main center">

			<!-- 	<h1>购物车</h1> -->
			<c:choose>
				<%-- 如果没有车，或车的内容集合为0长 --%>
				<c:when
					test="${empty sessionScope.cart or fn:length(sessionScope.cart.cartItems) eq 0}">
					<center><h1 style="color: green">购物车为空</h1></center></br>
					<center><img src="<c:url value='imgs/cart.png'/>" width="500px" /></center>
				</c:when>
				<c:otherwise>
					<!-- 	style="width: 1000px;height: 500px;margin-left: 120px;margin-top: 120px" -->

					<table border="1" width="100%" cellspacing="0" background="black" 
						style="width: 1400px; margin-left: -132px; margin-top: -20px" 
						class="table">
						<tr  style="border: none;border-color: white"  >
							<td colspan="1" 
								style="font-size: 15pt; font-weight: 900; border:none"><center>我的购物车</center></td>
							<td colspan="7" align="right"
								style="font-size: 15pt; font-weight: 900"><a
								href="<c:url value='/cleanCart.action'/> ">清空购物车</a></td>
						</tr>
						<tr class="success">
							<th><center>图片</center></th>
							<th><center>商品名</center></th>
							<th><center>单价</center></th>
							<th><center>数量</center></th>
							<th><center>小计</center></th>
							<th><center>操作</center></th>
						</tr>

						<c:forEach items="${sessionScope.cart.cartItems}" var="cartItem">
							<tr >
								<td><div>
										<center>
											<img style="width: 50px; height: 50px"
												src="<c:url value='${cartItem.image}'/>" />
										</center>
									</div></td>
								<td><center>${cartItem.pname}</center></td>

								<td><center>${cartItem.price}</center></td>
								<td><center>${cartItem.count}</center></td>
								<td><center>${cartItem.total}</center></td>
								<td><center>
										<a
											href="<c:url value='/deleteCartItem.action?pid=${cartItem.pid }'/> ">删除</a>
									</center></td>
							</tr>

						</c:forEach>

						<tr >
							<td colspan="7" align="right"
								style="font-size: 15pt; font-weight: 900">
								合计：${sessionScope.cart.total}<!-- 调用cart类的getTotal（）方法 -->
							</td>
						</tr>
						<tr >
							<td colspan="7" align="right"
								style="font-size: 15pt; font-weight: 900"><a id="buy"
								href="<c:url value='/add.action'/>">Pay</a></td>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<%@ include file="../common/shop_footer.jsp"%>
</body>
</html>
