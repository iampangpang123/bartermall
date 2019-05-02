<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


   <script src="js/hm.js"></script>
    <script src="js/common.js"></script>
    <script src="js/jquery-1.7.2.min.js"></script>
    <script src="js/common_001.js"></script>
    <script src="js/add.js"></script>
    
    <link media="all" href="../css/index.css" type="text/css" rel="stylesheet">
</head>
<body>
    <nav class="ease2">
    <ul>
        <li class="blank-head">
            <a href="javascript:;"></a>
        </li>
      	
      	<li class="category-12 catg">
            <a href="${pageContext.request.contextPath}/product_list.jsp?cat=0" target="_top">
                <i class="nav-icons">
                    <img src="${pageContext.request.contextPath}/imgs/12.png" alt="全部商品"></i>
                <h3>全部商品</h3>
           </a>
        </li>
      	
        <li class="category-2 catg">
            <a href="${pageContext.request.contextPath}/product_list.jsp?cat=1" target="_top">
                <i class="nav-icons">
                    <img src="${pageContext.request.contextPath}/imgs/2.png" alt="手机"></i>
                <h3>手机</h3>
            </a>
            <div class="sub-nav">
                <span>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=101" target="_top">手机</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=102" target="_top">手机配件</a>
                </span>
            </div>
        </li>
        <li class="category-3 catg">
            <a href="${pageContext.request.contextPath}/product_list.jsp?cat=2" target="_top">
                <i class="nav-icons">
                    <img src="${pageContext.request.contextPath}/imgs/3.png" alt="电脑"></i>
                <h3>电脑</h3></a>
            <div class="sub-nav">
                <span>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=201" target="_top">笔记本</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=202" target="_top">台式机</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=203" target="_top">平板</a>
                </span>
            </div>
        </li>
        <li class="category-4 catg">
            <a href="${pageContext.request.contextPath}/product_list.jsp?cat=3" target="_top">
                <i class="nav-icons">
                    <img src="${pageContext.request.contextPath}/imgs/4.png" alt="数码配件"></i>
                <h3>影音娱乐</h3>
              </a>
            <div class="sub-nav">
                <span>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=301" target="_top">耳机</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=302" target="_top">mp3/mp4</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=303" target="_top">游戏机</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=304" target="_top">键盘</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=305" target="_top">鼠标</a>
                </span>
            </div>
        </li>
        <li class="category-5 catg">
            <a href="${pageContext.request.contextPath}/product_list.jsp?cat=4" target="_top">
                <i class="nav-icons">
                    <img src="${pageContext.request.contextPath}/imgs/5.png" alt="数码"></i>
                <h3>数码配件</h3></a>
            <div class="sub-nav">
                <span>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=401" target="_top">移动硬盘</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=402" target="_top">相机</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=403" target="_top">显示器</a>
                </span>
            </div>
        </li>
        
        <li class="category-7 catg">
            <a href="${pageContext.request.contextPath}/product_list.jsp?cat=5" target="_top">
                <i class="nav-icons">
                    <img src="${pageContext.request.contextPath}/imgs/7.png" alt="运动健身"></i>
                <h3>运动健身</h3></a>
            <div class="sub-nav">
                <span>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=501" target="_top">篮球</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=502" target="_top">足球</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=503" target="_top">球拍</a>
                </span>
            </div>
        </li>
        <li class="category-8 catg">
            <a href="${pageContext.request.contextPath}/product_list.jsp?cat=6" target="_top">
                <i class="nav-icons">
                    <img src="${pageContext.request.contextPath}/imgs/8.png" alt="衣物伞帽"></i>
                <h3>衣物鞋帽</h3></a>
            <div class="sub-nav">
                <span>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=601" target="_top">上衣</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=602" target="_top">裤子</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=603" target="_top">背包</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=604" target="_top">雨伞</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=605" target="_top">鞋</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=606" target="_top">配饰</a>
                </span>
            </div>
        </li>
        <li class="category-11 catg">
            <a href="${pageContext.request.contextPath}/product_list.jsp?cat=7" target="_top">
                <i class="nav-icons">
                    <img src="${pageContext.request.contextPath}/imgs/11.png" alt="生活娱乐"></i>
                <h3>生活娱乐</h3></a>
            <div class="sub-nav">
                <span>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=701" target="_top">乐器</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=702" target="_top">虚拟账号</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=703" target="_top">会员卡</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=704" target="_top">化妆品</a>
                </span>
            </div>
        </li>
        <li class="category-9 catg">
            <a href="${pageContext.request.contextPath}/product_list.jsp?cat=8" target="_top">
                <i class="nav-icons">
                    <img src="${pageContext.request.contextPath}/imgs/9.png" alt="图书教材"></i>
                <h3>图书教材</h3></a>
            <div class="sub-nav">
                <span>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=801" target="_top">教材</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=802" target="_top">考研</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=803" target="_top">课外书</a>
                </span>
            </div>
        </li>
          <li class="category-1 catg">
            <a href="${pageContext.request.contextPath}/product_list.jsp?cat=9" target="_top">
                <i class="nav-icons">
                    <img src="${pageContext.request.contextPath}/imgs/1.png" alt="校园代步"></i>
                <h3>交通出行</h3>
            </a>
            <div class="sub-nav">
                <span>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=901" target="_top">自行车</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=902" target="_top">电动车</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=903" target="_top">公交卡</a>    
                </span>
            </div>
        </li>
        
        
        <li class="category-6 catg">
            <a href="${pageContext.request.contextPath}/product_list.jsp?cat=10" target="_top">
                <i class="nav-icons">
                    <img src="${pageContext.request.contextPath}/imgs/6.png" alt="电器"></i>
                <h3>个人技能</h3></a>
            <div class="sub-nav">
                <span>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=1001" target="_top">摄影</a>
                    <a href="${pageContext.request.contextPath}/product_list.jsp?cat=1002" target="_top">绘画</a>
                </span>
            </div>
        </li>
        <li class="category-12 catg">
            <a href="${pageContext.request.contextPath}/product_list.jsp?cat=11" target="_top">
                <i class="nav-icons">
                    <img src="${pageContext.request.contextPath}/imgs/12.png" alt="其他"></i>
                <h3>其他</h3>
           </a>
        </li>
    </ul>
</nav>
</body>
</html>