$(function(){
	getPage(1)
	control_all()
	delete_all()
})

var currentId;
//获取某一页的数据
function getPage(pn){
	$.ajax({
		url:"/ReleaseAndBuy/getMyGoods",
			type:"get",
				data:"pn="+pn,
					success:function(result){
						build_goods_table(result)
						build_page_info(result)
						built_page_info(result)
					}
	})
}

//解析并显示商品信息
function build_goods_table(result){
	//把前一页的数据清空
	$("#goods_table tbody").empty();
	var goodsList = result.map.pageInfo.list
	//购表商品表格<th>id</th>
	$.each(goodsList,function(index,item){
		var checkBoxTd=$("<td></td>").append($("<input type='checkbox' class='checkitem'>"))
		var goods_id=$("<td></td>").append(item.goodsId)
		var goods_name=$("<td></td>").append(item.goodsName)
		var goods_price=$("<td></td>").append(item.goodsPrice)
		var goods_num=$("<td></td>").append(item.goodsNum)
		var goods_desp=$("<td></td>").append(item.goodsDesp)
		var goods_type=$("<td></td>").append(item.goodsType)
		var goods_cdate=$("<td></td>").append(item.goodsCdate)
		var goods_img=$("<td></td>").append($("<img></img>").attr("src",item.goodsImgurl).attr("height","50px").attr("width","50px"))
	var EditButton = $("<button></button>").addClass("btn btn-primary btn-sm edit_goods_btn").attr("edit_goods_id",item.goodsId)
			.append($("<span>编辑</span>").addClass("glyphicon glyphicon-pencil"))
			var delButton = $("<button></button>").addClass("btn btn-danger btn-sm del_goods_btn").attr("del_goods_id",item.goodsId)
			.append($("<span>删除</span>").addClass("glyphicon glyphicon-trash"))
			var btnId = $("<td></td>").append(EditButton).append(delButton)
			$("<tr></tr>").append(checkBoxTd)
			.append(goods_id)
			.append(goods_name)
			.append(goods_price)
			.append(goods_num)
			.append(goods_desp)
			.append(goods_type)
			.append(goods_cdate)
			.append(goods_img)
			.append(btnId)
			.appendTo("#goods_table tbody")
	})
}
//解析并显示分页信息
function build_page_info(result){
	$("#page_info_area").empty();
	var curPage = result.map.pageInfo.pageNum//获取当前页
	var pages = result.map.pageInfo.pages//获取总页数
	var total = result.map.pageInfo.total//获取总记录数
	$("#page_info_area").append("当前在第"+curPage+"页"+",共"+pages+"页"+",总有"+total+"条记录")
}
//解析并显示分页条
function built_page_info(result){
	$("#page_info_nav").empty();
	var ul =$("<ul></ul>").addClass("pagination")
	var firstPageLi=$("<li></li>").append($("<a></a>").append("首页").attr("href","#").addClass("page-link")).addClass("page-item")
	var prePage=$("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#").addClass("page-link")).addClass("page-item")
	//如果没有前一页，向前的箭头应该禁用
	if(result.map.pageInfo.hasPreviousPage==false){
		prePage.addClass("disabled")
	}
	//点击向前的箭头，跳转到前一页
	else{
		prePage.click(function(){
			getPage(result.map.pageInfo.pageNum-1)
		})
	}
	//如果没有后一页，向后的箭头应该禁用
	var nextPage=$("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#").addClass("page-link")).addClass("page-item")
	if(result.map.pageInfo.hasNextPage==false){
		nextPage.addClass("disabled")
	}
	else{
		//点击向后的箭头，跳转到后一页
		nextPage.click(function(){
			getPage(result.map.pageInfo.pageNum+1)
		})
		
	}
	//创建并输出所有导航页签
	var LastPageLi=$("<li></li>").append($("<a></a>").append("末页").attr("href","#").addClass("page-link")).addClass("page-item")
	ul.append(firstPageLi).append(prePage)
	$.each(result.map.pageInfo.navigatepageNums,function(index,item){
		var numLi=$("<li></li>").append($("<a></a>").append(item).attr("href","#").addClass("page-link")).addClass("page-item")
		if(result.map.pageInfo.pageNum==item){
			numLi.addClass("active")
		}
		numLi.click(function(){
			getPage(item)
		})
		ul.append(numLi)
	})
	ul.append(nextPage).append(LastPageLi)
	var navEle = $("<nav></nav>").append(ul)
		navEle.appendTo("#page_info_nav")
		//前往末页
		LastPageLi.click(function(){
			getPage(result.map.pageInfo.pages)
		})
		//前往首页
		firstPageLi.click(function(){
			getPage(1)
		})
}

