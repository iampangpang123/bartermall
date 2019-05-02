<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">


    <title>易货二手物品交易平台</title>

    <link media="all" href="${pageContext.request.contextPath}/css/index.css" type="text/css" rel="stylesheet">
    <script  src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    
     <script src="webapp_js/index.js"></script> 
    
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
                <div class="wrap-site mt20">
            <div class="recom-title"></div>
            <ul class="recom-list group">
                <li><a href="http://www.2shoujie.com/publishRule" target="_top">商品发布规则</a></li>
                                <li><a href="http://www.2shoujie.com/article/4.html" target="_top">购买二手iPhone注意事项</a></li>
            </ul>
        </div>
        <div class="label-wr center clearfix">
            <div id="nav-labels">
                <button id="new_pro" class="labels" onclick="" ></button>
            </div>
           
        </div>
        
        <div class="item-list">
            <ul class="items clearfix">
            
            
             <!-- <c:forEach items="${list}" var="pros"> 
            	<li class="item">
                    <a href="#" class="img" target="_top"><img src="${pros.pimage }" alt="${pros.pname }"></a>
                    <div class="info">
                        <div class="price">"${pros.salePrice }"</div>
                        <div class="name">
                            <a href="http://hust.2shoujie.com/goods/169685.html" >"${pros.pname }"</a>
                        </div>
                        <div class="department"><span>"${pros.cid2 }"</span></div>
                        <div class="school"><span>推荐</span></div>
                     </div>
                </li>
            </c:forEach> -->
            
            
           <!--  <li class="item">
                    <a href="http://hust.2shoujie.com/goods/169685.html" class="img" target="_top"><img src="ios_default_1455711227_71_0" alt="MacbookPro 13寸 12年版"></a>
                    <div class="info">
                        <div class="price">3500</div>
                        <div class="name">
                            <a href="http://hust.2shoujie.com/goods/169685.html" target="_top">MacbookPro 13寸 12年版</a>
                        </div>
                        <div class="department"><span>计算机12级(学号认证)</span></div>
                        <div class="place"><span>华科</span></div>
                        <div class="school"><span>推荐</span></div>
                     </div>
                </li>
               -->
                                
              
            </ul>
        </div>
        <!-- 分页 开始 -->
        <div class="pages">
                        <a class="page-num cur" href="http://hust.2shoujie.com/recent">1</a>
                        <a class="page-num " href="http://hust.2shoujie.com/recent/pn2">2</a>
                        <a class="page-num " href="http://hust.2shoujie.com/recent/pn3">3</a>
                        <a class="page-num " href="http://hust.2shoujie.com/recent/pn4">4</a>
                        <a class="page-num " href="http://hust.2shoujie.com/recent/pn5">5</a>
                        <a class="page-num " href="http://hust.2shoujie.com/recent/pn6">6</a>
                        <a class="page-num " href="http://hust.2shoujie.com/recent/pn7">7</a>
                        <a class="page-num " href="http://hust.2shoujie.com/recent/pn8">8</a>
                        <a class="page-arrow arrow-right" href="http://hust.2shoujie.com/recent/pn2">下一页</a>
        </div>
        <!-- 分页 结束 -->
    </div>
</div>
<!--href=“http://hust.2shoujie.com/”-->
<div class="return-to-top"><a href="#"></a></div><!--返回顶部-->
    
	
 	<%@ include file="../common/shop_right.jsp" %>
	<%@ include file="../common/shop_footer.jsp" %> 
	
</html>
