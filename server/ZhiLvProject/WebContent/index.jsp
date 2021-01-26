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
<fieldset>
<h4>话题后台</h4>
	<div class="audit_topic">
		<table border="1" cellpadding="10">
			<tr>
			<td>change_status</td>
			<td>audit_id</td>
			<td>topic_id</td>
			<td>topic_title</td>
			<td>user_id</td>
			<td>status</td>
			<td>time</td>
			</tr>
			<c:forEach items="${topicPage.list}" var="topic">
				<tr>
				<td>
					<a href="${ctx}/audit/topic/update?auditId=${topic.auditId }&status=1">通过</a><br>
					<a href="${ctx}/audit/topic/update?auditId=${topic.auditId }&status=2">不通过</a>
				</td>
				<td>${topic.auditId}</td>
				<td>${topic.topicId }</td>
				<td>${topic.title }</td>
				<td>${topic.userId}</td>
				<td>${topic.status }</td>
				<td><fmt:formatDate type="both" value="${topic.time}"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="custom-page"  style="text-align:center;float:right;">
		<div>共 &nbsp;${topicPage.totalCount }&nbsp;条数据 &nbsp;&nbsp;共 &nbsp;${topicPage.totalPageNum }&nbsp;页  &nbsp; &nbsp; &nbsp;</div>
		<div>
			<a href="${ctx }/audit/topic/list/1/">首页</a> 
			<a href="${ctx }/audit/topic/list/${topicPage.prePageNum }" >上一页</a> 
			<a href="${ctx }/audit/topic/list/${topicPage.nextPageNum }" >下一页</a> 
			<a href="${ctx }/audit/topic/list/${topicPage.totalPageNum }">末页</a> 
		</div>
	</div>

	<br>
	<a href="${ctx}/topic/list">topic公开列表</a>
	<a href="${ctx}/topic/like?str=重庆">字符串查询</a>
</fieldset>
	<!-- ======================================================= -->
<fieldset>
<h4>游记后台</h4>
	<div class="audit_travels">
		<table border="1" cellpadding="10">
			<tr>
			<td>change_status</td>
			<td>audit_id</td>
			<td>travels_img_list</td>
			<td>a_travels_id</td>
			<td style="color:green;">topic_title</td>
			<td>a_travels_title</td>
			<td>a_travels_route</td>
			<td>a_travels_scene</td>
			<td>a_travels_ticket</td>
			<td>a_travels_hotel</td>
			<td>a_travels_tips</td>
			<td>a_travels_location</td>
			<td>a_upload_time</td>
			<td style="color:purple;">a_more_id</td>
			<td style="color:purple;">a_more_destination</td>
			<td style="color:purple;">a_more_traffic</td>
			<td style="color:purple;">a_more_date</td>
			<td style="color:purple;">a_days</td>
			<td style="color:purple;">a_more_people</td>
			<td style="color:purple;">a_more_money</td>
			<td>a_user_id</td>
			<td>status</td>
			<td>time</td>
			</tr>
			<c:forEach items="${travelsPage.list}" var="ats">
				<tr>
				<td>
					<a href="${ctx}/audit/travels/update?auditId=${ats.auditId }&status=1">通过</a><br>
					<a href="${ctx}/audit/travels/update?auditId=${ats.auditId }&status=2">不通过</a>
				</td>
				
				<td>${ats.auditId}</td>
				<td>
					<c:forEach items="${ats.imgList}" var="imgs">
						<a href="${ctx}/${imgs.path}" target="_blank">图片链接${imgs.imgId }</a><br>
					</c:forEach>
				</td>
				<td>${ats.travelsId }</td>
				<td style="color:green;"># ${ats.topic.title } #</td>
				<td>${ats.title }</td>
				<td>${ats.route }</td>
				<td>${ats.scene }</td>
				<td>${ats.ticket}</td>
				<td>${ats.hotel }</td>
				<td>${ats.tips }</td>
				<td>${ats.location }</td>
				<td><fmt:formatDate type="both" value="${ats.uploadTime}"/></td>
				<td style="color:purple;">${ats.detail.moreId}</td>
				<td style="color:purple;">${ats.detail.destination}</td>
				<td style="color:purple;">${ats.detail.traffic}</td>
				<td style="color:purple;"><fmt:formatDate type="date" value="${ats.detail.beginDate}"/></td>
				<td style="color:purple;">${ats.detail.days}</td>
				<td style="color:purple;">${ats.detail.people}</td>
				<td style="color:purple;">${ats.detail.money}</td>
				<td>${ats.userId} </td>
				<td>${ats.status }</td>
				<td><fmt:formatDate type="both" value="${ats.lastTime}"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="custom-page"  style="text-align:center;float:right;">
		<div>共 &nbsp;${travelsPage.totalCount }&nbsp;条数据 &nbsp;&nbsp;共 &nbsp;${travelsPage.totalPageNum }&nbsp;页  &nbsp; &nbsp; &nbsp;</div>
		<div>
			<a href="${ctx }/audit/topic/list/1/">首页</a> 
			<a href="${ctx }/audit/topic/list/${travelsPage.prePageNum }" >上一页</a> 
			<a href="${ctx }/audit/topic/list/${travelsPage.nextPageNum }" >下一页</a> 
			<a href="${ctx }/audit/topic/list/${travelsPage.totalPageNum }">末页</a> 
		</div>
	</div>
	<br>