//控制编辑商品信息的模态框
	$(document).on("click",".edit_goods_btn",function(){
		$("#goods_update_modal select").empty()
		//显示模态框
		$("#goods_update_modal").modal({
			backdrop:"static"
		})
		//查出商品类型信息
		$.ajax({
			url:"/ReleaseAndBuy/categories",
			async:false,
			type:"get",
			success:function(result){
				//console.log(result)
				$.each(result,function(index,item){
					$("#goods_update_modal select").append($("<option></option>").append(item.category).attr("value",item.category))
				})
			}
		})
		
		//查出商品信息，显示商品信息
		currentId = $(this).attr("edit_goods_id")
		$.ajax({
			url:"/ReleaseAndBuy/getOneGoods/"+currentId,
			type:"get",
			success:function(data){
				//console.log(data)
				$("#update_goods_id_input").val(data.map.goods.goodsId)
				$("#update_goods_name_input").val(data.map.goods.goodsName)
				$("#update_goods_price_input").val(data.map.goods.goodsPrice)
				$("#update_goods_num_input").val(data.map.goods.goodsNum)
				$("#update_goods_desp_input").val(data.map.goods.goodsDesp)
				$("#update_goods_cdate_input").val(data.map.goods.goodsCdate)
				$("#goods_update_modal select").val([data.map.goods.goodsType])
			}
		});
	})

	
//删除单个数据
	$(document).on("click",".del_goods_btn",function(){
		var current = $(this).attr("del_goods_id");
		//获取商品id
		var goodsName = $(this).parents("tr").find("td:eq(2)").text();
		delete_one(current,goodsName)
	})
	
	//删除单个商品
	function delete_one(goodsId,goodsName){
		//弹出是否确认删除对话框
		if(confirm("确认删除【"+goodsName+"】吗")){
		$.ajax({
			url:"/ReleaseAndBuy/delete/"+goodsId,
			type:"delete",
			success:function(data){
				alert(data.msg)
				getPage(1)
			}
		})
		}
	}
	
	//单击全选框控制单选框
function control_all(){
	$(".update_goods_checkAll").click(function(){
		var checkAll = $(this).prop("checked")
		$(".checkitem").prop("checked",checkAll)
		})
		
	//选中所有单选框控制单选框
	$(document).on("click",".checkitem",function(){
		var flag = $(".checkitem:checked").length==$(".checkitem").length
		$(".update_goods_checkAll").prop("checked",flag)
	})
	}
	
	//批量删除
function removePatch(){
		var goodsId=""
		var goodsName=""
		$("#delete_patch").click(function(){
			//清空购物车
			if($(".update_goods_checkAll").prop("checked")==true){
				delete_all()
			}else{
				if($(".checkitem:checked").length==0){
					confirm("请勾选上要删除的商品哦~")
					return;
				}
				var items = $(".checkitem:checked")
				$.each(items,function(){
					goodsId+=$(this).parents("tr").find("td:eq(1)").text()+"-"
					goodsName+=$(this).parents("tr").find("td:eq(2)" ).text()+","
				})
				delete_one(goodsId,goodsName)
			}
		})
	}

//清空所有发布的商品
function delete_all(){
	$("#clear").click(function(){
		//清空
		clearPublishedGoods()
	})
}

function clearPublishedGoods(){
	if(confirm("确定清空您之前发布的商品吗？")){
		$.ajax({
			url:"/ReleaseAndBuy/clearPublishedGoods",
			type:"delete",
			success:function(data){
				alert(data.msg)
				getPage(1)
			}
		})
	}
}

