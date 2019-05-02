<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
.loginandrigist {
    margin-left: 1000px;
    margin-top: -66px;
}

#person_info {
    height: 100%;
    cursor: pointer;
    position: relative;
}
main.css?v=201506100001:20
.clearfix {
    zoom: 1;
}
</style>



<script type="text/javascript">
function searchPro(){
	var keyword=$("#keyword").val()
	window.location.href="product_list.jsp?keyword="+keyword;
}


</script>
</head>
<body>
	<header class="ease2">
	    <a href="http://www.zzuli.edu.cn/">
	        <img class="logo ease2" src="imgs2/timg.jpg" alt="易货">
	    </a>
	    <div class="header-main center ease2">
	        <a href='<c:url value="/index.jsp" ></c:url>' class="slogan">
	            <h1 class="s-main"></h1>
	            <div class="s-submain"></div>
	            <img src="imgs2/title2.1.png" alt=""易货"">
	        </a>
	        <div class="search-box-wr ease2">
	            <div class="search-box center" >
	               <button  class="search-submit" id="search-button" onclick="searchPro()">搜索</button> 
	                <div class="input-wr">
	                    <img class="search-icon" src="imgs/search-icon.png">
	                    <div class="search-input">
	                    <input name="keyword" id="keyword" x-webkit-speech="" placeholder="搜索你想要的商品" value="" type="text">
	                    </div>
	                </div>
	            </div>

	            <div class="search-hots center ease2">
	                <span>热门：</span>
	                <a class="hots" href="${pageContext.request.contextPath}/product_list.jsp?cat=101" target="_top">手机</a>
	                <a class="hots" href="${pageContext.request.contextPath}/product_list.jsp?cat=201" target="_top">笔记本</a>
	                <a class="hots" href="${pageContext.request.contextPath}/product_list.jsp?cat=701" target="_top">乐器</a>
	                <a class="hots" href="${pageContext.request.contextPath}/product_list.jsp?cat=8" target="_top">图书</a>
	            </div>
	        </div>
<%-- <input   type="text" value="${sessionScope.user.id}"> --%>
	        <div class="ease2 log-reg" id="have-not-login">
	       		<!-- loginandrigist -->
	            <div class="button" ><a href="login.jsp">登录</a></div>
	            <div class="button" ><a href="login.jsp?a=0">注册</a></div>
	        </div>
	    </div>
	</header>
</body>

<script>
	$(document).ready(function(){
	var userName = "${sessionScope.user.name}"
	var userPhoto = "${sessionScope.user.photo}"
	var userId = "${sessionScope.user.id}"  
	
	if(userId != ""&&userId!=null){
	$("#have-not-login").html("");
	var str=$('<div id="have_login" class="clearfix"><div id="person_info" class="clearfix">'+
            '<a href="user_center.jsp?id='+userId+'"><img  class="avatar"  style="height:48px;width:48px;" src="imgs/'+userPhoto+'"></a>'+
            '<div  style="display:inline;"  class="person_name"><a   href="user_center.jsp?id='+userId+'" id="id-btn">Hi：'+userId+'</a></div>'+
            '<div  style="display:inline;"  class="person_name"><a   href="<c:url value='/quitLogin.action'/>" id="log-btn">&nbsp;&nbsp;&nbsp;&nbsp;退出</a></div>'+
            '</div> </div>')
	$("#have-not-login").append(str)
	}
	
	$("#log-btn").click(function(){
		$.post("logoutServlet",function(status){
			$("#have-not-login").html("");
			$("#have-not-login").append('<div class="button" ><a href="login.jsp">登录</a></div>'+
		            '<div class="button" ><a href="login.jsp?a=0">注册</a></div>')
		})
		window.location.href="index.jsp";
	})
	})
	
	
</script>


</html>