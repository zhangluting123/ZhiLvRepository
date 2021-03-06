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
    		$.post("${ctx}/audit/scene/update",{"auditId":id,"status":1},function(data){
    			if(data == "OK"){
    				$('#btn-status'+id).attr('class','pd-setting')
    				$('#btn-status'+id).html('已通过')
    			}
    		});
    	}
    	function refuse(id){
    		$.post("${ctx}/audit/scene/update",{"auditId":id,"status":2},function(data){
    			if(data == "OK"){
    				$('#btn-status'+id).attr('class','ds-setting')
    				$('#btn-status'+id).html('不通过')
    			}
    		});
    	}
    </script>
</head>

<body>
    <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->

	<!--header-->
	<%@ include file = "/lefter.jsp"%>

    <div class="product-status mg-b-30" style="margin-top:80px">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="product-status-wrap">
                        <h4>景点管理</h4>
                        <table>
                            <tr>
                            	<th>序号</th>
                                <th>图片</th>
                                <th>标题</th>
                                <th>状态</th>
                                <th>内容</th>
                                <th>规则</th>
                                <th>开放时间</th>
                                <th>交通</th>
                                <th>车票</th>
                                <th>花费时间</th>
                                <th>电话</th>
                                <th>网站</th>
                                <th>更新时间</th>
                                <th>设置</th>
                            </tr>
                            <c:forEach items="${scenePage.list}" var="ascene" varStatus="st">
                            <tr>
                            	<td>${st.count+(scenePage.currentPageNum-1)*3 }</td>
                                <td><img src="${ctx}/${ascene.path }" alt="" /></td>
                                <td>${ascene.title }</td>
                                <td>
                                <c:if test="${ascene.status == 0}">
                               		<button class="ps-setting" id="btn-status${ascene.auditId }">未审核</button>
                                </c:if>
                                <c:if test="${ascene.status == 1}">
                                	<button class="pd-setting" id="btn-status${ascene.auditId }">已通过</button>
                                </c:if>
                                <c:if test="${ascene.status == 2}">
                                	<button class="ds-setting" id="btn-status${ascene.auditId }">不通过</button>
                                </c:if>
                                	
                                </td>
                                <td>${ascene.content }</td>
                                <td>${ascene.rule }</td>
                                <td>${ascene.openTime }</td>
                                <td>${ascene.traffic }</td>
                                <td>${ascene.ticket }</td>
                                <td>${ascene.costTime }</td>
                                <td>${ascene.phone }</td>
                                <td><a href="${ascene.website }" target="_blank">网址</a></td>
                                <td><fmt:formatDate type="both" value="${ascene.updateTime }"/></td>
                                <td>
                                    <div >
                                    <button class="pd-setting" onclick="across(${ascene.auditId})">通过</button>
                                    <button class="ds-setting" onclick="refuse(${ascene.auditId })">拒绝</button>
                                    </div>
                                </td>
                            </tr>
                            </c:forEach>
                        </table>
                        <div class="custom-pagination">
							<ul class="pagination">
								<li class="page-item"><p style="color:white">共 &nbsp;${scenePage.totalCount }&nbsp;条数据 &nbsp;&nbsp;共 &nbsp;${scenePage.totalPageNum }&nbsp;页  &nbsp; &nbsp; &nbsp;</p></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/scene/list/1/">首页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/scene/list/${scenePage.prePageNum }">上一页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/scene/list/${scenePage.nextPageNum }">下一页</a></li>
								<li class="page-item"><a class="page-link" href="${ctx }/audit/scene/list/${scenePage.totalPageNum }">末页</a></li>
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