</fieldset>

	<!-- ======================================================= -->
<fieldset>
<h4>视频后台</h4>
	<div class="audit_video">
		<table border="1" cellpadding="10">
			<tr>
			<td>change_status</td>
			<td>audit_id</td>
			<td>a_video_id</td>
			<td>a_video_path</td>
			<td>a_video_img</td>
			<td>a_video_title</td>
			<td>a_video_content</td>
			<td style="color:green;">topic_title</td>		
			<td>a_video_location</td>
			<td>a_video_duration</td>
			<td>a_video_size</td>
			<td>a_upload_time</td>
			<td style="color:purple;">a_more_id</td>
			<td style="color:purple;">a_more_destination</td>
			<td style="color:purple;">a_more_traffic</td>
			<td style="color:purple;">a_more_date</td>
			<td style="color:purple;">a_days</td>
			<td style="color:purple;">a_more_people</td>
			<td style="color:purple;">a_more_money</td>
			<td>a_user_id</td>
			<td>status</td>
			<td>time</td>
			</tr>
			<c:forEach items="${videoPage.list}" var="video">
				<tr>
				<td>
					<a href="${ctx}/audit/video/update?auditId=${video.auditId }&status=1">通过</a><br>
					<a href="${ctx}/audit/video/update?auditId=${video.auditId }&status=2">不通过</a>
				</td>				
				<td>${video.auditId}</td>
				<td>${video.videoId }</td>
				<td><a href="${ctx}/${video.path }" target="_blank">视频链接</a><br></td>
				<td><a href="${ctx}/${video.img }" target="_blank">缩略图链接</a><br></td>
				<td>${video.title }</td>
				<td>${video.content }</td>
				<td style="color:green;"># ${video.topic.title } #</td>
				<td>${video.location }</td>
				<td>${video.duration }</td>
				<td>${video.size }</td>
				<td><fmt:formatDate type="both" value="${video.uploadTime}"/></td>
				<td style="color:purple;">${video.detail.moreId}</td>
				<td style="color:purple;">${video.detail.destination}</td>
				<td style="color:purple;">${video.detail.traffic}</td>
				<td style="color:purple;"><fmt:formatDate type="date" value="${video.detail.beginDate}"/></td>
				<td style="color:purple;">${video.detail.days}</td>
				<td style="color:purple;">${video.detail.people}</td>
				<td style="color:purple;">${video.detail.money}</td>
				<td>${video.userId} </td>
				<td>${video.status }</td>
				<td><fmt:formatDate type="both" value="${video.lastTime}"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="custom-page"  style="text-align:center;float:right;">
		<div>共 &nbsp;${videoPage.totalCount }&nbsp;条数据 &nbsp;&nbsp;共 &nbsp;${videoPage.totalPageNum }&nbsp;页  &nbsp; &nbsp; &nbsp;</div>
		<div>
			<a href="${ctx }/audit/video/list/1/">首页</a> 
			<a href="${ctx }/audit/video/list/${videoPage.prePageNum }" >上一页</a> 
			<a href="${ctx }/audit/video/list/${videoPage.nextPageNum }" >下一页</a> 
			<a href="${ctx }/audit/video/list/${videoPage.totalPageNum }">末页</a> 
		</div>
	</div>
	<br>
	
	<a href="${ctx}/note/list">Note列表</a>
</fieldset>
</body>
</html>