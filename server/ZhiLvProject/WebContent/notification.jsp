<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>列表页</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style type="text/css">
	#img{
		width:20px;
		height:20px;
		margin:0px 10px 0px 10px;
		align-self:center;
	}
	.submit-div{
		margin:10px;
		height:30px;
		display:flex;
	}
	.div-first{
		margin:20px;
	}
	button{
		margin-right:20px;
		width:200px;
	}
	span{
		color:white;
		margin-right:10px;
	}
</style>
<script src="${ctx }/js/jquery-3.4.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#btnSubmit").click(function(){
	   var options=$("#typelist").children();
        for(var i=0;i<options.length;i++){
            if(options.eq(i).val().trim()==$("#text_user").val().trim()){
                var select1 = options.eq(i).attr("data-id");
                break;
            }
        }
		var title = $('#title').val();
		var content = $('#content').val();
		$.post("${ctx }/notification/add",{"userId":select1,"title":title,"content":content},function(data,status){
			if(data == "OK"){
				$("#text_user").val('');
				$('#title').val('');
				$('#content').val('');
				$('#success_p').html('<img id="img" src=""/>发布成功');
				$('#success_p').attr('style','color:green;align-self:center');
				$('#img').attr('src','${ctx}/audit/success.png');
				$('#img').addClass('img');
			}else{
				$('#success_p').html('<img id="img" src=""/>发布失败');
				$('#success_p').attr('style','color:red;align-self:center');
				$('#img').attr('src','${ctx}/audit/fail.png');
				$('#img').addClass('img');
			}
		});
	});
	
	
});



</script>
</head>

<body>
    <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

	<!--header-->
	<%@ include file = "/lefter.jsp"%>
    <div class="product-status mg-b-30" style="margin-top:80px">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="product-status-wrap">
                        <h4>添加通知消息</h4>
 						<div class="div-first">
	 						<span>通知标题：</span>
							<input type="text" name="title" id="title"/><br>
 						</div>
 						<div  class="div-first">
							<span>通知内容：</span>
							<input type="text" name="content" id="content"/><br>
						</div>
						<div  class="div-first">
							<span>通知到人：</span>
							<input list="typelist" id="text_user" placeholder="所有人"/>
						<div>
						
						<datalist id="typelist">
							<option data-id="-1" selected="selected">所有人</option>
							<c:forEach items="${userList }" var="user">
								<option data-id="${user.userId }">${user.userId }&nbsp;&nbsp;${user.userName }</option>
							</c:forEach>
						</datalist>
						<div class="submit-div">
							<button id="btnSubmit">提交</button>
							<span id="success_p"></span>
						</div>
                   	</div>
           		 </div>
        	</div>
    	</div>
    </div>
    </div>
    </div>
	<%@ include file = "/include-js.jsp"%>
</body>

</html>