<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/LapTrinhWeb/static/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/LapTrinhWeb/static/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="/LapTrinhWeb/static/css/custom.min.css" rel="stylesheet">
    <style type="text/css">
      th {
        text-align: center;
      }
    </style>
	<title>HomeShop</title>
</head>
<body class="nav-md">
    <div class="container body">
    <jsp:include page="menuAdmin.jsp"></jsp:include>  
        <div class="right_col" role="main">
        <div class="">
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                   <br/>
                   <p class=""></p>
                </div>
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Mã khách hàng  :  ${order.member.id}</h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_title">
                            <h2>Tên khách hàng  :  ${order.member.hoTen}</h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_title">
                            <h2>Danh sách sản phẩm : </h2>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">             
                            <table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                          <thead>
                              <tr align="center">
                                  	<th>STT</th>
									<th colspan="2">Sản phẩm</th>
									<th>Số lương</th>
									<th>Đơn giá</th>
                              </tr>
                          </thead>
                          <tbody>
                          	<c:forEach items="${order.listCartItem}" var="m" varStatus="s">
                            	<tr class="odd gradeX" align="center">
                                  	<td>${s.count}</td>
									<td><img style="width: 200px; height: 250px;" src="<c:url value ='/static/images/${m.product.img}'/>"/></td>
									<td>${m.product.tenP}</td>
									<td>${m.quantity}</td>
									<td>${m.product.chiTietSP.gia}</td>
                             	</tr>
                             </c:forEach>
                          </tbody>
                          <thead>
                              <tr align="center">
									<th colspan="4">Tổng : </th>
									<th colspan="1">${tong}</th>
                              </tr>
                          </thead>
                      </table>
                    </div>
                  </div>
                </div>
                <div class="col-md-12 col-sm-12 col-xs-12" style="text-align: left;;">
                 	<a href="<c:url value = '/admin/hoa-don/list'/>" class="btn btn-primary btn-sm"> Back </a>
                </div>
            </div>
          </div>
        </div>
        <footer>
        </footer>
      </div>
    <script src="/LapTrinhWeb/static/vendors/jquery/dist/jquery.min.js"></script>
    <script src="/LapTrinhWeb/static/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="/LapTrinhWeb/static/js/custom.js"></script>
 </body>

</html>