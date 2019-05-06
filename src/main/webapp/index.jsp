<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">


<title>易货二手物品交易平台</title>

<link media="all"
	href="${pageContext.request.contextPath}/css/index.css" type="text/css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>

<script src="webapp_js/index.js"></script>

<script src="${pageContext.request.contextPath}/js/add.js"></script>
<script src="${pageContext.request.contextPath}/js/hm.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script src="${pageContext.request.contextPath}/js/common_001.js"></script>
<link rel="icon" href="favicon.ico" type="image/x-icon">



</head>

<body>
	<%@ include file="../common/shop_header.jsp"%>
	<%@ include file="../common/shop_left.jsp"%>


	<div class="container">
		<div class="main center">
			<div class="wrap-site mt20">
				<div class="recom-title"></div>
				<ul class="recom-list group">
					<li><a
						href="${pageContext.request.contextPath}/read/goodRule.action"
						target="_blank" onclick="readRule()">商品发布规则</a></li>
					<!-- _blank在新窗口打开 -->
					<li><a href="${pageContext.request.contextPath}/read/secondIphone.action" target="_blank" onclick="secondIphone()">购买二手iPhone注意事项</a></li>
				</ul>
			</div>
			<div class="label-wr center clearfix">
				<div id="nav-labels">
					<button id="new_pro" class="labels" onclick=""></button>
				</div>

			</div>

			<div class="item-list">
				<ul class="items clearfix">


				</ul>
			</div>
			<!-- 分页 开始 -->
			<!--   <div class="pages">
                        <a class="page-num cur" href="http://hust.2shoujie.com/recent">1</a>
                        <a class="page-num " href="http://hust.2shoujie.com/recent/pn2">2</a>
                        <a class="page-num " href="http://hust.2shoujie.com/recent/pn3">3</a>
                        <a class="page-num " href="http://hust.2shoujie.com/recent/pn4">4</a>
                        <a class="page-num " href="http://hust.2shoujie.com/recent/pn5">5</a>
                        <a class="page-num " href="http://hust.2shoujie.com/recent/pn6">6</a>
                        <a class="page-num " href="http://hust.2shoujie.com/recent/pn7">7</a>
                        <a class="page-num " href="http://hust.2shoujie.com/recent/pn8">8</a>
                        <a class="page-arrow arrow-right" href="http://hust.2shoujie.com/recent/pn2">下一页</a>
        </div> -->
			<!-- 分页 结束 -->
		</div>
	</div>
	<!--href=“http://hust.2shoujie.com/”-->
	<div class="return-to-top">
		<a href="#"></a>
	</div>
	<!--返回顶部-->
</body>
<script type="text/javascript">
/* function readRule() {
	$.ajax({
		type: "POST" ,
		url: "read/goodRule.action",
		 dataType:"text",
		success: function(res) {
			alert(res)
		},error{
		}
	}};
		
}
function secondIphone() {
	$.ajax({
		type: "POST" ,
		url: "read/secondIphone.action",
		 dataType:"text",
		success: function(res) {
			alert(res)
		},error{
		}
	}};
		 */
}

</script>

<%@ include file="../common/shop_right.jsp"%>
<%@ include file="../common/shop_footer.jsp"%>
</html>
