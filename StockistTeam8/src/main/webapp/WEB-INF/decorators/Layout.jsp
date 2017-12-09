<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="dec"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<!-- Bootstrap Litera CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">

<style>
div.dropdown-menu.show{
    left:auto;
    right:0;
    margin-right:-10px;
}
</style>

<dec:head />


</head>
<body>
	<%@include file="Header.jsp"%>
	<table style="width: 100%">
		<tr>
			<td style="width: 180; border: 1" valign="top">
				<div>

					<%@ include file="Menu.jsp"%>
				</div>
			</td>
			<td>
				<div>
					<h3>
						<spring:message code="${bodyTitle}" />
					</h3>
					<dec:body />
				</div>
			</td>
		</tr>
	</table>

	<!-- ======== Footer ======== -->
	<div id="footer" align="center">
		<hr>
		<small> &copy; ISS NUS SA42 2016 </small>
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
