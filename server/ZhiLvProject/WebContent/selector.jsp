<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>

<!-- Mobile Menu end -->
     <div class="breadcome-area">
         <div class="container-fluid">
             <div class="row">
                 <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<div class="breadcome-list">
                         <div class="row">
                             <div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
                                 <div class="breadcomb-wp">
									<div class="breadcomb-icon">
										<i class="icon nalika-home"></i>
									</div>
								 <div class="col-lg-6 col-md-7 col-sm-6 col-xs-12">
                                   	<div class="header-top-menu tabl-d-n">
                                       	<div class="breadcome-heading">
											<select id="select" onchange="changeSelect()">
											  	<option id="0" value ="0">未审核</option>
											  	<option id="1" value="1">已通过</option>
											  	<option id="2" value="2">不通过</option>
											  	<option id="-1" value ="-1">全部</option>
											</select>
										</div>
                                   </div>
                              	 </div>
								</div>
                     		</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>	