<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="${ctx}/audit/topic/add?title=重庆之行&userId=4">重庆之行</a>
	<a href="${ctx}/audit/topic/add?title=拉萨之行&userId=4">拉萨之行</a>
	<a href="${ctx}/audit/topic/add?title=成都之行&userId=4">成都之行</a>
	<a href="${ctx}/audit/topic/add?title=西藏之行&userId=4">西藏之行</a>

	<a href="${ctx}/audit/topic/list/1">AuditTopic列表</a>
</body>
</html>