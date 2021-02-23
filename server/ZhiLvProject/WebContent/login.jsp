<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html class="no-js" lang="ch">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Login | ZhiLv </title>
    <script src="${ctx }/js/jquery-3.4.1.min.js"></script>
    <script>
	   	$(document).ready(function(){
	   		$("#username").blur(function(){
	   			var name = $("#username").val();
				if(name == ''){
					$('#nameinfo').html("输入不能为空");
					$("#nameinfo").css("color","red");
	  			}else{
	  				$('#nameinfo').html("");
	  			}
	   		});
	   		$("#password").blur(function(){
	   			var password = $("#password").val();
	   			if(password == ''){
	   				$("#pwdinfo").html("输入不能为空");
	  				$("#pwdinfo").css("color","red");
	   			}else{
	   				$("#pwdinfo").html("");
	   			}
	   		});
	  		$("#btnLogin").click(function(){
	  			var name = $("#username").val();
	  			var password = $("#password").val();
	  			var ninfo = $('#nameinfo').html();
	  			var pinfo = $("#pwdinfo").html();
	  			if(ninfo == '' && pinfo == ''){
		  			$.post("${ctx}/admin/login",{"name":name,"password":password},function(data){	
		    			if(data == "ERROR"){
		    				alert('用户名或密码错误！')
		    			}else{
		    				window.location.href="${ctx }/admin/list?name="+data;
		    			}
		    		});
	  			}
	  		});
	  	});
   	</script>
</head>

<body>

    <div class="color-line" style="margin-bottom:100px"></div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12"></div>
            <div class="col-md-4 col-md-4 col-sm-4 col-xs-12">
                <div class="text-center m-b-md custom-login">
                    <h3>LOGIN</h3>
                    <p>ZhiLv Background Admin Login</p>
                </div>
                <div class="hpanel">
                    <div class="panel-body">

                        <div class="form-group">
                            <label class="control-label" >用户名</label>
                            <input type="text" title="请输入用户名"  name="username" id="username" class="form-control">
                            <span class="help-block small" id="nameinfo"></span>
                        </div>
                        <div class="form-group">
                            <label class="control-label" >密码</label>
                            <input type="password" title="请输入密码"  name="password" id="password" class="form-control">
                            <span class="help-block small" id="pwdinfo"></span>
                        </div>
                        <button class="btn btn-success btn-block loginbtn" id="btnLogin">登录</button>
                        <a class="btn btn-default btn-block" href="${ctx }/register.jsp">注册</a>

                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12"></div>
        </div>
      </div>
	  <%@ include file = "/include-js.jsp"%>
</body>

</html>