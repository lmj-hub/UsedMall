<!--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>-->
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>立即下单</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/node_modules/bootstrap/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <style>
        #stepflex {
            display: inline-block;
            display: block;
            border-top: 5px solid #ccc;
            text-align: center;
            margin: 30px 0 0;
            float: right;
            position: relative;
            top: -30px;
            right: 50px;
        }
        #stepflex dl.done {
            border-top-color: #caecb6;
        }
        #stepflex dl {
            float: left;
            position: relative;
            width: 160px;
            top: -5px;
            border-top: 5px solid #ccc;
            border-top-color: rgb(204, 204, 204);
        }
        #stepflex dl.done .s-num {
            background-position: -46px 0;
        }
        #stepflex .s-num {
            position: relative;
            margin: -15px auto 0;
            color: #fff;
            font-weight: 700;
            width: 23px;
            height: 23px;
            background-image: url(//misc.360buyimg.com/user/purchase/2.0.0/css/i/step2013.png);
            line-height: 23px;
        }
        #stepflex dl.done .s-text {
            color: #caecb6;
        }
        #stepflex dl.doing {
            border-top-color: #7abd54;
        }
        #stepflex dl {
            float: left;
            position: relative;
            width: 160px;
            top: -5px;
            border-top: 5px solid #ccc;
            border-top-color: rgb(204, 204, 204);
        }
        #stepflex dl.doing .s-num {
            background-position: -23px 0;
        }
        #stepflex dl.doing .s-text {
            color: #7abd54;
        }
    </style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include><br/>
<div class="container">
    <div class="row">
        <div class="col-md-3 col-md-offset-0"><span style="font-size: 20px"><b>填写并核对订单信息</b></span></div>
        <div class="col-md" id="stepflex">
            <dl class="first done">
                <dt class="s-num">1</dt>
                <dd class="s-text">1.我的购物车<s></s><b></b></dd>
            </dl>
            <dl class="normal doing">
                <dt class="s-num">2</dt>
                <dd class="s-text">2.填写核对订单信息<s></s><b></b></dd>
            </dl>
            <dl class="normal last">
                <dt class="s-num">3</dt>
                <dd class="s-text">3.成功提交订单<s></s><b></b></dd>
            </dl>
        </div>
    </div>
    <div class="panel panel-default"style="border-color: #99a9bf;position: relative;top:-40px">
        <form action="create" class="form-horizontal" role="form" id="form" method="post"><br>
            <div class="form-group"style="position: relative; left: 23px">
                <span style="font-size: 18px"><b>收货人信息</b></span><br><br>
                <table class="table table-striped table-hover"style="width: 1120px">
                    <tr>
                        <td style="width: 200px">收货人姓名</td>
                        <td style="width: 400px">收货地址</td>
                        <td style="width: 300px">联系方式</td>
                        <td style="width: 180px"></td>
                    </tr>
                    <tr>
                        <td><input name="receiverName" type="text" onfocus=this.blur() value='<%=session.getAttribute("receiverName")%>' /></td>
                        <td><input name="address" type="text" onfocus=this.blur() value='<%=session.getAttribute("address")%>' style="width: 350px" /></td>
                        <td><input name="phone" type="text" onfocus=this.blur() value='<%=session.getAttribute("phone")%>' /></td>
                        <td>
                            <button type="button" class="btn btn-default btn-sm" style="width: 150px" data-toggle="modal" data-target="#myModal">
                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 修改收货人信息
                            </button>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="form-group"style="position: relative; left: 23px">
                <span style="font-size: 18px"><b>商品列表</b></span><br><br>
                <table class="table table-striped table-hover"style="width: 1120px">
                    <tr>
                        <td style="width: 200px">商品id</td>
                        <td style="width: 250px">商品样图</td>
                        <td style="width: 300px">商品描述</td>
                        <td style="width: 200px">单价</td>
                        <td style="width: 200px">数量</td>
                    </tr>
                    <tr>

                        <td style="vertical-align: middle"><input name="goodsId" type="text" onfocus=this.blur() value='<%=session.getAttribute("goodsId")%>'/></td>
                        <td><img src="${pageContext.request.contextPath}/<%=session.getAttribute("photoUrl")%>" width="200px"></td>
                        <td style="vertical-align: middle"><input name="description" type="text" onfocus=this.blur() value='<%=session.getAttribute("description")%>' /></td>
                        <td style="vertical-align: middle"><input name="price" type="text" onfocus=this.blur() value='<%=session.getAttribute("price")%>' /></td>
                        <td style="vertical-align: middle"><input name="num" type="text" onfocus=this.blur() value='<%=session.getAttribute("goodsNum")%>'/></td>
                    </tr>
                </table>
                <div class="form-group" style="position: relative;right: 100px" align="right">
                    <h4 style="color: red">需付款：<%=session.getAttribute("paidAccount")%>元</h4><br>
                    <button type="submit" class="glyphicon glyphicon-shopping-cart btn btn-primary" style="width: 100px">确认下单</button>
                </div>
            </div>
        </form>
    </div>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel" align="center"><b>修改收货人信息</b></h4>
                </div>
                <div class="modal-body"align="center">
                    <table>
                        <tr>
                            <td align="right">收货人姓名：</td>
                            <td><input type="text" id="newBuyerName"></td>
                        </tr>
                        <tr>
                            <td align="right">收货地址：</td>
                            <td><input type="text" id="newAddress"></td>
                        </tr>
                        <tr>
                            <td align="right">联系电话：</td>
                            <td><input type="text" id="newPhone"></td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="changeBuyerInfo()">确认更改</button>
                </div>
            </div>
        </div>
    </div>
</div>



<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
<script type="text/javascript">
    changeBuyerInfo= function(){
        if (document.getElementById("newBuyerName").value!=""&&document.getElementById("newAddress").value!=""&&document.getElementById("newPhone").value!=""){
            document.getElementsByName("receiverName").item(0).value=document.getElementById("newBuyerName").value;
            document.getElementsByName("address").item(0).value=document.getElementById("newAddress").value;
            document.getElementsByName("phone").item(0).value=document.getElementById("newPhone").value;
        }else {
            alert("收货人信息不能为空");
        }
    }

</script>
</body>
</html>
