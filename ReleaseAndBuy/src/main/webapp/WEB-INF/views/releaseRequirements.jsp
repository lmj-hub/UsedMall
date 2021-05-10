<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Date"
    import="java.text.SimpleDateFormat"
    %>
<!DOCTYPE html>
<html>
<head>
<%
pageContext.setAttribute("PATH",request.getContextPath());
%>

<meta charset="UTF-8">
<title>我的发布</title>

</head>
<body>
<div class="container">
<div class="card">
<form id="publish_re_form" enctype="multipart/form-data">
  <div class="card-header">
  	 <label for="re_desp" class="offset-5">需求描述</label>
  </div>
  	<div class="form-group">
    <textarea rows="10" cols="5" class="form-control " id="re_desp" name="reMsg"
      placeholder="请输入您的需求详情.......(100字以内~)" valid="false"></textarea>
      <span></span>
  	</div>
  	<div class="form-group">
    <input type="hidden" name="reDate" value="<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%>"
       valid="true" id="date"></input>
  	</div>
  <button class="btn btn-secondary offset-md-10" id="reset_re_btn  " type="reset">点我重置</button>
</form><br>
  <div class="card-footer text-muted">
   <button class="btn btn-success" id="publish_re_btn">点我发布</button>
   <span  id="publish_re_date" class="offset-md-7">当前时间：<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%></span>
    </div>
  </div>
 </div>
   

</body>
</html>