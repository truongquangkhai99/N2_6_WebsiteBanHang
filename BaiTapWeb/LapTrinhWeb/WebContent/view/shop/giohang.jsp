<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/LapTrinhWeb/static/css/style.css" rel="stylesheet" />
<script type="text/javascript" charset="utf8" src="/LapTrinhWeb/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/LapTrinhWeb/static/js/myJS.js"></script>
<title>Homeshop</title>
</head>
<body>
	<jsp:include page="menutop.jsp"></jsp:include>
	<div id="s-title">
		<p style="visibility: hidden;">
		<a href="/LapTrinhWeb/home-shop">HOME</a>/<a class="link-danh-muc"><span class="danh-muc-product"></span></a>/<span class="name-product"></span>
		</p>
		<h1>Giỏ hàng</h1>
		<p>
			<a href="/LapTrinhWeb/home-shop">&larr; Back to Home</a>
		</p>
	</div>
	<div id="main-gio-hang">
			<table id="show-gio-hang">
				<tr>
					<th>STT</th>
					<th colspan="2">Sản phẩm</th>
					<th>Số lượng</th>
					<th>Đơn giá</th>
					<th>Giá</th>
					<th>Dalete</th>
					<th>Update</th>
				</tr>
				<c:forEach items="${sessionScope.carts}" var="cartItem" varStatus="status">
					<tr>
						<c:url var="url" value="/update-cart" />
						<form action="${url}" method="post">
							<input type="hidden" value="${cartItem.product.idP}"
								name="idP" />
							<td>${status.count}</td>
							<td><img class="img-pro-gio-hang" src="/LapTrinhWeb/static/images/${cartItem.product.img}"></td>
							<td><a href="<c:url value='/chi-tiet?id=${cartItem.product.idP}'/>">${cartItem.product.tenP}</a></td>
							<td><input type="number" value="${cartItem.quantity}"
								name="quantity" /></td>
							<td>${cartItem.product.chiTietSP.gia}đ</td>
							<td>${cartItem.product.chiTietSP.gia * cartItem.quantity} đ</td>
							<td><a  href="<c:url value='/remove-cart?idP=${cartItem.product.idP}'/>"><img class="xoa-pro" src="/LapTrinhWeb/static/images/bin.png"></a></td>
							<td><button type="submit">Update</button></td>
						</form>
					</tr>
					<!--  <tr>
						<td><img class="img-pro-gio-hang" src="/LapTrinhWeb/static/images/huawei-pad-m3.png"></td>				
						<td>Chinhdz</td>				
						<td>10</td>				
						<td><img class="xoa-pro" src="/LapTrinhWeb/static/images/bin.png"></td>			
					</tr>-->
				</c:forEach>
				<c:if test="${empty sessionScope.carts}">
				<tr>
					<td colspan="7">Không có sản phẩm nào trong giỏ hàng.</td>
				</tr>
			</c:if>
			</table>
		<div id="button">
			<c:if test="${not empty sessionScope.carts}">
				<button class="button-gh button-tt"><a href="<c:url value='/member/phuong-thuc-thanh-toan'/>">Thanh toán</a></button>
			</c:if>
			<button class="button-gh button-mt"><a href="/LapTrinhWeb/home-shop">Mua tiếp</a></button>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		var member = ${sessionScope.member};
		$('.button-gh button-tt').on('click',function(){
			if (typeof(member) == 'undefined' || member == null)
			{
				alert('Bạn chưa đăng nhập.');
			}

		});	
	</script>
</body>
</html>