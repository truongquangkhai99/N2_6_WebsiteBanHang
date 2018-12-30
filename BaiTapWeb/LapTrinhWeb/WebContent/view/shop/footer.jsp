<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="footer">
	<div class="footer-contents">
		
		<h3 style="font-size: 20px;">
			Home<span style="color: pink; font-size: 25px;">Shop</span>
		</h3>
		<ul>
			<li><a href="/LapTrinhWeb/home-shop">Shop</a></li>
			<li><a href="#">Khuyến mãi</a></li>
			<li><a href="#">Công nghệ</a></li>
			<li><a href="#">Hỏi đáp</a></li>
		</ul>
	</div>
	<div class="footer-contents">
		<h3>FOLLOW US</h3>
		<ul id="ul-hai">
			<li><a href="<c:url value = '/dang-nhap-fb'/>"><img src="/LapTrinhWeb/static/images/facebook.png"/></a></li>
			<li><a><img src="/LapTrinhWeb/static/images/instagram.png"/></a></li>
			<li><a><img src="/LapTrinhWeb/static/images/twitter.png"/></a></li>
			
		</ul>
	</div>
	<div style="float: right:;" class="footer-contents">
		<h3>Store Information</h3>
		<ul>
			<li class="li-addr"><p>xxx Phùng Khoang,Trung Văn, </br>Nam Từ Liêm, Hà Nội</p></li>
			<li class="li-phone"><p>(+84)986.505.708</p></li>
			<li class="li-gmail"><p>homeshop@gmail.com</p></li>
		</ul>
	</div>
</div>
