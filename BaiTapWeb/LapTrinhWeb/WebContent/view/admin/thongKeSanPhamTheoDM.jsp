<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<!--Load the AJAX API-->
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">

      // Load the Visualization API and the piechart package.
      google.load('visualization', '1.0', {'packages':['corechart']});
      google.setOnLoadCallback(drawChart);

      function drawChart() {
        // Create the data table.
        var data = new google.visualization.DataTable();
        // Create columns for the DataTable
        var SM = ${SM};var TL =${TL}; var LT =${LT}; var PK = ${PK};
        data.addColumn('string');
        data.addColumn('number', '');
        // Create Rows with data
        data.addRows([
          ['Laptop', SM],
          ['Tablet', TL],
          ['Smartphone', LT],
          ['Phụ kiện', PK],
        ]);
		//Create option for chart
        var options = {
		   is3D :true,
           title: 'Thống kê sản phẩn theo danh mục',
          'width': 500,
          'height': 450
        };

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<jsp:include page="menuAdmin.jsp"></jsp:include>
			<div class="right_col" role="main">
				<div class="">
					<div class="page-title">
						<div  style="width: 700px;" class="title_left">
							<h3>Biểu đồ <small> Thống kê sản phẩn theo danh mục</small></h3>
							<div style="float: right;" id="chart_div"></div>
						</div>
					</div>
					<br />
				</div>
			</div>
		</div>
	</div>

	<footer> </footer>
	<script src="/LapTrinhWeb/static/vendors/jquery/dist/jquery.min.js"></script>
	<script src="/LapTrinhWeb/static/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="/LapTrinhWeb/static/js/custom.js"></script>
</body>
</html>

