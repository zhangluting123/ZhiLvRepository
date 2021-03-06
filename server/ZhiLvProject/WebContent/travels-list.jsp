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
    <style type="text/css">
    	.div1{
    		width:40px;
    		text-align:center
    	}
    	.div2{
    		width:80px;
    		text-align:center
    	}
    	.div3{
    		width:180px;
    		text-align:center
    	}
    	.div4{
    		width:180px;
    		height:150px;
    		text-align:center;
    		overflow-y:auto;
    	}
    </style>
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
                    <div class="product-status-wrap" >
                        <h4>游记管理</h4>
                        <div style="width:100%;">
 						<div style="overflow-x:scroll;display:block;text-align:center;float:left;width:80%;">
                        <table style="display:inline-block;table-layout:fixed;">
                            <tr>
                            	<th><div class="div1">序号</div></th>
                                <th><div class="div2">图片</div></th>
                                <th><div class="div2">标题</div></th>
                                <th><div class="div2">状态</div></th>
                                <th><div class="div2">话题</div></th>
                                <th><div class="div3">路线</div></th>
                                <th><div class="div3">景点</div></th>
                                <th><div class="div3">车票</div></th>
                                <th><div class="div3">旅馆</div></th>
                                <th><div class="div3">技巧</div></th>
                                <th><div class="div2">更多</div></th>
                                <th><div class="div3">审核时间</div></th>
                            </tr>
                            <c:forEach items="${travelsPage.list}" var="ats" varStatus="st">
                            <tr>
                            	<td>${st.count+(travelsPage.currentPageNum-1)*3 }</td>
                            	<td>
									<c:forEach items="${ats.imgList}" var="imgs">
										<a href="${ctx}/${imgs.path}" target="_blank">图片${imgs.imgId }</a><br>
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
                                <td style="color:green;width:80px"># ${ats.topic.title } #</td>
                                <td><div class="div4">${ats.route  }</div></td>
                                <td><div class="div4">${ats.scene }</div></td>
                                <td><div class="div4">${ats.ticket }</div></td>
                                <td><div class="div4">${ats.hotel }</div></td>
                                <td><div class="div4">${ats.tips }</div></td>
                              	<td><div class="div4">
				                    <p>目的地：${ats.detail.destination }</p>
	                                <p>交通：${ats.detail.traffic}</p>
	                                <p>开始时间：<fmt:formatDate type="date" value="${ats.detail.beginDate}"/></p>
	                                <p>天数：${ats.detail.days}</p>
	                                <p>人物：${ats.detail.people}</p>
	                                <p>花费：${ats.detail.money}</p>
									</div>
							     </td>

                                <td><fmt:formatDate type="both" value="${ats.lastTime }"/></td>
                            </tr>
                            </c:forEach>
                        </table>
                        
                        </div>
                        <div style="float:right;width:20%;">
	                        <table style="display:inline-block;table-layout:fixed;">
	                         	<tr><th><div class="div3">设置</div></th></tr>
	                         	<c:forEach items="${travelsPage.list}" var="ats" varStatus="st">
	                        		<tr>
		                        	 	<td style="padding-top:70px" >
		                                    <div style="height:88.5px;" >
		                                   		<button class="pd-setting" onclick="across(${ats.auditId})">通过</button>
		                                 		<button class="ds-setting" onclick="refuse(${ats.auditId })">拒绝</button>
		                                    </div>
		                                </td>
	                                </tr>
	                        	 </c:forEach>
	                        </table>
	                        <div style="background:white;height:17px;"></div>
                        </div>
                        </div>
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