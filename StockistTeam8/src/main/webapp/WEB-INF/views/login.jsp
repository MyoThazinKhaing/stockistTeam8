<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>Team 8 Stock List</title>
<meta name="decorator" content="nodeco" />
<head>
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
.container-fluid {
	height: 100%;
	display: table;
	width: 100%;
	padding: 0;
}
.row-fluid {
	height: 50%;
	display: table-cell;
	vertical-align: middle;
}
.centering {
	float: none;
	margin: 0 auto;
	width: 35%;
	min-width: 40%;
}
.form-group {
	padding: 10px 30px;
	background-color: rgba(38, 12, 12, 0.7);
}
.col-form-label {
	color: white;
}
.welcome {color =#C7F2C2
	
}

h4{
	color:white;
}

.error{
	color:red;
}

</style>

</head>
<body>
	<div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="centering text-center">

					<div class="form-group">
						<p style="color: white">
							<i class="fa fa-car fa-5x" aria-hidden="true"></i>
						</p>
						<h2 style="margin: 10px 5px; color: white">
							<strong>TEAM 8 STOCKLIST</strong>
						</h2>
						<c:if test="${sessionScope.USERSESSION != null}">
							<h4 class="text-warning">
								Welcome back&nbsp;
								<c:out value="${sessionScope.USERSESSION.user.username}" />
							</h4>
							<spring:url value="/product/catalogue" var="catalog"
								htmlEscape="true" />
							<h5>
								<a class="text-info" href="${catalog}"> Browse catalog </a>
							</h5>
							<spring:url value="/logout" var="logout" htmlEscape="true" />
							<h5>
								<a class="text-info" href="${logout}"> Logout </a>
							</h5>
						</c:if>
						<c:if test="${sessionScope.USERSESSION == null}">
							<spring:url value="/login" var="login" htmlEscape="true" />
							<form:form modelAttribute="user" method="POST" action="${login}">
								<label class="col-form-label" for="unInput">Username</label>
								<form:input type="text" class="form-control"
									placeholder="Username" path="username" id="unInput" />
								<label class="col-form-label" for="pwInput">Password</label>
								<form:input type="password" class="form-control"
									placeholder="Password" path="password" id="pwInput" />
								<div style="margin: 20px 0 5px 0;">
									<button type="submit" class="btn btn-primary">Submit</button>
								</div>
								<div>
									<c:if test="${sessionScope.LOGIN == 'fail'}">
										<p class="text-danger">
											<spring:message code="error.loginfail" />
										<p>
									</c:if>
								</div>
							</form:form>
						</c:if>

					</div>
				</div>
			</div>
		</div>
	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-backstretch/2.0.4/jquery.backstretch.min.js"></script>
	<script>
		$
				.backstretch(
						[
								"https://wallup.net/wp-content/uploads/2016/01/136695-car-motion_blur-concept_cars-orange_cars.jpg",
								"https://wallup.net/wp-content/uploads/2016/01/45711-car-red_cars-motion_blur-trees.jpg",
								"https://hdwallsource.com/img/2016/9/formula-1-motion-blur-wallpaper-49938-51620-hd-wallpapers.jpg" ],
						{
							fade : 750,
							duration : 4000
						});
	</script>
</body>
</html>