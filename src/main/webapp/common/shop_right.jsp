<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<!-- <link rel="stylesheet"  href="../css/bootstrap.min.css">
	<link rel="stylesheet"  href="../css/bootstrap-switch.css">
	<script  src="../js/jquery-3.1.1.min.js"></script>
	<script  src="../js/bootstrap.min.js"></script>
	<script  src="../js/bootstrap-switch.js"></script>
	<link href="../css/main.css" rel="stylesheet"></head>
    <link href="../css/highlight.css" rel="stylesheet">
    <script src="../js/highlight.js"></script>
    <script src="../js/main.js"></script> -->

</head>
<body>
	    <aside>
 >
       	
        <div id="release-button1" >
             <a  href="want_list_creat.jsp" style="color: white" id="want-buy"
             onlick="return ${session.user.name} "> 我要买</a> 
            <!-- <a  href="#" style="color: white" id="want-buy"> 我要买</a> -->
        </div>
        <br><br>
        <div id="release-button2" >
            <a  href="product_release.jsp" style="color: white" id="want-sale"> 我要卖</a>
        </div>       
        <br><br>
        <div id="release-button3" >
            <a  href="${pageContext.request.contextPath}/want_list.jsp" style="color: white" > 求购专区</a>
        </div>

        <div class="helped ">
         <span class="helpers" id="ordercount"></span>
        </div>
        
        <div class="fl-wrapper clearfix">
        <div class="wx-follow">
            <a href="javascript:void(0);" class="fl-icon">
                <img src="imgs/weixin-fl.png">
            </a>
            <div class="wx-fl-qrcode">
                <p>微信关注</p>
                <img height="100px" height="100px" src="imgs/wx-iampangpang.png">
                <p>易货二手交易平台</p>
                <div class="dc-dot"></div>
            </div>
        </div>
       
    </div>
    </aside>
</body>
<script>
$(document).ready(function(){
	$.post("order",function(resp){
		$("#ordercount").html(''+resp+'');
	})
})

</script>

</html>
