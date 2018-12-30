<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
<title>Home shop</title>
</head>
 <body class="nav-md">
    <div class="container body">
      <div class="main_container">
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
                            <h2>Phụ kiện</h2>
                            <div class="title_right">
				            <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
				                <div class="input-group">
				                    <input type="text" class="form-control" placeholder="Search for...">
				                    <span class="input-group-btn">
				                    <button class="btn btn-default" type="button">Go!</button>
				                    </span>
				                </div>
				             </div>
				           </div>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">             
                            <table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                          <thead>
                              <tr align="center">
                                  	<th>ID</th>
									<th>Tên sản phẩm</th>
									<th>Hãng sản xuất</th>
									<th>Năm sản xuất</th>
									<th>Image</th>
									<th>Danh mục sản phẩm</th>
									<th>Màu</th>
									<th>Giá</th>
									<th>Xóa</th>
									<th>Sửa</th>
                              </tr>
                          </thead>
                          <tbody>
                          <c:forEach items="${list}" var="m">
                            	<tr class="odd gradeX" align="center">
                                  	<td>${m.idP}</td>
									<td>${m.tenP}</td>
									<td>${m.chiTietSP.hangSX}</td>
									<td>${m.chiTietSP.namSX}</td>
									<td>${m.img}</td>
									<td>${m.danhMuc.tenDanhMuc}</td>
									<td>${m.chiTietSP.mau}</td>
									<td>${m.chiTietSP.gia}</td>                     
                                  	<td><a href="<c:url value='/admin/product/delete?id=${m.idP}'/>" class="btn btn-primary btn-sm xoa"><i class="fa fa-trash"></i> Delete</a></td>
                                  	<td class="center"><a href="<c:url value='/admin/product/edit?id=${m.idP}'/>" class="btn btn-primary btn-sm"><i class="fa fa-pencil"></i>Update</a></td>
                             	</tr>
                           </c:forEach>
                           </tbody>
                      </table>
                        </div>
                    </div>
                </div>
                <div class="col-md-12 col-sm-12 col-xs-12" style="text-align: right;">
                  	<a href="<c:url value = '/admin/product/add'/>" class="btn btn-primary btn-sm"><i class="fa fa-pencil"></i> Thêm mới </a>
                </div>
            </div>
          </div>
        </div>
        <footer>
        </footer>
      </div>
    </div>
    <script src="/LapTrinhWeb/static/vendors/jquery/dist/jquery.min.js"></script>
    <script src="/LapTrinhWeb/static/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="/LapTrinhWeb/static/js/custom.js"></script>
  </body>
</html>