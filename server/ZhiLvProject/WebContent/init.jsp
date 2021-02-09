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
	<a href="${ctx }/audit/scene/list/1">景点管理界面</a>
	<br>
	<a href="${ctx }/audit/user/list/1">用户管理界面</a>
	<br>
	<a href="${ctx }/problem/list/1">问题反馈界面</a>
	<br>
	<a href="${ctx }/notification/userlist">通知界面</a>
	<br>
	<a href="${ctx}/audit/topic/list/1">AuditTopic列表</a>
	<br>
	<a href="${ctx}/audit/travels/list/1">AuditTravels列表</a>
	<br>
	<a href="${ctx}/audit/video/list/1">AuditVideo列表</a>
	<br>
	<br>
	<a href="${ctx }/note/locationlist?location=石家庄">同城note</a>
	<a href="${ctx }/note/followlist?userId=5">关注的note</a>
	<a href="${ctx }/note/destinationlist?destination=北京">目的地note</a>
	<a href="${ctx }/note/userlist?userId=5">用户的note</a>
	<a href="${ctx }/note/topiclist?topicId=2">话题的note</a>
	<a href="${ctx }/notification/list?userId=6">用户通知</a>
	
	<!--  
	<a href="${ctx}/audit/topic/add?title=重庆之行&userId=4">重庆之行</a>
	-->
	
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
	
	<!-- 
	<a href="${ctx }/good/add?userId=4&travelsId=9">添加travels点赞</a>
	<a href="${ctx }/good/add?userId=4&videoId=10">添加video点赞</a>
	<a href="${ctx }/good/ifGood?userId=4&videoId=10">是否点赞</a>
	<a href="${ctx }/good/delete?userId=4&travelsId=9">删除travels点赞</a>
	<a href="${ctx }/note/goodlist?userId=4">查询点赞列表</a>
	
	<br>
	<a href="${ctx }/collection/add?userId=4&videoId=10">添加video收藏</a>
	<a href="${ctx }/collection/add?userId=4&travelsId=9">添加travels收藏</a>
	<a href="${ctx }/collection/ifCollect?userId=4&videoId=10">是否收藏</a>
	<a href="${ctx }/collection/delete?userId=4&travelsId=9">删除travels收藏</a>
	<a href="${ctx }/note/collectionlist?userId=4">查询收藏列表</a>
	-->
	
</body>
</html>