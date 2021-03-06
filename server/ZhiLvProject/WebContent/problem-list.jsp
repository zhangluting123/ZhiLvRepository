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
   
</head>

<body>

	<!--header-->
	<%@ include file = "/lefter.jsp"%>
    <div class="product-status mg-b-30" style="margin-top:80px">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="product-status-wrap">
                        <h4>问题反馈管理</h4>
 
                        <table>
                            <tr>
                                <th>序号</th>
                                <th>内容</th>
                                <th>用户名</th>
                                <th>时间</th>
                            </tr>
                            <c:forEach items="${problemPage.list}" var="pro" varStatus="st">
								<tr>
								<td>${st.count+(problemPage.currentPageNum-1)*3 }</td>	
								<td>${pro.content }</td>
								<td>${pro.user.userName }</td>
								<td><fmt:formatDate type="both" value="${pro.time}"/></td>
								</tr>
							</c:forEach>
                        </table>
                        <div class="custom-pagination">
							<ul class="pagination">
								<li class="page-item"><p style="color:white">共 &nbsp;${problemPage.totalCount }&nbsp;条数据 &nbsp;&nbsp;共 &nbsp;${problemPage.totalPageNum }&nbsp;页  &nbsp; &nbsp; &nbsp;</p></li>
								<li class="page-item"><a class="page-link" href="${ctx }/problem/list/1/">首页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/problem/list/${problemPage.prePageNum }">上一页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/problem/list/${problemPage.nextPageNum }">下一页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/problem/list/${problemPage.totalPageNum }">末页</a></li>
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