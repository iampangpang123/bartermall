<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">


    <title>易货校园二手交易平台</title>

    <link media="all" href="${pageContext.request.contextPath}/css/index.css" type="text/css" rel="stylesheet">
    <script  src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    
     <script src="webapp_js/product_list.js"></script> 
     
    <script src="${pageContext.request.contextPath}/js/add.js"></script>
    <script src="${pageContext.request.contextPath}/js/hm.js"></script>
    <script src="${pageContext.request.contextPath}/js/common.js"></script>
    <script src="${pageContext.request.contextPath}/js/common_001.js"></script>
    <link rel="icon" href="favicon.ico" type="image/x-icon">
	
    
    
</head>

<body>
  <%@ include file="../common/shop_header.jsp" %>
	<%@ include file="../common/shop_left.jsp" %> 
	
	
    <div class="container">
        <div class="main center">
            <div class="rank-by clearfix cur1" data-cur="1">
                <div class="rank-title-wr">
                    <a href="${pageContext.request.contextPath}/product_list.jsp?rank=time">
                        <div class="rank-title default" data-rank="1">时间</div>
                    </a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?rank=point">
                        <div class="rank-title cred" data-rank="3">用户信用(积分)</div>
                    </a>
                    <a class="pr rank-title-price" href="${pageContext.request.contextPath}/product_list.jsp?rank=price">
                        <div class="rank-title pri " data-rank="4">价格</div>
                                                <span id="up_down" order="nor" class="price-nor"></span>
                     </a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?rank=readTimes">
                        <div class="rank-title hot" data-rank="5">热度</div>
                    </a>
                </div>
                <div class="wave ease2"></div>
            </div>
            <div class="item-list">
                <ul class="items clearfix">
                      
                  <!--    <li class="item">
                        <a href="http://hust.2shoujie.com/goods/185614.html" class="img" target="_top"><img src="ios_default_1494065510_107750_0" alt="美利达勇士600山地自行车低价转让"></a>
                        <div class="info">
                            <div class="price">400</div>
                            <div class="name"><a href="http://hust.2shoujie.com/goods/185614.html" target="_top">美利达勇士600山地自行车低价转让</a></div>
                            <div class="department"><span>研究生14级(未认证)</span></div>
                            <div class="place"><span>全校</span></div>
                        </div>
                    </li>
                  -->
                                       
                </ul>
            </div>
            <div class="pages">
                                <a class="page-num cur" href="http://hust.2shoujie.com/category1/time/pn1">1</a>
                                <a class="page-num " href="http://hust.2shoujie.com/category1/time/pn2">2</a>
                                <a class="page-num " href="http://hust.2shoujie.com/category1/time/pn3">3</a>
                                <a class="page-num " href="http://hust.2shoujie.com/category1/time/pn4">4</a>
                                <a class="page-num " href="http://hust.2shoujie.com/category1/time/pn5">5</a>
                                <a class="page-num " href="http://hust.2shoujie.com/category1/time/pn6">6</a>
                                <a class="page-num " href="http://hust.2shoujie.com/category1/time/pn7">7</a>
                                <a class="page-num " href="http://hust.2shoujie.com/category1/time/pn8">8</a>
                                <a class="page-arrow arrow-right" href="http://hust.2shoujie.com/category1/time/pn2">下一页</a>
           </div>
        </div>
    </div>
<div class="return-to-top"><a href="#"></a></div><!--返回顶部-->
    
	
 	<%@ include file="../common/shop_right.jsp" %>
	<%@ include file="../common/shop_footer.jsp" %> 
	
</html>
