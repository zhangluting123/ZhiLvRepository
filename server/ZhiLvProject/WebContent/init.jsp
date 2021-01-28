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
<!--  
	<a href="${ctx}/audit/topic/add?title=重庆之行&userId=4">重庆之行</a>
	<a href="${ctx}/audit/topic/add?title=拉萨之行&userId=4">拉萨之行</a>
	<a href="${ctx}/audit/topic/add?title=成都之行&userId=4">成都之行</a>
	<a href="${ctx}/audit/topic/add?title=西藏之行&userId=4">西藏之行</a>
-->
	<a href="${ctx}/audit/topic/list/1">AuditTopic列表</a>
	<br>
	<a href="${ctx}/audit/travels/list/1">AuditTravels列表</a>
	<br>
	<a href="${ctx}/audit/video/list/1">AuditVideo列表</a>
	
	<br>
<!-- 
	<a href="${ctx }/comment/add?videoId=12&userId=4&commentContent=video12的评论">video12的评论</a>
	<a href="${ctx }/comment/add?travelsId=10&userId=4&commentContent=travels10的评论">travels10的评论</a>
	<br>
	<a href="${ctx }/reply/add?replyUserId=6&commentId=6&replyContent=回复6的评论">comment6的回复video</a>
	<a href="${ctx }/reply/add?replyUserId=6&commentId=7&replyContent=回复7的评论">comment7的回复travels</a>
	<br>
	<a href="${ctx }/reply/addReplyToReply?replyUserId=5&commentId=6&parentId=6&replyContent=回复[回复6]的评论">replyComment6的回复</a>
	<a href="${ctx }/reply/addReplyToReply?replyUserId=6&commentId=6&parentId=6&replyContent=回复[回复6]的评论">replyComment6的回复</a>
	<a href="${ctx }/reply/addReplyToReply?replyUserId=5&commentId=6&parentId=8&replyContent=回复[回复8]的评论">replyComment8的回复</a>
	<br>
	<a href="${ctx }/mailmycomment/list?userId=4">用户4的通知</a> 2条replycomment(6,7)
	<a href="${ctx }/mailmycomment/list?userId=5">用户5的通知</a> 
	<a href="${ctx }/mailmycomment/list?userId=6">用户6的通知</a> 2条comment(6,7),3条replycomment(8,10) , replycomment9没有通知
	<br>
	<a href="${ctx }/comment/list?travelsId=10">travelsId10的评论</a>
	<a href="${ctx }/comment/list?videoId=12">videoId12的评论</a>
	<a href="${ctx }/reply/list?commentId=6">comment6的评论</a>
	<br>
	<a href="${ctx }/mailmycomment/update?myCommentId=5">更新通知状态</a>
	<a href="${ctx }/mailmycomment/delete?myCommentId=6">删除通知</a>
	-->
</body>
</html>