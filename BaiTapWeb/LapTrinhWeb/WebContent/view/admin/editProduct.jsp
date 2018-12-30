<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Home shop</title>
</head>
<body class="nav-md">
	<div class="container body">
      <div class="main_container">
        <jsp:include page="menuAdmin.jsp"></jsp:include>
        <div class="right_col" role="main">
        	<div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Thêm sản phẩm</h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <br />
                    <c:url value="/admin/product/edit" var="url"/>
                    <form id="demo-form2" enctype="multipart/form-data" data-parsley-validate class="form-horizontal form-label-left" action="${url}" method="post">
						  <input type="hidden" name="idP" value="${pro.idP }">
	                      <div class="form-group">
	                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nameProduct">Tên sản phẩm</label>
	                        <div class="col-md-6 col-sm-6 col-xs-12">
	                          <input type="text" value="${pro.tenP }" id="nameProduct" name="nameProduct" required="required" class="form-control col-md-7 col-xs-12">
	                        </div>
	                      </div>
	                      <div class="form-group">
	                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="img">Ảnh</label>
	                        <div class="col-md-6 col-sm-6 col-xs-12">
	                          <input type="text" value="${pro.img }" id="img" name="img" required="required" class="form-control col-md-7 col-xs-12">
	                        </div>
	                      </div>
	                      <div class="form-group">
	                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="newImg">Ảnh</label>
	                        <div class="col-md-6 col-sm-6 col-xs-12">
	                          <input type="file" id="newImg" name="newImg"  class="form-control col-md-7 col-xs-12">
	                        </div>
	                      </div>
	                      <div class="form-group">
	                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="hang">Hãng sản xuất</label>
	                        <div class="col-md-6 col-sm-6 col-xs-12">
	                          <input type="text" id="hang" value="${pro.chiTietSP.hangSX }" name="hang" required="required" class="form-control col-md-7 col-xs-12">
	                        </div>
	                      </div>
	                      <div class="form-group">
	                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nam">Năm sản xuất</label>
	                        <div class="col-md-6 col-sm-6 col-xs-12">
	                          <input type="text" id="nam" value="${pro.chiTietSP.namSX }" name="nam" required="required" class="form-control col-md-7 col-xs-12">
	                        </div>
	                      </div>
	                      <div class="form-group">
	                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nam">Màu sản phẩm</label>
	                        <div class="col-md-6 col-sm-6 col-xs-12">
	                          <input type="text" value="${pro.chiTietSP.mau }" id="màu" name="mau" required="required" class="form-control col-md-7 col-xs-12">
	                        </div>
	                      </div>
	                      <div class="form-group">
	                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="gia">Giá sản phẩm</label>
	                        <div class="col-md-6 col-sm-6 col-xs-12">
	                          <input type="text" id="gia" value="${pro.chiTietSP.gia }" name="gia" required="required" class="form-control col-md-7 col-xs-12">
	                        </div>
	                      </div>
	                      <div class="form-group">
	                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Danh mục sản phẩm</label>
	                        <div class="col-md-6 col-sm-6 col-xs-12">
	                          	<input type="radio" name="danhMuc" value="1" id="sm">Smartphone
								<input type="radio" name="danhMuc" value="2" id="ta">Tablet
								<input type="radio" name="danhMuc" value="3" id="la">Laptop
								<input type="radio" name="danhMuc" value="4" id="pk">Phụ kiện
	                        </div>
	                      </div>
	                      <div class="ln_solid"></div>
	                      <div class="form-group">
	                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
							  <button class="btn btn-primary" type="reset">Reset</button>
	                          <button type="submit" class="btn btn-success">Submit</button>
	                        </div>
	                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
        <footer>
        </footer>
      </div>
    </div>
    <script type="text/javascript">
		var id = ${pro.danhMuc.id};
		if(id == 1){
			document.getElementById('sm').checked = true;
		}
		if(id == 2){
			document.getElementById('ta').checked = true;
		}
		if(id == 3){
			document.getElementById('la').checked = true;
		}
		if(id == 4){
			document.getElementById('pk').checked = true;
		}
	</script>
	<script src="/LapTrinhWeb/static/vendors/jquery/dist/jquery.min.js"></script>
    <script src="/LapTrinhWeb/static/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="/LapTrinhWeb/static/js/custom.js"></script>
</body>
</html>