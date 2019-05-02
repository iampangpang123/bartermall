function getUrlParam(name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
            var r = window.location.search.substr(1).match(reg);  //匹配目标参数
            if (r != null) return unescape(r[2]); 
            return null; //返回参数值
        }
var userid = getUrlParam('id');

$(document).ready(function(){
	inituser(userid);
	inituserpros(userid);
})

function inituser(id){
	$.ajax({
		type:"POST",
		url:"userServlet.action",
		dataType:"json",
		data:{"uid":id,"flag":1},
		success:function(resp){
		var name = resp.name;
		var tel = resp.tel;
		var qq = resp.qq;
		var photo = resp.photo;
		var college = resp.college;
		var grade = resp.grade;
		var area = resp.area;
		var state = resp.state;
		var str1 = '<div id="account_info"><h2>账户信息</h2>' +
				'<ul class="infos" id="userid"><li>账号</li><li class="right_info">'+id+'</li></ul>' +
			    '<ul class="infos" id="userstate"><li>认证状态</li><li class="right_info">'+state+'</li></ul></div>';
			    
		var str2 = '<form action="editUserImage.action" enctype="multipart/form-data" method="post">' +
				'<ul class="infos" ><li>上传认证</li><li> <input type="file" name="uploadFile" /></li></ul>' +
				'<ul class="infos"><li>照片</li> <input  type="submit" value="点击上传照片" /></ul> ' +
				'<input id="userconfirmid" type="hidden" name="uid" value="">' +
				'</form>';
		
					
		
		var str3 = '<div id="base_info">' +
		'<h2>基本信息<span id="edit_info">编辑</span><span id="save_info">保存</span></h2>' +
		'<ul class="infos"><li>昵称</li><li class="right_info"><span id="nickname_span">'+name+'</span><input value="'+name+'" id="nickname"type="text"></li></ul> '+
		'<ul class="infos"><li>手机</li><li class="right_info"><span id="tel_span">'+tel+'</span><input value="'+tel+'" id="tel"type="text"></li></ul>' +
		'<ul class="infos"><li>QQ</li><li class="right_info"><span id="qq_span">'+qq+'</span><input value="'+qq+'" id="qq"type="text"></li></ul>' +
		'<ul class="infos"><li>学院</li><li class="right_info"><span id="col_span">'+college+'</span><input value="'+college+'" id="col"type="text"></li></ul>'+ 
		'<ul class="infos"><li>年级</li><li class="right_info"><span id="grade_span">'+grade+'</span><input value="'+grade+'"id="grade"type="text"></li></ul>'+ 
		'<ul class="infos"><li>校区</li><li class="right_info"><span id="area_span">'+area+'</span><input value="'+area+'"id="area"type="text" placeholder="青山/黄家湖"></li></ul>'+		
		'</div> ';
		var str;
		if(state=="未认证"){
			$("#userconfirmid").val(userid);
			str = str1+str2+str3;
		}else{
			str = str1+str3;
		}
		
		var myinfo=$(str);
		
		
		$("#userpoint").html('<p>'+resp.point+'</p>')
		
		$("#user_photo").html('<img id="origin_ph" src="imgs/'+photo+'" alt="大头像"> '+
          ' <img id="change_photo" src="imgs/person_hover.png" alt="更换头像" style="display: none;">')
          
		$("#user_big_name").html('<p>'+name+'</p>');
		$("#my_info").append(myinfo);
		}
	});
}


function inituserpros(uid){
	$.ajax({
		type:"POST",
		url:"userServlet.action",
		dataType:"json",
		data:{"uid":uid,"flag":2},
		success:function(resp){
		var count = resp.length
		for(var i = 0;i<resp.length;i++){
			if(resp[i].state=="在售"){
			var mypro1 = $('<div class="enshr_each" id="prolist">  ' +
					'<div class="enshr_info"><h2><a href="product_detail.jsp?pid='+resp[i].pid+'" '+
					'title="坚果pro">'+resp[i].pname+'</a></h2><p>'+resp[i].pdesc+'</p>'+
					'<div class="enshr_state"><span id="prostate">状态：'+resp[i].state+'</span>' +
					'&nbsp;&nbsp;<span id="prostate">上架日期：'+resp[i].creatTime+'</span>'+
					'<span class="enshrine_it" onclick="sellout('+resp[i].pid+');">确认售出</span>'+
					'<span class="enshrine_it make_edition" onclick="offshelf('+resp[i].pid+');">下架</span>'+
					'<span class="enshrine_it make_edition" onclick="refresh('+resp[i].pid+');">擦亮</span>'+
	                '<a href="product_release.jsp?pid='+resp[i].pid+'" target="_top"><span class="enshrine_it  make_edition">编辑</span></a> '+
	                '</div></div><a href="product_detail.jsp?pid='+resp[i].pid+'">'+
	                '<img class="enshr_ph" src="'+resp[i].pimage+'" alt="'+resp[i].pname+'"></a></div>')
			}
	        if(resp[i].state=="已售"){
			var mypro1 = $('<div class="enshr_each" id="prolist">  ' +
					'<div class="enshr_info"><h2><a href="product_detail.jsp?pid='+resp[i].pid+'" '+
					'title="坚果pro">'+resp[i].pname+'</a></h2><p>'+resp[i].pdesc+'</p>'+
					'<div class="enshr_state"><span id="prostate">状态：'+resp[i].state+'</span>' +
					'&nbsp;&nbsp;<span id="prostate">上架日期：'+resp[i].creatTime+'</span>'+
					'<span class="enshrine_it" style="color:yellow" );">已售出</span>'+
					'<span class="enshrine_it make_edition" style="color:red"  onclick="offshelf('+resp[i].pid+');">删除</span>'+
	                '</div></div><a href="product_detail.jsp?pid='+resp[i].pid+'">'+
	                '<img class="enshr_ph" src="'+resp[i].pimage+'" alt="'+resp[i].pname+'"></a></div>')
			}
	       
	                
	                
			$("#onsale_pro").append(mypro1);
		}
		$("#procount").html('<p>'+count+'</p>')
		
		}
	});
}

function offshelf(pid){
    if (!confirm('下架后商品别人将看不到，请是否确认下架？')) {
        return;
    }
    $.post('productedit', 
    		{"pid" : pid,"flag":1},
    		function(res){
		        if (res.length > 2) {
		        	//失败
		        	//alert("if:"+res.length)
		            location.reload();
		        } else {
		        	//alert("else res:"+res.length)
		        }
    });
}

function refresh(pid){
    if (!confirm('擦亮后，您的商品将靠前展示。')) {
        return;
    }
    $.post('productedit', 
    		{"pid" : pid,"flag":2},
    		function(res){
		       if (res.length > 2) {
		        	
		        	alert("恭喜！您已擦亮商品！")
		            location.reload();
		        } else {
		        	alert("对不起，擦亮失败，请重试")
		        }
    });
}


function sellout(pid){
    if (!confirm('确认售出？')) {
        return;
    }
    $.post('productedit', 
    		{"pid" : pid,"flag":3},
    		function(res){
		       if (res.length > 2) {
		        	
		        	alert("恭喜！您又售出一个商品！")
		            location.reload();
		        } else {
		        	alert("售出失败，请重试")
		        }
    });
}

