$(function(){
	getRePage(1)
	control_all
	removeMany()
	remove_all()
})

//前往特定一个页面
function getRePage(pn){
	$.ajax({
		url:"/ReleaseAndBuy/getMyRequirements",
			type:"get",
				data:"pn="+pn,
					success:function(result){
						build_requirements_table(result)
						build_re_page_info(result)
						build_re_page_info_nav(result)
					}
	})
}

var re_currentId;
//解析并显示需求信息
function build_requirements_table(result){
	//把前一页的数据清空
	$("#re_table tbody").empty();
	var re_list = result.map.pageInfo.list
	//构建需求表格<th>id</th>
	$.each(re_list,function(index,item){
		var checkBoxTd=$("<td></td>").append($("<input type='checkbox' class='re_checkitem'>"))
		var re_id=$("<td></td>").append(item.reId)
		var re_name=$("<td></td>").append(item.reMsg)
		var re_date=$("<td></td>").append(item.reDate)
	var EditButton = $("<button></button>").addClass("btn btn-primary btn-sm edit_re_btn").attr("edit_re_id",item.reId)
			.append($("<span>编辑</span>").addClass("glyphicon glyphicon-pencil"))
			var delButton = $("<button></button>").addClass("btn btn-danger btn-sm del_re_btn").attr("del_re_id",item.reId)
			.append($("<span>删除</span>").addClass("glyphicon glyphicon-trash"))
			var btnId = $("<td></td>").append(EditButton).append(delButton)
			$("<tr></tr>").append(checkBoxTd)
			.append(re_id)
			.append(re_name)
			.append(re_date)
			.append(btnId)
			.appendTo("#re_table tbody")
	})
}

//解析并显示分页信息
function build_re_page_info(result){
	$("#re_page_info_area").empty();
	var curPage = result.map.pageInfo.pageNum//获取当前页
	var pages = result.map.pageInfo.pages//获取总页数
	var total = result.map.pageInfo.total//获取总记录数
	$("#re_page_info_area").append("当前在第"+curPage+"页"+",共"+pages+"页"+",总有"+total+"条记录")
}
//解析并显示分页条
function build_re_page_info_nav(result){
	$("#re_page_info_nav").empty();
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
			getRePage(result.map.pageInfo.pageNum-1)
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
			getRePage(result.map.pageInfo.pageNum+1)
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
			getRePage(item)
		})
		ul.append(numLi)
	})
	ul.append(nextPage).append(LastPageLi)
	var navEle = $("<nav></nav>").append(ul)
		navEle.appendTo("#re_page_info_nav")
		//前往末页
		LastPageLi.click(function(){
			getRePage(result.map.pageInfo.pages)
		})
		//前往首页
		firstPageLi.click(function(){
			getRePage(1)
		})
}

//控制编辑需求信息的模态框
$(document).on("click",".edit_re_btn",function(){
	$("#re_update_modal select").empty()
	//显示模态框
	$("#re_update_modal").modal({
		backdrop:"static"
	})
	//查出需求信息，显示需求信息
	re_currentId = $(this).attr("edit_re_id")
	$.ajax({
		url:"/ReleaseAndBuy/getOneRequirement/"+re_currentId,
		type:"get",
		success:function(data){
			$("#update_re_id_input").val(data.map.re.reId)
			$("#update_re_name_input").val(data.map.re.reMsg)
			$("#update_re_date_input").val(data.map.re.reDate)
		}
	});
})

//删除单个数据
	$(document).on("click",".del_re_btn",function(){
		//获取商品id
		var reId = $(this).parents("tr").find("td:eq(1)").text();
		delete_re(reId)
	})
	//删除单个商品
	function delete_re(reId){
		//弹出是否确认删除对话框
		if(confirm("确认删除【id为："+reId+"的需求吗】吗")){
		$.ajax({
			url:"/ReleaseAndBuy/deleteRe/"+reId,
			type:"delete",
			success:function(data){
				alert(data.msg)
				getRePage(1)
			}
		})
		}
	}

function control_all(){
	$(".update_re_checkAll").click(function(){
		var checkAll = $(this).prop("checked")
		$(".re_checkitem").prop("checked",checkAll)
		})
		
	//选中所有单选框控制单选框
	$(document).on("click",".re_checkitem",function(){
		var flag = $(".re_checkitem:checked").length==$(".re_checkitem").length
		$(".update_re_checkAll").prop("checked",flag)
	})
	}
	
	//批量删除
function removeMany(){
		var reId=""
		$("#delete_patch_re").click(function(){
			//清空
			if($(".update_re_checkAll").prop("checked")==true){
				remove_all()
			}else{
				if($(".re_checkitem:checked").length==0){
					confirm("请勾选上要删除的需求哦~")
					return;
				}
				var items = $(".re_checkitem:checked")
				$.each(items,function(){
					reId+=$(this).parents("tr").find("td:eq(1)").text()+"-"
				})
				delete_re(reId)
			}
		})
	}

//清空所有发布的商品
function remove_all(){
	$("#clear_re").click(function(){
		//清空
		clearPublishedRe()
	})
}

function clearPublishedRe(){
	if(confirm("确定清空您之前发布的需求吗？")){
		$.ajax({
			url:"/ReleaseAndBuy/clearPublishedRe",
			type:"delete",
			success:function(data){
				alert(data.msg)
				getRePage(1)
			}
		})
	}
}

