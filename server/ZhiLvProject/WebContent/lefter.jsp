<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>


    <div class="left-sidebar-pro">
        <nav id="sidebar" class="">
            <div class="sidebar-header">
                <a href="#"><img class="main-logo" src="${ctx }/img/logo/logo.png" alt="" /></a>
                <strong><img src="${ctx }/img/logo/logosn.png" alt="" /></strong>
            </div>
			<div class="nalika-profile">
				<div class="profile-dtl">
					<a href="#"><img src="${ctx }/img/notification/head1.png" alt="" /></a>
					<h2>${nickname }</h2>
				</div>
				<div class="profile-social-dtl">
				<!--  
					<ul class="dtl-social">
						<li><a href="#"><i class="icon nalika-facebook"></i></a></li>
						<li><a href="#"><i class="icon nalika-twitter"></i></a></li>
						<li><a href="#"><i class="icon nalika-linkedin"></i></a></li>
					</ul>
					-->
				</div>
			</div>
            <div class="left-custom-menu-adp-wrap comment-scrollbar">
                <nav class="sidebar-nav left-sidebar-menu-pro">
                    <ul class="metismenu" id="menu1">
                        <li class="active">
                            <a class="has-arrow" href="#">
								   <i class="icon nalika-home icon-wrap"></i>
								   <span class="mini-click-non">审核管理</span>
								</a>
                            <ul class="submenu-angle" aria-expanded="true">
                                <li><a title="Dashboard v.1" href="${ctx }/audit/scene/list/1"><span class="mini-sub-pro">景点管理</span></a></li>
                                <li><a title="Dashboard v.2" href="${ctx }/audit/topic/list/1/0"><span class="mini-sub-pro">话题管理</span></a></li>
                                <li><a title="Dashboard v.3" href="${ctx }/audit/travels/list/1/0"><span class="mini-sub-pro">游记管理</span></a></li>
                                <li><a title="Product List" href="${ctx }/audit/video/list/1/0"><span class="mini-sub-pro">视频管理</span></a></li>
                     
                            </ul>
                        </li>
                        <li>
                            <a class="has-arrow" href="#" aria-expanded="false"><i class="icon nalika-mail icon-wrap"></i> <span class="mini-click-non">通知消息</span></a>
                            <ul class="submenu-angle" aria-expanded="false">
                                <li><a title="View Mail" href="${ctx }/notification/userlist"><span class="mini-sub-pro">通知管理</span></a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="has-arrow" href="#" aria-expanded="false"><i class="icon nalika-table icon-wrap"></i> <span class="mini-click-non">用户角色</span></a>
                            <ul class="submenu-angle" aria-expanded="false">
                                <li><a title="Peity Charts" href="${ctx }/audit/user/list/1"><span class="mini-sub-pro">用户管理</span></a></li>
                            </ul>
                        </li>
                        <li id="removable">
                            <a class="has-arrow" href="#" aria-expanded="false"><i class="icon nalika-new-file icon-wrap"></i> <span class="mini-click-non">问题反馈</span></a>
                            <ul class="submenu-angle" aria-expanded="false">
                                <li><a title="Login" href="${ctx }/problem/list/1"><span class="mini-sub-pro">反馈管理</span></a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </nav>
    </div>
    <!-- Start Welcome area -->
    <div class="all-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="logo-pro">
                        <a href="#"><img class="main-logo" src="${ctx }/img/logo/logo.png" alt="" /></a>
                    </div>
                </div>
            </div>
        </div>
        <div class="header-advance-area">
            <div class="header-top-area">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="header-top-wraper">
                                <div class="row">
                                    <div class="col-lg-1 col-md-0 col-sm-1 col-xs-12">
                                        <div class="menu-switcher-pro">
                                            <button type="button" id="sidebarCollapse" class="btn bar-button-pro header-drl-controller-btn btn-info navbar-btn">
													<i class="icon nalika-menu-task"></i>
												</button>
                                        </div>
                                    </div>                                  
                                    <div class="col-lg-5 col-md-5 col-sm-12 col-xs-12">
                                        <div class="header-right-info">
                                            <ul class="nav navbar-nav mai-top-nav header-right-menu">
                                                <li class="nav-item dropdown">
                                                    <a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle"><i class="icon nalika-mail nalika-chat-pro" aria-hidden="true"></i><span class="indicator-ms"></span></a>
                                                    <div role="menu" class="author-message-top dropdown-menu animated zoomIn">
                                                        <div class="message-single-top">
                                                            <h1>消息</h1>
                                                        </div>
                                                        <ul class="message-menu">
                                                            <li>
                                                                <a href="#">
                                                                    <div class="message-img">
                                                                        <img src="${ctx }/img/contact/1.jpg" alt="">
                                                                    </div>
                                                                    <div class="message-content">
                                                                        <span class="message-date">Time</span>
                                                                        <h2>标题</h2>
                                                                        <p>Please done this project as soon possible.</p>
                                                                    </div>
                                                                </a>
                                                            </li>                                                     
                                                        </ul>
                                                        <div class="message-view">
                                                            <a href="#">所有消息</a>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="nav-item"><a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle"><i class="icon nalika-alarm" aria-hidden="true"></i><span class="indicator-nt"></span></a>
                                                    <div role="menu" class="notification-author dropdown-menu animated zoomIn">
                                                        <div class="notification-single-top">
                                                            <h1>通知</h1>
                                                        </div>
                                                        <ul class="notification-menu">
                                                        	
                                                            <li>
                                                                <a href="#">
                                                                    <div class="notification-icon">
                                                                        <i class="icon nalika-cloud" aria-hidden="true"></i>
                                                                    </div>
                                                                    <div class="notification-content">
                                                                        <span class="notification-date">Time</span>
                                                                        <h2>标题xxxxx</h2>
                                                                        <p>Please done this project as soon possible.</p>
                                                                    </div>
                                                                </a>
                                                            </li>                               
                                                        </ul>
                                                        <div class="notification-view">
                                                            <a href="#">所有通知</a>
                                                        </div>
                                                    </div>
                                                </li>
                                                <li class="nav-item">
                                                    <a href="#" data-toggle="dropdown" role="button" aria-expanded="false" class="nav-link dropdown-toggle">
															<i class="icon nalika-user nalika-user-rounded header-riht-inf" aria-hidden="true"></i>
															<span class="admin-name">个人中心</span>
															<i class="icon nalika-down-arrow nalika-angle-dw nalika-icon"></i>
														</a>
                                                    <ul role="menu" class="dropdown-header-top author-log dropdown-menu animated zoomIn">
                                                        <li><a href="${ctx }/register.jsp"><span class="icon nalika-home author-log-ic"></span> 注册</a>
                                                        </li>                                                 
                                                        <li><a href="${ctx }/admin/logout"><span class="icon nalika-unlocked author-log-ic"></span> 退出登录</a>
                                                        </li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
