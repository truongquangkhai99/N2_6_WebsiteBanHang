<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="<c:url value='/admin/home'/>" class="site_title"><i class="fa fa-paw"></i> <span>HomeShop</span></a>
            </div>
            <div class="clearfix"></div>
            <br />
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <ul class="nav side-menu">
                  <li><a href="<c:url value = '/admin/member/list'/>"><i class="fa fa-user"></i> Thành Viên </a> </li>
                  <li><a><i class="fa fa-tags"></i> Sản phẩm <span class="fa fa-chevron-down"></span></a>
	                  <ul class="nav child_menu">
	                      <li><a href="<c:url value='/admin/product/smartphone'/>">Smartphone</a></li>
	                      <li><a href="<c:url value='/admin/product/tablet'/>">Tablet</a></li>
	                      <li><a href="<c:url value='/admin/product/laptop'/>">Laptop</a></li>
	                      <li><a href="<c:url value='/admin/product/phukien'/>">Phụ kiện</a></li>
	                  </ul>
                  </li>
                  <li><a><i class="fa fa-pie-chart"></i> Thống Kê <span class="fa fa-chevron-down"></a>
	                  <ul class="nav child_menu">
		                      <li><a href="<c:url value='/admin/thong-ke/doanh-thu'/>">Doanh thu</a></li>
		                      <li><a href="<c:url value='/admin/thong-ke/san-pham'/>">Sản phẩm bán ra</a></li>
		                      <li><a href="<c:url value='/admin/thong-ke/danh-muc-sp'/>">Sản phẩm theo danh mục</a></li>
		                      <li><a href="<c:url value='/admin/thong-ke/so-luong-hoa-don'/>">Số lượng hóa đơn</a></li>
		              </ul>
                  </li>
                  <li><a href="<c:url value='/admin/hoa-don/list'/>"><i class="fa fa-gift"></i> Hóa Đơn </a></li>
                    
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>
              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a  class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                    <img src="<c:url value='/'/>" alt="">${sessionScope.member.hoTen}
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="javascript:;">Thông tin</a></li>
                    <li><a href="<c:url value = '/home-shop'/>"><i class="fa fa-sign-out pull-right"></i>Trang mua sắm</a></li>
                    <li><a href="<c:url value = '/logout'/>"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                  </ul>
                </li>
              </ul>
            </nav>
          </div>
        </div>
</div>