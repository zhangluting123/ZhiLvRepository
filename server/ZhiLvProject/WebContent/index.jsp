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
<script type="text/javascript" src="${ctx }/js/jquery-3.4.1.min.js"></script>
<style type="text/css">
	.img{
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
	button{
		margin-right:20px;
		width:200px;
	}
</style>
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
				$('#success_p').html('发布成功');
				$('#success_p').attr('style','color:green;align-self:center');
				$('#img').attr('src','${ctx}/audit/success.png');
				$('#img').addClass('img');
			}else{
				$('#success_p').html('发布失败');
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
<fieldset>
<h4>用户管理后台</h4>
	<div class="audit_user">
		<table border="1" cellpadding="10">
			<tr>
			<td>user_id</td>
			<td>user_head</td>
			<td>user_name</td>
			<td>user_sex</td>
			<td>user_birth</td>
			<td>user_signature</td>
			<td>operation</td>
			</tr>
			<c:forEach items="${userPage.list}" var="user">
				<tr>
				<td>${user.userId}</td>
				<td><img src="${ctx}/${user.userHead }" class="img"/></td>
				<td>${user.userName }</td>
				<td>${user.sex }</td>
				<td><fmt:formatDate type="date" value="${user.birth }"/></td>
				<td>${user.signature }</td>
				<td><a href="${ctx }/audit/user/delete?userId=${user.userId}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="custom-page"  style="text-align:center;float:right;">
		<div>共 &nbsp;${userPage.totalCount }&nbsp;条数据 &nbsp;&nbsp;共 &nbsp;${userPage.totalPageNum }&nbsp;页  &nbsp; &nbsp; &nbsp;</div>
		<div>
			<a href="${ctx }/audit/user/list/1/">首页</a> 
			<a href="${ctx }/audit/user/list/${userPage.prePageNum }" >上一页</a> 
			<a href="${ctx }/audit/user/list/${userPage.nextPageNum }" >下一页</a> 
			<a href="${ctx }/audit/user/list/${userPage.totalPageNum }">末页</a> 
		</div>
	</div>

	<br>
</fieldset>
	<!-- ======================================================= -->
<fieldset>
<h4>问题反馈后台</h4>
	<div class="problem">
		<table border="1" cellpadding="10">
			<tr>
			<td>problem_id</td>
			<td>content</td>
			<td>userName</td>
			<td>time</td>
			</tr>
			<c:forEach items="${problemPage.list}" var="pro">
				<tr>
				<td>${pro.id}</td>
				<td>${pro.content }</td>
				<td>${pro.user.userName }</td>
				<td><fmt:formatDate type="both" value="${pro.time}"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="custom-page"  style="text-align:center;float:right;">
		<div>共 &nbsp;${problemPage.totalCount }&nbsp;条数据 &nbsp;&nbsp;共 &nbsp;${problemPage.totalPageNum }&nbsp;页  &nbsp; &nbsp; &nbsp;</div>
		<div>
			<a href="${ctx }/problem/list/1/">首页</a> 
			<a href="${ctx }/problem/list/${problemPage.prePageNum }" >上一页</a> 
			<a href="${ctx }/problem/list/${problemPage.nextPageNum }" >下一页</a> 
			<a href="${ctx }/problem/list/${problemPage.totalPageNum }">末页</a> 
		</div>
	</div>

	<br>
</fieldset>
	<!-- ======================================================= -->
<fieldset>
	<h4>通知消息:</h4>
	通知标题：
	<input type="text" name="title" id="title"/><br>
	通知内容：
	<input type="text" name="content" id="content"/><br>
	通知到人：
	<input list="typelist" id="text_user" placeholder="所有人"/>
	
	<datalist id="typelist">
		<option data-id="-1" selected="selected">所有人</option>
		<c:forEach items="${userList }" var="user">
			<option data-id="${user.userId }">${user.userId }&nbsp;&nbsp;${user.userName }</option>
		</c:forEach>
	</datalist>
	<div class="submit-div">
		<button id="btnSubmit">提交</button>
		<img id="img" src=""/><span id="success_p"></span>
	</div>
</fieldset>
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