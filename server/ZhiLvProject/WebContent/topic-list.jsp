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
    		$.post("${ctx}/audit/topic/update",{"auditId":id,"status":1},function(data){
    			if(data == "OK"){
    				$('#btn-status'+id).attr('class','pd-setting')
    				$('#btn-status'+id).html('已通过')
    			}
    		});
    	}
    	function refuse(id){
    		$.post("${ctx}/audit/topic/update",{"auditId":id,"status":2},function(data){
    			if(data == "OK"){
    				$('#btn-status'+id).attr('class','ds-setting')
    				$('#btn-status'+id).html('不通过')
    			}
    		});
    	}
    	function changeSelect(){
    		var status = $("#select").val();
   			window.location.href="${ctx}/audit/topic/list/1/"+status;
   			
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
	
    <div class="product-status mg-b-30" >
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="product-status-wrap">
                        <h4>话题管理</h4>
 
                        <table>
                            <tr>
                                <th>序号</th>
                                <th>标题</th>
                                <th>状态</th>         
                                <th>更新时间</th>
                                <th>设置</th>
                            </tr>
                            <c:forEach items="${topicPage.list}" var="topic" varStatus="st">
                            <tr>
                                <td>${st.count+(topicPage.currentPageNum-1)*3 }</td>
                                <td>${topic.title }</td>
                                <td>
                                <c:if test="${topic.status == 0}">
                               		<button class="ps-setting" id="btn-status${topic.auditId }">未审核</button>
                                </c:if>
                                <c:if test="${topic.status == 1}">
                                	<button class="pd-setting" id="btn-status${topic.auditId }">已通过</button>
                                </c:if>
                                <c:if test="${topic.status == 2}">
                                	<button class="ds-setting" id="btn-status${topic.auditId }">不通过</button>
                                </c:if>
                                	
                                </td>                        
                                <td><fmt:formatDate type="both" value="${topic.time }"/></td>
                                <td>
                                    <div >
                                    <button class="pd-setting"  onclick="across(${topic.auditId})">通过</button>
                                    <button class="ds-setting"  onclick="refuse(${topic.auditId })">拒绝</button>
                                    </div>
                                </td>
                            </tr>
                            </c:forEach>
                        </table>
                        <div class="custom-pagination">
							<ul class="pagination">
								<li class="page-item"><p style="color:white">共 &nbsp;${topicPage.totalCount }&nbsp;条数据 &nbsp;&nbsp;共 &nbsp;${topicPage.totalPageNum }&nbsp;页  &nbsp; &nbsp; &nbsp;</p></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/topic/list/1/${status}">首页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/topic/list/${topicPage.prePageNum }/${status}">上一页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/topic/list/${topicPage.nextPageNum }/${status}">下一页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/topic/list/${topicPage.totalPageNum }/${status}">末页</a></li>
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