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
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  	<script type="text/javascript">
    	function across(id){
    		$.post("${ctx}/audit/video/update",{"auditId":id,"status":1},function(data){
    			if(data == "OK"){
    				$('#btn-status'+id).attr('class','pd-setting')
    				$('#btn-status'+id).html('已通过')
    			}
    		});
    	}
    	function refuse(id){
    		$.post("${ctx}/audit/video/update",{"auditId":id,"status":2},function(data){
    			if(data == "OK"){
    				$('#btn-status'+id).attr('class','ds-setting')
    				$('#btn-status'+id).html('不通过')
    			}
    		});
    	}
    </script>
</head>

<body>

	<!--header-->	
	<%@ include file = "/lefter.jsp"%>
    <div class="product-status mg-b-30" style="margin-top:30px">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="product-status-wrap">
                        <h4>视频管理</h4>
 
                        <table>
                            <tr>
                            	<th>序号</th>
                                <th>链接</th>
                                <th>标题</th>
                                <th>状态</th>
                                <th>话题</th>
                                <th>内容</th>
                                <th>目的地</th>
                                <th>交通</th>
                                <th>日期</th>
                                <th>天数</th>
                                <th>任务</th>
                                <th>花费</th>
                                <th>更新时间</th>
                                <th>设置</th>
                            </tr>
                            <c:forEach items="${videoPage.list}" var="video" varStatus="st">
                            <tr>
                            	<td>${st.count+(videoPage.currentPageNum-1)*3 }</td>
                            	<td><a href="${ctx}/${video.path }" target="_blank">视频链接</a><br></td>
                                <td>${video.title }</td>
                                <td>
                                <c:if test="${video.status == 0}">
                               		<button class="ps-setting" id="btn-status${video.auditId }">未审核</button>
                                </c:if>
                                <c:if test="${video.status == 1}">
                                	<button class="pd-setting" id="btn-status${video.auditId }">已通过</button>
                                </c:if>
                                <c:if test="${video.status == 2}">
                                	<button class="ds-setting" id="btn-status${video.auditId }">不通过</button>
                                </c:if>
                                	
                                </td>
                                <td style="color:green;"># ${video.topic.title } #</td>
                                <td>${video.content  }</td>
                                <td>${video.detail.destination }</td>
                                <td>${video.detail.traffic}</td>
                                <td><fmt:formatDate type="date" value="${video.detail.beginDate}"/></td>
                                <td>${video.detail.days}</td>
                                <td>${video.detail.people}</td>
                                <td>${video.detail.money}</td>
                                <td><fmt:formatDate type="both" value="${video.lastTime }"/></td>
                                <td>
                                    <div >
                                    <button class="pd-setting" onclick="across(${video.auditId})">通过</button>
                                    <button class="ds-setting" onclick="refuse(${video.auditId })">拒绝</button>
                                    </div>
                                </td>
                            </tr>
                            </c:forEach>
                        </table>
                        <div class="custom-pagination">
							<ul class="pagination">
								<li class="page-item"><p style="color:white">共 &nbsp;${videoPage.totalCount }&nbsp;条数据 &nbsp;&nbsp;共 &nbsp;${videoPage.totalPageNum }&nbsp;页  &nbsp; &nbsp; &nbsp;</p></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/video/list/1/">首页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/video/list/${videoPage.prePageNum }">上一页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/video/list/${videoPage.nextPageNum }">下一页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/video/list/${videoPage.totalPageNum }">末页</a></li>
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