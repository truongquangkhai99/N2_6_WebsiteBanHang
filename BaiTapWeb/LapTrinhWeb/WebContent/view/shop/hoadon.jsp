<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Homeshop</title>
</head>
<body>
	<h2>Hóa đơn</h2>
	<div>
		<p>Thông tin khách hàng</p>
		<p>Tên khách hàng : ${order.member.hoTen}</p>
		<p>Gmail : ${order.member.gmail}</p>
		<p>Số điện thoại : ${order.member.phone}</p>
	</div>
	<div>
		<p>Danh sách sản phẩm : </p>
		<table>
			<thead>
			<tr>
				<th>STT</th>
				<th colspan="2">Sản phẩm</th>
				<th>Đơn giá</th>
				<th>Số lượng</th>
				<th>Tổng giá</th>
			</tr>
			</thead>
			<c:forEach items="${order.listCartItem}" var="item" varStatus="i">
			<tr>
				<td>${i.count}</td>
				<td><img src="<c:url value = '/static/images/${item.product.img}'/>"></td>
				<td>${item.product.tenP}</td>
				<td>${item.product.chiTietSP.gia}</td>
				<td>${item.quantity}</td>
				<td>${item.quantity*item.product.chiTietSP.gia}</td>
			</tr>
			</c:forEach>
			<tfoot><tr>
				<th colspan="4">Tổng : </th>
				<th colspan="2">${tong}</th>
			</tr></tfoot>
		</table>
	</div>
	<div><a href="<c:url value = '/home-shop'/>">Back</a></div>
</body>
</html>