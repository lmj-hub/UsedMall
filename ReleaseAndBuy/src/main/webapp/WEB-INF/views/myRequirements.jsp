<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>需求管理页面</title>
<%
pageContext.setAttribute("PATH",request.getContextPath());
%>
<script type="text/javascript" src="${PATH}/static/myjs03.js"></script>
</head>
<body>

<!--修改商品信息的模态框-->
	<div class="modal" tabindex="-1" id="re_update_modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">我的需求</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="update_save_re_form">
						<div class="form-group row" id="re_update_id_div">
							<label class="col-sm-2">需求id</label>
							<div class="col-sm-10">
								<input type="text" class="form-control form-control-sm"
									id="update_re_id_input" placeholder="re_id" name="reId" readOnly 
									valid="true">
							</div>
						</div>
						<div class="form-group row" id="re_update_div">
							<label class="col-sm-2">需求内容</label>
							<div class="col-sm-10">
								<textarea class="form-control form-control-sm"
									id="update_re_name_input" placeholder="re_Msg" name="reMsg"
									valid="true" cols="5" rows="5">
									</textarea>
							<span></span>
							</div>
						</div>
						<div class="form-group row" id="re_update_date_div">
							<label class="col-sm-2">上传日期</label>
							<div class="col-sm-10">
								<input type="text" class="form-control form-control-sm"
									id="update_re_date_input" placeholder="re_cdate" valid="true" name="reDate" 
									readOnly>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="update_re_save">保存</button>
				</div>
			</div>
		</div>
	</div>
<div class="container">

	<!-- 显示按钮 -->
	<div class="row">
	
		<div class="col-md-4 offset-md-9">
			<button class="btn btn-danger" id="clear_re">清空</button>
			<button class="btn btn-danger" id="delete_patch_re">删除</button>
		</div>
	</div><br>
	<!-- 显示表格数据 -->
	<div class="row">
		<div class="col-md-12">
			<table class="table table-hover" id="re_table">
			<thead>
				<tr>
					<th><input type="checkbox" class="update_re_checkAll"/></th>
					<th>id</th>
					<th>内容</th>
					<th>日期</th>
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
			<div class="col-md-6" id="re_page_info_area">
			</div>
		</div>
		<!-- 分页条信息 -->
		<div class="col-md-6" id="re_page_info_nav">
		</div>
		
	</div>
</div>
</body>
</html>