<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Date"
    import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<%
pageContext.setAttribute("PATH",request.getContextPath());
%>
<meta charset="UTF-8">
<script type="text/javascript" src="${PATH}/static/myjs.js"></script>
<title>我的发布</title>

</head>
<body>
<div class="container ">
	<form id="publish_goods_form" enctype="multipart/form-data">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="goods_name">商品名称</label>
      <input type="text" class="form-control transparency" id="goods_name" name="goodsName" 
      placeholder="请输入该商品名称(必填)" valid="false">
     <span></span>
    </div>
    <div class="form-group col-md-6">
      <label for="goods_price">商品价格</label>
      <input type="text" class="form-control transparency" id="goods_price" name="goodsPrice"
      placeholder="请输入该商品价格(必填)" valid="false">
     <span></span>
    </div>
  </div>
  <div class="form-group">
    <label for="goods_num">商品数量</label>
    <input type="text" class="form-control transparency" id="goods_num" name="goodsNum"
    placeholder="请输入该商品数量(必填)" valid="false">
    <span></span>
  </div>
  <div class="form-row">
    <div class="form-group col-md-4">
      <label for="goods_type">商品类型</label>
      <select id="goods_type" class=" custom-select form-control transparency" name="goodsType"
       valid="false">
      </select>
      <span></span>
    </div>
    <div class="form-group col-md-7">
      <label for="goods_cdate">上传日期</label>
      <input type="text" class="form-control transparency" id="goods_cdate" name="goodsCdate" 
      valid="true" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>"
      readonly>
      <span id="date_warning"></span>
      
    </div>
    </div>
    <div class="form-group">
      <label for="goods_desp">商品描述</label>
      <textarea rows="5" cols="5" class="form-control transparency" id="goods_desp" name="goodsDesp"
      placeholder="请填写商品的描述(必填)" valid="false"></textarea>
      <span></span>
  </div>
 <div class="form-group">
  	<label>请上传一张商品图片</label>
    <input type="file" id="picture" name="file" valid="false" class="transparency">
    <span></span>
     <button class="btn btn-secondary offset-md-10" id="reset_goods_btn " type="reset">点我重置</button>
    </div>
</form>
  <button class="btn btn-success offset-md-10 " id="publish_goods_btn">点我发布</button>
</div>
</body>
</html>