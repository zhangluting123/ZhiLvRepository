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
    	function across(id){
    		$.post("${ctx}/audit/travels/update",{"auditId":id,"status":1},function(data){
    			if(data == "OK"){
    				$('#btn-status'+id).attr('class','pd-setting')
    				$('#btn-status'+id).html('已通过')
    			}
    		});
    	}
    	function refuse(id){
    		$.post("${ctx}/audit/travels/update",{"auditId":id,"status":2},function(data){
    			if(data == "OK"){
    				$('#btn-status'+id).attr('class','ds-setting')
    				$('#btn-status'+id).html('不通过')
    			}
    		});
    	}
    	function changeSelect(){
    		var status = $("#select").val();
   			window.location.href="${ctx}/audit/travels/list/1/"+status;
   			$('#select').val(status);
    	}
    	window.onload = function(){
    		var status = ${status}
			$('#select').val(status);
		}
    </script>
</head>

<body>
    <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

	<!--header-->
	<%@ include file = "/lefter.jsp"%>
	<%@ include file = "/selector.jsp" %>
    <div class="product-status mg-b-30">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="product-status-wrap">
                        <h4>游记管理</h4>
 
                        <table>
                            <tr>
                            	<th>序号</th>
                                <th>图片</th>
                                <th>标题</th>
                                <th>状态</th>
                                <th>话题</th>
                                <th>路线</th>
                                <th>景点</th>
                                <th>车票</th>
                                <th>旅馆</th>
                                <th>技巧</th>
                                <th>目的地</th>
                                <th>交通</th>
                                <th>日期</th>
                                <th>天数</th>
                                <th>任务</th>
                                <th>花费</th>
                                <th>更新时间</th>
                                <th>设置</th>
                            </tr>
                            <c:forEach items="${travelsPage.list}" var="ats" varStatus="st">
                            <tr>
                            	<td>${st.count+(travelsPage.currentPageNum-1)*3 }</td>
                            	<td>
									<c:forEach items="${ats.imgList}" var="imgs">
										<a href="${ctx}/${imgs.path}" target="_blank">图片链接${imgs.imgId }</a><br>
									</c:forEach>
								</td>
                                <td>${ats.title }</td>
                                <td>
                                <c:if test="${ats.status == 0}">
                               		<button class="ps-setting" id="btn-status${ats.auditId }">未审核</button>
                                </c:if>
                                <c:if test="${ats.status == 1}">
                                	<button class="pd-setting" id="btn-status${ats.auditId }">已通过</button>
                                </c:if>
                                <c:if test="${ats.status == 2}">
                                	<button class="ds-setting" id="btn-status${ats.auditId }">不通过</button>
                                </c:if>
                                	
                                </td>
                                <td style="color:green;"># ${ats.topic.title } #</td>
                                <td>${ats.route  }</td>
                                <td>${ats.scene }</td>
                                <td>${ats.ticket }</td>
                                <td>${ats.hotel }</td>
                                <td>${ats.tips }</td>
                                <td>${ats.detail.destination }</td>
                                <td>${ats.detail.traffic}</td>
                                <td><fmt:formatDate type="date" value="${ats.detail.beginDate}"/></td>
                                <td>${ats.detail.days}</td>
                                <td>${ats.detail.people}</td>
                                <td>${ats.detail.money}</td>
                                <td><fmt:formatDate type="both" value="${ats.lastTime }"/></td>
                                <td>
                                    <div >
                                    <button class="pd-setting" onclick="across(${ats.auditId})">通过</button>
                                    <button class="ds-setting" onclick="refuse(${ats.auditId })">拒绝</button>
                                    </div>
                                </td>
                            </tr>
                            </c:forEach>
                        </table>
                        <div class="custom-pagination">
							<ul class="pagination">
								<li class="page-item"><p style="color:white">共 &nbsp;${travelsPage.totalCount }&nbsp;条数据 &nbsp;&nbsp;共 &nbsp;${travelsPage.totalPageNum }&nbsp;页  &nbsp; &nbsp; &nbsp;</p></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/travels/list/1/${status}">首页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/travels/list/${travelsPage.prePageNum }/${status}">上一页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/travels/list/${travelsPage.nextPageNum }/${status}">下一页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/travels/list/${travelsPage.totalPageNum }/${status}">末页</a></li>
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