<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="temp"></div>
<div id="menu-top">
	<ul>
		<li class="home-shop"><a href="/LapTrinhWeb/home-shop">Home<span>Shop</span></a></li>
		<li><a href="/LapTrinhWeb/home-shop">Home &rsaquo;</a>
			<ul>
				<li><a href="/LapTrinhWeb/smartphone">Điện thoại</a></li>
				<li><a href="/LapTrinhWeb/table">Tablet</a></li>
				<li><a href="/LapTrinhWeb/laptop">Laptop</a></li>
				<li><a href="/LapTrinhWeb/phukien">Phụ kiện</a></li>
			</ul></li>
		<li><a href="#">Khuyến mãi</a></li>
		<li><a href="#">Công nghệ</a></li>
		<li><a href="#">Hỏi đáp</a></li>
	</ul>
	<div id="dang-nhap-dang-ky">
		<c:if test="${sessionScope.member==null}">
			<a href="<c:url value = '/dang-nhap'/>">Đăng nhập</a>
			<a href="<c:url value = '/dang-ky'/>">Đăng ký</a>
		</c:if>
		<c:if test="${sessionScope.member!=null}">
			<p>${sessionScope.member.hoTen}</p>
			<button><a href="/LapTrinhWeb/logout">Đăng xuất</a></button>
		</c:if>
	</div>
	<div id="gio-hang">
		<div>
			<a href="/LapTrinhWeb/gio-hang"><img src="/LapTrinhWeb/static/images/shopping-cart(1).png"></a>
		</div>
		<p>Shopping cart</p>
		<p>
			<span id="so-luong-items"></span> items
		</p>
	</div>
	
</div>


<script type="text/javascript">
	$('#gio-hang div').mouseover(function() {
		$(this).css({"background-color" : "white"});
		$('#gio-hang img').attr('src','/LapTrinhWeb/static/images/shopping-cart.png');
	});
	$('#gio-hang div').mouseout(function() {
		$(this).css({"background-color" : "#6b9cff"});
		$('#gio-hang img').attr('src','/LapTrinhWeb/static/images/shopping-cart(1).png');
	});
	var soLuong = ${sessionScope.soLuong};
	if(soLuong != 0){
		$('#so-luong-items').html(soLuong);
	}else{
		$('#so-luong-items').html(0);
	}
</script>