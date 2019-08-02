<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人中心</title>

<link media="all" href="css/user_center.css" type="text/css"
	rel="stylesheet">
<link media="all"
	href="${pageContext.request.contextPath}/css/index.css" type="text/css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/add.js"></script>
<script src="${pageContext.request.contextPath}/js/hm.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script src="${pageContext.request.contextPath}/js/common_001.js"></script>
<script src="webapp_js/user_center.js"></script>


</head>
<body>

	<div class="log-reg ease2">
		<div id="have_login" class="clearfix">
			<div id="person_info" class="clearfix">
				<a href="http://hust.2shoujie.com/user/level"> <img
					class="avatar" src="imgs/avatar1.png">
				</a>
				<div class="person_name">
					<a href="#">'+userId+'</a>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../common/shop_header.jsp"%>
	<%@ include file="../common/shop_left.jsp"%>




	﻿
	<div class="container">
		<div class="main center">

			<!-- 头像设置结束 -->
			<div class="top clearfix" id="user-top">
				<div id="user_msg">
					<div class="name" id="user_big_name"></div>

					<ul class="seller_attr">
						<li>当前积分：<span id="userpoint"></span><a href="" target="_top">查看积分明细</a></li>
						<li>已发布商品：<span id="procount"></span></li>
					</ul>
				</div>
				<div id="user_photo"></div>
			</div>
			<ul id="middle_nav" class="clearfix">
				<li class="on"><a href="#">个人资料</a></li>
			</ul>
			<div class="pop-tip hide">
				<div class="pop-tip-area">
					<p class="pop-tip-txt">修改成功</p>
				</div>
			</div>
			<div id="my_info"></div>
			<ul id="middle_nav" class="clearfix">

				<li class="on"><a href="#">我发布的商品</a></li>

			</ul>

			<div id="my_products">
				<div id="onsale_pro"></div>
			</div>
			<div id="myorder" >

				<ul id="middle_nav" class="clearfix">

				<li class="on"><a href="http://localhost:8090/orderlist.jsp">我的订单</a></li>

			</ul>


			</div>


		</div>
	</div>
	<%@ include file="../common/shop_right.jsp"%>
	<%@ include file="../common/shop_footer.jsp"%>
</body>


</html>