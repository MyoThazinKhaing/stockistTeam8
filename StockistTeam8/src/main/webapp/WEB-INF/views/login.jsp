<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta name="decorator" content="nodeco" />
<head>
<!-- Bootstrap Litera CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
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

	// Duration is the amount of time in between slides,
	// and fade is value that determines how quickly the next image will fade in
	$.backstretch([ "http://www.mobilemechanichoustonpros.com/wp-content/uploads/2014/04/auto-repair-promo.jpg",
			"https://latestautocar.com/wp-content/uploads/2017/03/perfect-cool-ford-cars-with-img-f9zu-cool-ford-cars-ideas-by-gallery.jpg",
			"https://img.gaadicdn.com/images/mycar/large/audi/a5/marketing/Audi-A5.webp" ], {
		duration : 3000,
		fade : 750
	});
</script>

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
							<h3 class="welcome">
								<p style="color: #CFEDFC">
									Welcome back&nbsp;
									<c:out value="${sessionScope.USERSESSION.user.username}" />
								</p>
								<spring:url value="/product/catalogue" var="catalog"
									htmlEscape="true" />
								<p>
									<a href="${catalog}"> Browse catalog </a>
								</p>
								<spring:url value="/logout" var="logout" htmlEscape="true" />
								<p>
									<a href="${logout}"> Logout </a>
								</p>
							</h3>
						</c:if>
						<c:if test="${sessionScope.USERSESSION == null}">
							<spring:url value="/authenticate" var="login" htmlEscape="true" />
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
									<c:if test="${not empty error}">
										<div class="error">${error}</div>
									</c:if>
								</div>
							</form:form>
						</c:if>

					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.backstretch.min.js"></script>
	<script>
		$
				.backstretch(
						[
								"http://www.mobilemechanichoustonpros.com/wp-content/uploads/2014/04/auto-repair-promo.jpg",
								"https://latestautocar.com/wp-content/uploads/2017/03/perfect-cool-ford-cars-with-img-f9zu-cool-ford-cars-ideas-by-gallery.jpg",
								"https://img.gaadicdn.com/images/mycar/large/audi/a5/marketing/Audi-A5.webp" ],
						{
							fade : 750,
							duration : 4000
						});
	</script>
</body>
</html>