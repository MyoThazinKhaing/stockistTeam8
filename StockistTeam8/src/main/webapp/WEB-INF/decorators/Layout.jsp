<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Team 8 Stock List</title>

<!-- Bootstrap Litera CSS -->
<link href="https://bootswatch.com/4/litera/bootstrap.css"
	rel="stylesheet">
<link href="https://bootswatch.com/4/litera/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="http://fortawesome.github.io/Font-Awesome/3.2.1/assets/font-awesome/css/font-awesome.css">

<style>
.navbox {
	width: 100%;
	margin: auto;
}

.bg-primary {
	background-color: #373a3c !important;
}

.layout-body {
	background: url("http://www.xsjjys.com/data/out/286/WHDQ-514189697.jpg")
		!important;
	border-left: solid; min-width : 90%; min-height : 90vh;
	padding: 15px;
	min-width: 90%;
	min-height: 90vh;
}
</style>

<dec:head />


</head>
<body>
	<%@include file="Header.jsp"%>
	<!-- <table style="width: 100%; min-height: 90%; margin: auto;">
		<tr style="min-height: 90%;">
			<td style="width: 15%; min-height: 90%; min-height: 90%; padding: 20px 0px 10px 0px; background-color: #f1f1f1"
				valign="top">-->
	<div class="row" style="min-width: 90%; min-height: 90vh;">
		<div class="col-sm-2"
			style="background: 
			url('https://www.desktopbackground.org/p/2010/04/17/3423_look-this-cool-and-clean-white-background-images-wallpapers-for_3888x2592_h.jpg'); background-size:cover; padding: 5px;">
			<%@ include file="Menu.jsp"%>
		</div>
		<!-- </td> -->
		<!-- <td style="width: 80%;padding: 20px 15px 10px 15px" valign="top"> -->
		<div class="col-sm-10"
			style="padding: 10px 10px 10px 20px;">
			<div>
				<dec:body />
			</div>
		</div>
	</div>
	<!-- </td>
		</tr>
	</table> -->

	<!-- ======== Footer ======== -->
	<div id="footer" align="center">
		<hr>
		<small> &copy; ISS NUS SA45 2017 </small>
	</div>
	<!-- Bootstrap Core JavaScript -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
	<!-- jQuery -->
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->



</body>
</html>
