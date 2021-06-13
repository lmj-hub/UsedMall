$(function(){
	getProductCategories()
	//输出校验信息
	dealform("#publish_goods_form","#publish_goods_btn","/ReleaseAndBuy/publishGoods")
	dealform("#update_save_form","#update_goods_save","/ReleaseAndBuy/updateGoods")
	dealform("#publish_re_form","#publish_re_btn","/ReleaseAndBuy/publishRequirement")
	dealform("#update_save_re_form","#update_re_save","/ReleaseAndBuy/updateRe")
		validated_add_goods_form()//校验发布商品表单的信息
		validated_add_re_form()//校验发布需求表单的信息
		validated_update_goods_form()//校验编辑商品信息表单的信息
		validated_update_re_form()//校验编辑需求信息表单的信息
		registerSelectAll()//注册购物车全选框
		registerSelectOne()//注册单选框
		removeOne()//删除单件商品
		clearCart()//清空购物车
		removePatch()//批量删除商品
		countOne()//结算单件商品
	
	 
/*	$("#publish_goods_btn").click(function(){
		//判断发布表单是否合法
		var object = result("#publish_goods_form").attr("valid")
		if(object=="false"){
			alert("您的输入不合法，请按正确的格式填写!")
			return false;
		}else{
			var data = new FormData($("#publish_goods_form")[0])
			var reset_btn = $("#publish_goods_form button")
			//由于参数包含文件对象，所以表单要使用multipart/form-data类型，同时ajax发送参数时
			//要发送formdata对象
			//普通数据可以直接表单序列法，以字符串的形式发送数据
			//var data = $("#publish_goods_form").serialize();
			$.ajax({
				url:"/SchoolOldGoodsPlatForm/publishGoods",
				type:"post",
				data:data,
				processData:false,//必须有
				contentType:false,//必须有
				success:function(data){
					alert(data.msg)
					reset_btn.trigger("click");//提交数据后出发表单重置事件，重置表单，清空内容
					removeAllClass("#publish_goods_form")
				}
			})
		}
	})
	
	//绑定发布商品界面重置按钮，重置时把提示信息样式也删掉
	$("#publish_goods_form button").click(function(){
		removeAllClass("#publish_goods_form")
	})
	
	//绑定发布需求重置按钮，重置时把提示信息样式也删掉
	$("#publish_re_form button").click(function(){
		removeAllClass("#publish_re_form")
	})
	*/
})
//处理表单（绑定提交，重置标签，发送aiax请求保存数据等）
function dealform(form,sub_btn,url){
	//点击提交按钮，发送aiax请求保存数据
	$(sub_btn).click(function(){
		//判断发布表单是否合法
		var object = result(form).attr("valid")
		if(object=="false"){
			alert("您的输入不合法，请您按正确的格式填写!")
			return false;
		}else{
			//if($(form).prop("enctype")=="multipart/form-data"){
				//由于参数包含文件对象，所以表单要使用multipart/form-data类型，同时ajax发送参数时
				//要发送formdata对象
				var data = new FormData($(form)[0])
			//}else{
				//普通数据可以直接表单序列法，以字符串的形式发送数据
				//var data = $(form).serialize();
			//}
			var reset_btn = $(form+" button")
			$.ajax({
				url:url,
				type:"post",
				data:data,
				processData:false,//必须有
				contentType:false,//必须有
				success:function(data){
					alert(data.msg)
					reset_btn.trigger("click");//提交数据后出发表单重置事件，重置表单，清空内容
					removeAllClass(form)
				}
			})
		}
	})
	//绑定发布商品界面重置按钮，重置时把提示信息样式也删掉
	$(form+" button").click(function(){
		removeAllClass(form)
	})
}




//前端检验发布商品表单所有元素
function validated_add_goods_form(){
	validated("#goods_name","商品名称",false)
	validated("#goods_price","商品价格",false)
	validated("#goods_num","商品数量",false)
	validated("#goods_type","商品类型",false)
	validated("#goods_desp","商品描述",false)
	validated("#goods_cdate","日期",true,/\d{4}-\d{2}-\d{2}/)
	validated("#picture","图片",false)
}

//前端检验编辑商品表单所有元素
function validated_update_goods_form(){
	validated("#update_goods_name_input","商品名称",false)
	validated("#update_goods_price_input","商品价格",false)
	validated("#update_goods_num_input","商品数量",false)
	validated("#update_goods_type","商品类型",false)
	validated("#update_goods_desp_input","商品描述",false)
	validated("#update_goods_cdate_input","日期",true,/\d{4}-\d{2}-\d{2}/)
}


//前端校验发布需求表单所有元素
function validated_add_re_form(){
	validated("#re_desp","需求描述",true,/^(.|\n){2,100}$/)
}

//前端校验编辑需求表单所有元素
function validated_update_re_form(){
	validated("#update_re_name_input","需求描述",true,/^(.|\n){2,100}$/)
}


//获取表单检验结果
function result(ele){
	var object = $(ele).find("input[valid=false],textarea[valid=false],select[valid=false]")
	return object;
	
}


