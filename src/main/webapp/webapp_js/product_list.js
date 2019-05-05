function getUrlParam(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
            var r = window.location.search.substr(1).match(reg);  //匹配目标参数
            if (r != null) return decodeURI(r[2]); 
            return null; //返回参数值
        }
var urlValCat = getUrlParam('cat');

var urlValRank = getUrlParam('rank')

var keyword=getUrlParam('keyword')




//alert('当前页面url参数:'+window.location)

//var url ="productListServlet?cat="+urlValCat+"&searchKey=a";
//var url ="productListServlet?cat="+urlValCat;

$(function(){
	if(keyword != null&&keyword != ""&&keyword != "null"){
		
		showSearchResp(keyword);
	}else{
		initProducts();
	}
})


function showSearchResp(word){
	$.ajax({
		type:"POST",
		url:"productSearch.action",
		dataType:"json",
		data:{"keyword":word},
		success:function(resp){
			if(resp.length==0){
				alert("没有查到您要的商品，建议到【全部商品】浏览。")
			}else{
					for(var i=0;i<resp.length;i++){
						$('.items').append(
						'<li class="item"><a href="product_detail.jsp?pid='+resp[i].pid+'" class="img" target="_top"><img id="pro_img" src="'+resp[i].pimage+'" alt="'+resp[i].pdesc+'"></a>'
		                    +' <div class="info">'
		                        +' <div class="price">'+resp[i].salePrice+'</div>'
		                        +' <div class="name"> '
		                        +' <a href="product_detail.jsp?pid='+resp[i].pid+'" target="_top">'+resp[i].pname+'</a>'
		                        +' </div>'
		                        +' <div class="department"><span>原价：'+resp[i].buyPrice+'</span></div>'
		                        +' <div class="place"><span>上架时间：'+resp[i].creatTime+'</span></div>'
		                        +' </div>'
		                 +' </li>&nbsp' )
				 }
			}
		}
	});
	
}


function initProducts(){
	$.ajax({
		type:"POST",
		url:"findAllProductAndOrder.action",
		dataType:"json",
		data:{"cat":urlValCat,'rank':urlValRank},
		success:function(resp){
			var list;
			for(var i=0;i<resp.length;i++){
				$('.items').append(
				'<li class="item"><a href="product_detail.jsp?pid='+resp[i].pid+'" class="img" target="_top"><img id="pro_img" src="'+resp[i].pimage+'" alt="'+resp[i].pdesc+'"></a>'
                    +' <div class="info">'
                        +' <div class="price">'+resp[i].salePrice+'</div>'
                        +' <div class="name"> '
                        +' <a href="product_detail.jsp?pid='+resp[i].pid+'" target="_top">'+resp[i].pname+'</a>'
                        +' </div>'
                        +' <div class="department"><span>原价：'+resp[i].buyPrice+'</span></div>'
                        +' <div class="place"><span>上架时间：'+resp[i].creatTime+'</span></div>'
                        +' </div>'
                 +' </li>&nbsp' )
		 }
		}
	});
}




