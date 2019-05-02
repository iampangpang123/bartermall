$(document).ready(function(){
	initProducts();
	
})
function initProducts(){
	$.ajax({
		type:"POST",
		url:"newProduct.action",
		dataType:"json",
		data:{},
		success:function(resp){
			var i;
			for( i=0;i<resp.length;i++){
				if(resp[i].isHot=="1"){
					resp[i].isHot="推荐";
				}else{
					resp[i].isHot="新品";
				}
			}
			for( i=0;i<resp.length;i++){
				var str = '<li class="item"><a href="product_detail.jsp?pid='+resp[i].pid+'" class="img" target="_top"><img id="pro_img" src="'+resp[i].pimage+'" alt="'+resp[i].pdesc+'"></a>'
                +' <div class="info">'
                +' <div class="price">'+resp[i].salePrice+'</div>'
                +' <div class="name"> '
                +' <a href="product_detail.jsp?pid='+resp[i].pid+'" target="_top">'+resp[i].pname+'</a>'
                +' </div>'
                +' <div class="department"><span>原价：'+resp[i].buyPrice+'</span></div>'
                +' <div class="place"><span>上架时间：'+resp[i].creatTime+'</span></div>';
				
				if(resp[i].isHot=="推荐"){
					str += '<div class="school0"><span>'+resp[i].isHot+'</span></div></div> </li>&nbsp';
				}
				if(resp[i].isHot=="新品"){
					str += '<div class="school"><span>'+resp[i].isHot+'</span></div></div> </li>&nbsp';
				}
				$('.items').append(
						str
				 )
                 
		 }
		}
	});
}



	

		
	
	