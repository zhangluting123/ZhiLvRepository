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
    <script type="text/javascript">
    	function deleteUser(id){
    		$.post("${ctx }/audit/user/delete",{"userId":id},function(data){
    			if(data == "OK"){
    				$('#table-tr'+id).remove();
    			}
    		});
    	}
    </script>
</head>

<body>
	<!--header-->
	<%@ include file = "/lefter.jsp"%>
<!-- Mobile Menu end -->
     <div class="breadcome-area">
         <div class="container-fluid">
             <div class="row">
                 <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="breadcome-list">
                         <div class="row">
                             <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                 <div class="breadcomb-wp">
									<div class="breadcomb-icon">
										<i class="icon nalika-home"></i>
									</div>
								 <div class="col-lg-6 col-md-7 col-sm-6 col-xs-12">
                                   	<div class="header-top-menu tabl-d-n">
                                       	<div class="breadcome-heading">
											<form role="search" action="${ctx }/audit/user/list/1" method="get">
												<input type="text" placeholder="Search..." class="form-control" name="userName" >
												<a href=""><i class="fa fa-search"></i></a>
											</form>
										</div>
                                   </div>
                               </div>
							</div>
                     	</div>
                        <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                            <div class="breadcomb-report">
								<button data-toggle="tooltip" data-placement="left" title="Download Report" class="btn"><i class="icon nalika-download"></i></button>
							</div>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>	
    <div class="product-status mg-b-30">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="product-status-wrap">
                        <h4>用户管理</h4>
 
                        <table>
                            <tr>
                            	<th>序号</th>
                                <th>头像</th>
                                <th>昵称</th>
                                <th>手机号</th>
                                <th>邮箱</th>
                                <th>性别</th>
                                <th>生日</th>
                                <th>个签</th>                              
                                <th>操作</th>
                            </tr>
                            <c:forEach items="${userPage.list}" var="user" varStatus="st">
                            <tr id="table-tr${user.userId }">
                            	<td>${st.count+(userPage.currentPageNum-1)*3 }</td>
                                <td><img src="${ctx}/${user.userHead }" class="img"/></td>
                                <td>${user.userName }</td>
                                <td>${user.phone }</td>
                                <td>${user.email }</td>
								<td>${user.sex }</td>
								<td><fmt:formatDate type="date" value="${user.birth }"/></td>
								<td>${user.signature }</td>
								<td>
								<button class="ds-setting"  onclick="deleteUser(${user.userId })">删除</button>
								</td>
                            </tr>
                            </c:forEach>
                        </table>
                        <div class="custom-pagination">
							<ul class="pagination">
								<li class="page-item"><p style="color:white">共 &nbsp;${userPage.totalCount }&nbsp;条数据 &nbsp;&nbsp;共 &nbsp;${userPage.totalPageNum }&nbsp;页  &nbsp; &nbsp; &nbsp;</p></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/user/list/1?userName=${userName}">首页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/user/list/${userPage.prePageNum }?userName=${userName}">上一页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/user/list/${userPage.nextPageNum }?userName=${userName}">下一页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/user/list/${userPage.totalPageNum }?userName=${userName}">末页</a></li>
							</ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@ include file = "/include-js.jsp"%>
   
</body>

</html>