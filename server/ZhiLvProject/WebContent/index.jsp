<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Insert title here</title>
</head>
<body>
<!--  
	<a href="/ZhiLvProject/notification/find?userId=1">通知消息userId=1</a>
	<a href="http://localhost:8080/ZhiLvProject/notification/find?userId=1">通知消息userId=1</a>
	<a href="http://localhost:8080/ZhiLvProject/notification/find?userId=2">通知消息userId=2</a>
-->
	<div class="topic">
		<table border="1" cellpadding="10">
			<tr>
			<td>audit_id</td>
			<td>topic_id</td>
			<td>topic_title</td>
			<td>user_id</td>
			<td>status</td>
			<td>time</td>
			</tr>
			<c:forEach items="${page.list}" var="topic">
				<tr>
				<td>${topic.auditId}</td>
				<td>${topic.topicId }</td>
				<td>${topic.title }</td>
				<td>${topic.userId}</td>
				<td>${topic.status }</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${topic.time}"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="custom-page"  style="text-align:center;float:right;">
		<div>共 &nbsp;${page.totalCount }&nbsp;条数据 &nbsp;&nbsp;共 &nbsp;${page.totalPageNum }&nbsp;页  &nbsp; &nbsp; &nbsp;</div>
		<div><a href="${ctx }/audit/topic/list/1/">首页</a> </div>
		<div><a href="${ctx }/audit/topic/list/${page.prePageNum }" >上一页</a> </div>
		<div><a href="${ctx }/audit/topic/list/${page.nextPageNum }" >下一页</a> </div>
		<div><a href="${ctx }/audit/topic/list/${page.totalPageNum }">末页</a> </div>
	</div>
	

	<br>
	<a href="${ctx}/audit/topic/update?auditId=1&status=1">重庆通过</a>
	<a href="${ctx}/audit/topic/update?auditId=2&status=2">拉萨不通过</a>
	<br>
	<a href="${ctx}/topic/list">topic公开列表</a>
	<a href="${ctx}/topic/like?str=重庆">字符串查询</a>
</body>
</html>