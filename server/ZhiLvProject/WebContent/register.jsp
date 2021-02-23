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
    <title>Register | ZhiLv </title>
	<script src="${ctx }/js/jquery-3.4.1.min.js"></script>
  	<script >
  	$(document).ready(function(){
  		$("#againPwd").blur(function(){
  			var pwd = $("#pwd").val();
  			var againPwd = $("#againPwd").val();
  			if(pwd == '' && againPwd == ''){
  				$("#pwdinfo").html("输入不能为空");
  				$("#pwdinfo").css("color","red");
  			}else{
  				$("#pwdinfo").html("");
  			}
  			if(pwd != againPwd){
  				$("#pwdinfo").html("两次密码不同");
  				$("#pwdinfo").css("color","red");
  			}else{
  				$("#pwdinfo").html("");
  			}
  		});
  		$("#email").blur(function(){
  			var email = $("#email").val();
  			if(email == ''){
  				$('#emailinfo').html("输入不能为空");
				$("#emailinfo").css("color","red");
  			}else{
	  			$.post("${ctx}/admin/confirmEmail",{"email":email},function(data){
	    			if(data == "ERRORSTYLE"){
	    				$('#emailinfo').html("邮箱输入格式有误");
	    				$("#emailinfo").css("color","red");
	    			}else if(data == "ERROR"){
	    				$('#emailinfo').html("邮箱已注册");
	    				$("#emailinfo").css("color","red");
	    			}else{
	    				$('#emailinfo').html("");
	    			}
	    		});
  			}
  		});
  		$("#name").blur(function(){
  			var name = $("#name").val();
  			if(name == ''){
  				$('#nameinfo').html("输入不能为空");
				$("#nameinfo").css("color","red");
  			}else{
	  			$.post("${ctx}/admin/confirmName",{"name":name},function(data){
	    			if(data == "ERROR"){
	    				$('#nameinfo').html("用户名已存在");
	    				$("#nameinfo").css("color","red");
	    			}else{
	    				$('#nameinfo').html("");
	    			}
	    		});
  			}
  		});
  		$("#btnClear").click(function(){
  			$('#emailinfo').html("");
  			$('#nameinfo').html("");
  			$("#pwdinfo").html("");
  			$("#pwd").val('');
  			$("#againPwd").val('');
  			$("#email").val('');
  			$("#name").val('');
  		})
  		$("#btnRegist").click(function(){
  			var email = $("#email").val();
  			var name = $("#name").val();
  			var pwd = $("#pwd").val();
  			var einfo = $('#emailinfo').html();
  			var ninfo = $('#nameinfo').html();
  			var pinfo = $("#pwdinfo").html();
  			if(email != '' && einfo == '' && ninfo == '' && pinfo == ''){
	  			$.post("${ctx}/admin/regist",{"email":email,"name":name,"password":pwd},function(data){
	    			if(data == "OK"){
	    				alert('注册成功')
	    	  	        window.location.href="${ctx}/login.jsp";
	    			}else{
	    				alert('注册失败')
	    			}
	    		});
  			}
  		})
  		
  	});

  	</script>
</head>

<body>

    <div class="color-line" ></div>
    <div class="container-fluid" style="margin-bottom:100px;">
        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="back-link back-backend">
                    <a href="${ctx }/login.jsp" class="btn btn-primary">登录</a>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12"></div>
            <div class="col-md-6 col-md-6 col-sm-6 col-xs-12">
                <div class="text-center custom-login">
                    <h3>Registration</h3>
                    <p>ZhiLv Background Admin Registration</p>
                </div>
                <div class="hpanel">
                    <div class="panel-body">
                        <form action="#" id="loginForm">
                            <div class="row">
                                <div class="form-group col-lg-12">
                                    <label>用户名</label>
                                    <input class="form-control" id="name" >
                                    <span class="help-block small" id="nameinfo"></span>
                                </div>
                                <div class="form-group col-lg-12">
                                    <label>邮箱</label>
                                    <input class="form-control" id="email">
                                    <span class="help-block small" id="emailinfo"></span>
                                </div>
                     
                                <div class="form-group col-lg-6">
                                    <label>密码(6位密码)</label>
                                    <input type="password" class="form-control" id="pwd">
                                    <span class="help-block small" id="pwdinfo"></span>
                                </div>
                                <div class="form-group col-lg-6">
                                    <label>再次输入密码</label>
                                    <input type="password" class="form-control" id="againPwd" ">
                                </div>
                                
                       
                            </div>
                            <div class="text-center">
                                <button class="btn btn-success loginbtn" id="btnRegist">注册</button>
                                <button class="btn btn-default" id="btnClear">取消</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12"></div>
        </div>
      </div>

	<%@ include file = "/include-js.jsp"%>
</body>

</html>