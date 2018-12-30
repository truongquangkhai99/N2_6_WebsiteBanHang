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
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type='text/javascript'>
      google.charts.load('current', {'packages':['annotationchart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = new google.visualization.DataTable();
        /*var t1 = ${t1}; var t2 =${t2};var t3 = ${t3}; var t4=${t4};
        var t5 = ${t5}; var t6 =${t6};var t7 = ${t7}; var t8 =${t8};
        var t9 = ${t9}; var t10 =${t10};var t11 = ${t11}; var t12 =${t12};*/
        data.addColumn('date', 'Date');
        data.addColumn('number', 'Doanh thu');
        data.addRows([
          [new Date(2018, 1, 1), 1000],
          [new Date(2018, 2, 1), 3000],
          [new Date(2018, 3, 1), 9000],
          [new Date(2018, 4, 1), 1111],
          [new Date(2018, 5, 1), 1500],
          [new Date(2018, 6, 1), 6000],
          [new Date(2018, 7, 1), 9000],
          [new Date(2018, 8, 1), 3000],
          [new Date(2018, 9, 1), 1000],
          [new Date(2018, 10, 1), 6000],
          [new Date(2018, 11, 1), 1000],
          [new Date(2018, 12, 1), 6000]
        ]);

        var chart = new google.visualization.AnnotationChart(document.getElementById('chart_div'));

        var options = {
          displayAnnotations: true,
        };

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
						<div class="title_left">
							<h3>Biểu đồ <small>Thống kê doanh thu</small></h3>
							<div id='chart_div' style='width: 900px; height: 450px;'></div>
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

