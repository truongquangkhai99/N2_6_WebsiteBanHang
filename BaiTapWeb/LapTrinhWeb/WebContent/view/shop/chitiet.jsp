<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chi tiet</title>
<link href="/LapTrinhWeb/static/css/style.css" rel="stylesheet" />
<script type="text/javascript" charset="utf8" src="/LapTrinhWeb/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/LapTrinhWeb/static/js/myJS.js"></script>
</head>
<body>
	<jsp:include page="menutop.jsp"></jsp:include>
	<div id="s-title">
		<p>
		<a href="/LapTrinhWeb/home-shop">HOME</a>/<a class="link-danh-muc"><span class="danh-muc-product">${pro.danhMuc.tenDanhMuc }</span></a>/<span class="name-product">${pro.tenP}</span>
		</p>
		<h1>Shop</h1>
		<p>
			<a href="/LapTrinhWeb/phu-kien">&larr; Back to Home</a>
		</p>
	</div>
	<div id="chi-tiet">
		<div id="chi-tiet-product">
			<div id="img-product">
				<img src="/LapTrinhWeb/static/images/${pro.img}"/>
			</div>
			<div id="noi-dung-chi-tiet">
				<p class="id-product" style="display: none;">${pro.idP }</p>
				<h4 class="name-product">${pro.tenP }</h4>
				<p class="gia-product"> Giá: ${pro.chiTietSP.gia}đ</p>
				<h5> Hãng sản xuất: ${pro.chiTietSP.hangSX }</h5>
				<p>Màu: ${pro.chiTietSP.mau }</p>
				<p class="add-to-cart-2">
					<a class="add-to-cart"  href="/LapTrinhWeb/add-cart?idP=${pro.idP}">Add to Cart</a>
				</p>
				<p>
					<a href="/LapTrinhWeb/add-cart?idP=${pro.idP}">Mua ngay</a>
				</p>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>