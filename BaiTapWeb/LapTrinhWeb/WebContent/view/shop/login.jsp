<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="/LapTrinhWeb/static/css/style.css"/>
<title>Homeshop</title>

</head>
<body>
	<jsp:include page="menutop.jsp"></jsp:include>
	<div id="login">
		<div id="form-a">
			<h1>Đăng nhập</h1>
			<c:url value="/dang-nhap" var="url"/>
			<form action="${url}" method="post">
				<label id="lable-user" for="username"><img src="/LapTrinhWeb/static/images/user.png"/></label>
				<input id="username" type="text" name="username" placeholder="Username" /> 
				<label id="lable-pass" for="password"><img src="/LapTrinhWeb/static/images/password.png"/></label>
				<input type="password" name="password" placeholder="Passwrod" /> 
				<a href="#">Quên mật khẩu?</a>
				<button type="submit">Đăng nhập</button>
				<a href="<c:url value='/dang-ky'/>">Đăng ký</a>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		var err = ${err};
		if(err==1){
			alert('Nhập sai username hoặc password');
		}
	</script>
</body>
</html>