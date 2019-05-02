<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<script src="js/hm.js"></script>
        <script src="js/add.js"></script>
        <script src="js/release.js"></script>
        <script src="js/jquery-3.1.1.min.js"></script>
        <script src="plupload.full.min.js"></script>
        <script src="js/zh_cn.js"></script>
        <script src="js/qiniu.min.js"></script>
        <script src="js/common.js"></script>
        <link media="all" href="css/release_product.css" type="text/css" rel="stylesheet">
		<link media="all" href="css/index.css" type="text/css" rel="stylesheet">
		
		<script>
		var str="${sessionScope.user.name}"
			if(!str){
				alert("请您先登录");
				window.location.href="login.jsp";
			}
		</script>
</head>
<body>
<%@ include file="../common/shop_header.jsp" %>
	<div class="container">
            <div class="main center">
                <img class="release-icon-main" src="imgs/release-icon.png" alt="">
                <div class="wave-fluid"></div>
                <div class="wantInfo-release-title">发布商品出售</div>
                <form action="wantBuyGoods.action" method="post">
                <div class="form-wr">
                    <div class="form-must-wr">
                        <div class="form-item l want-title">
                            <div class="form-key">
                                <span>商品名称</span>
                            </div>
                            <div class="form-value">
                                <div class="form-input-wr">
                                    <input id="title" name="title" placeholder="最多10个字" value="" type="text"></div>
                            </div>
                        </div>
                        <div class="form-item xl want-desc">
                            <div class="form-key">
                                <span>描述</span>
                             </div>
                            <div class="form-value">
                                <div class="form-input-wr">
                                    <textarea name="desc" id="desc" placeholder="建议填写对所需求物品的要求"></textarea>
                                </div>
                            </div>
                        </div>
                        <div class="form-item l goods-title">
                            <div class="form-key">
                                <span>期望交易地点</span></div>
                            <div class="form-value">
                                <div class="form-input-wr">
                                    <input id="trade_place" name="trade_place" placeholder="格式：郑州/郑州轻工业大学" value="" type="text">
                              	</div>
                            </div>
                        </div>
                        <div class="form-item m want-price">
                            <div class="form-key">
                                <span>期望价格</span>
                            </div>
                            <div class="form-value">
                                <div class="form-input-wr">
                                    <input class="price" id="price" name="price" value="" type="text"></div>
                            </div>
                        </div>
                        
                    </div>
                    
                    

                   
                    <input id="creat_user"  name="url"value="<%=request.getRequestURI() %>>" type="hidden">
                    <button type="submit" class="form-submit" >马上发布</button>
              </div>
              </form>
            </div>
        </div>
</body>
</html>