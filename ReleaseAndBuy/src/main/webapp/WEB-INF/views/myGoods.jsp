<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
<%
pageContext.setAttribute("PATH",request.getContextPath());
%>
<script type="text/javascript" src="${PATH}/static/myjs02.js"></script>
</head>
<body>
<!--修改商品信息的模态框-->
	<div class="modal" tabindex="-1" id="goods_update_modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">我的发布</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="update_save_form">
						<div class="form-group row" id="goods_update_id_div">
							<label class="col-sm-2">商品id</label>
							<div class="col-sm-10">
								<input type="text" class="form-control form-control-sm"
									id="update_goods_id_input" placeholder="goods_id" name="goodsId" readOnly 
									valid="true">
							</div>
						</div>
						<div class="form-group row" id="goods_update_div">
							<label class="col-sm-2">商品名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control form-control-sm"
									id="update_goods_name_input" placeholder="goods_name" name="goodsName"
									valid="true">
							<span id="update_goods_tip"></span>
							</div>
						</div>
						<div class="form-group row" id="goods_update_price_div">
							<label class="col-sm-2">商品价格</label>
							<div class="col-sm-10">
								<input type="text" class="form-control form-control-sm"
									id="update_goods_price_input" placeholder="goods_price" valid="true" name="goodsPrice">
							<span id="update_goods_price_tip"></span>
							</div>
						</div>
						<div class="form-group row" id="goods_update_num_div">
							<label class="col-sm-2">商品数量</label>
							<div class="col-sm-10">
								<input type="text" class="form-control form-control-sm"
									id="update_goods_num_input" placeholder="goods_num" name="goodsNum"
									valid="true">
							<span id="update_goods_num_tip"></span>
							</div>
						</div>
						<div class="form-group row" id="goods_update_desp_div">
							<label class="col-sm-2">商品描述</label>
							<div class="col-sm-10">
								<input type="text" class="form-control form-control-sm"
									id="update_goods_desp_input" placeholder="goods_desp" name="goodsDesp"
									valid="true">
							<span id="update_goods_desp_tip"></span>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2" for="inlineFormCustomSelectPref"
							valid="true">商品类型</label>
							<select class="custom-select col-sm-4"
								id="update_goods_type" name="goodsType">
							</select>
						</div>
						<div class="form-group row" id="goods_update_cdate_div">
							<label class="col-sm-2">上传日期</label>
							<div class="col-sm-10">
								<input type="text" class="form-control form-control-sm"
									id="update_goods_cdate_input" placeholder="goods_cdate" valid="true" name="goodsCdate" 
									readOnly>
							</div>
						</div>
						<div class="form-group row" id="goods_update_img_div">
							<label class="col-sm-2">请上传一张图片</label>
							<div class="col-sm-10">
								<input type="file" id="update_picture_input" name="file" class="transparency"
								valid="true">
							<span id="update_goods_img_tip"></span>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="update_goods_save">保存</button>
				</div>
			</div>
		</div>
	</div>

<div class="container">

	<!-- 显示按钮 -->
	<div class="row">
	
		<div class="col-md-4 offset-md-9">
			<button class="btn btn-danger" id="clear">清空</button>
			<button class="btn btn-danger" id="delete_patch">删除</button>
		</div>
	</div><br>
	<!-- 显示表格数据 -->
	<div class="row">
		<div class="col-md-12">
			<table class="table table-hover" id="goods_table">
			<thead>
				<tr>
					<th><input type="checkbox" class="update_goods_checkAll"/></th>
					<th>id</th>
					<th>名称</th>
					<th>价格</th>
					<th>数量</th>
					<th>描述</th>
					<th>类型</th>
					<th>日期</th>
					<th>图片</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
			</table>
		</div>
	</div>
	<!-- 显示分页 -->
	<div class="row">
	<!-- 分页文字信息 -->
		<div class="col-md-6">
			<div class="col-md-6" id="page_info_area">
			</div>
		</div>
		<!-- 分页条信息 -->
		<div class="col-md-6" id="page_info_nav">
				
		</div>
		
	</div>
</div>
</body>
</html>