//前端校验发布界面日期格式
//function validated_date(ele){
//	$(ele).change(function(){
//		var regex_date=/\d{4}-\d{2}-\d{2}/;
//		var date_value=$(ele).val();
//		if(regex_date.test(date_value)){
//			show_msg(ele,"日期格式正确！",200)
//		}else{
//			show_msg(ele,"请按照xxxx-xx-xx的格式正确输入上传时间！",-1)
//		}
//	})
//}
//前端校验发布界面是否有文件上传
//function validated_file(ele){
//	if($(ele).val()==""){
//		show_msg(ele,"商品图片不能为空！",-1)
//	}else{
//		show_msg(ele,"商品图片可用！",200)
//	}
//}
//前端校验特定元素
//参数flag为true表示使用正则表达式校验
function validated(ele,msg,flag,regex){
	$(ele).change(function(){
		if(flag==true){
			var date_value=$(ele).val();
			if(regex.test(date_value)){
				show_msg(ele,msg+"格式正确！",200)
			}else{
				show_msg(ele,msg+"格式不正确，请按正确格式填写！",-1)
			}
		}else{
			if($(ele).val()==""){
				show_msg(ele,msg+"不能为空！",-1)
			}else{
				show_msg(ele,msg+"可用！",200)
			}
		}
	})
}


//输出错误信息
function show_msg(ele,msg,status){
	if(status==-1){
		removeClass(ele,status)
		$(ele).addClass("is-invalid")
		$(ele).next("span").addClass("invalid-feedback").text(msg)
		$(ele).attr("valid","false")
	}
	if(status==200){
		removeClass(ele,status)
		$(ele).addClass("is-valid")
		$(ele).next("span").addClass("valid-feedback").text(msg)
		$(ele).attr("valid","true")
	}
	
}	
//清除特定元素类检验样式
function removeClass(ele,status){
	if(status==-1){
		$(ele).removeClass("is-valid is-invalid")
		$(ele).next("span").removeClass("invalid-feedback valid-feedback")
		$(ele).next("span").text("")
	}
	if(status==200){
		$(ele).next("span").removeClass("invalid-feedback valid-feedback")
		$(ele).removeClass("is-valid is-invalid")
		$(ele).next("span").text("")
	}
	
}

//清除表单所有元素检验样式
function removeAllClass(ele){
	var object = $(ele).find("input[valid],textarea[valid],select[valid]")
	$.each(object,function(){
		var idSelector = "#"+$(this).prop("id");
		removeClass(idSelector,200)
	})
}


//点击购物车全选框，控制其他单选框
function registerSelectAll(){
	$(".select_all").click(function(){
		var flag = $(this).prop("checked")
		$(".select_one").prop("checked",flag);
	})
}

//点击单选框控制全选框
function registerSelectOne(){
	$(".select_one").click(function(){
		var flag = $(".select_one:checked").length==$(".select_one").length
			$(".select_all").prop("checked",flag)
	})
	
}
//结算一件商品
function countOne(){
	$(".goods_account").click(function(){
		var goodsId = $(this).attr("acc_id");
		var num = $(this).parents("tr").find("td:eq(3)").text();
		var data=goodsId+","+num
		$.ajax({
			url:"/Order/toCreate",
			type:"post",
			data:"data="+data,
			success:function(data){
				if(data==true){
					alert("订单处理成功！")
				}else{
					alert("订单处理失败")
				}
			}
				
		})
	})
}

//批量结算商品

//从购物车删除一件商品
function remove(goodsName,goodsId){
	if(confirm("确定要从购物车移除"+"【"+goodsName+"】吗，稍后可能就要降价了哟~")){
		$.ajax({
			url:"/ReleaseAndBuy/deleteGoods/"+goodsId,
			type:"delete",
			success:function(data){
				alert(data.msg)
				
				window.location.reload()
			}
		})
	}

}
//发送删除请求
function removeOne(){
	$(".goods_delete").click(function(){
		var goodsId = $(this).attr("del_id");
		var goodsName = $(this).parents("tr").find("td:eq(1) font[name=goods_name]" ).text()
		remove(goodsName,goodsId)
	})
}

//清空购物车
function clearCart(){
	$("#clear_cart").click(function(){
		//清空购物车
		clear()
	})
}
//发送清空请求
function clear(){
	if(confirm("确定清空购物车吗？")){
		$.ajax({
			url:"/ReleaseAndBuy/clearCart",
			type:"delete",
			success:function(data){
				alert(data.msg)
				window.location.reload()
			}
		})
	}

}



//批量删除
function removePatch(){
	var goodsId=""
	var goodsName=""
	$("#remove_patch").click(function(){
		//清空购物车
		if($(".select_all").prop("checked")==true){
			clear()
		}else{
			if($(".select_one:checked").length==0){
				confirm("请勾选上要删除的商品哦~")
				return;
			}
			var items = $(".select_one:checked")
			$.each(items,function(){
				goodsId+=$(this).parents("tr").find("td:eq(5) button:eq(1)").attr("del_id")+"-"
				goodsName+=$(this).parents("tr").find("td:eq(1) font[name=goods_name]" ).text()+","
			})
				remove(goodsName,goodsId)
		}
	})
}


//从数据库获取商品类型
function getProductCategories(){
	$("#publish_goods_form select").empty()
	$.ajax({
		url:"/ReleaseAndBuy/categories",
		async:false,
		type:"get",
		success:function(result){
			//console.log(result)
			$("#publish_goods_form select").append($("<option></option>").append("请选择您的商品种类").attr("hidden",true))
			$.each(result,function(index,item){
				$("#publish_goods_form select").append($("<option></option>").append(item.category).attr("value",item.category))
			})
		}
	})
}






