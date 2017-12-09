
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

</body>
<div>
	<h1 align="right">
		<spring:message code="title.application" />
	</h1>
	<h2>
		<c:if test="${not empty sessionScope.USERSESSION}">
			<spring:message code="caption.user" /> :
<c:out value="${sessionScope.USERSESSION.user.username}" /> ;
<spring:message code="caption.role" /> :
<c:out value="${sessionScope.USERSESSION.user.role}" />
		</c:if>
	</h2>

	<!-- Main Navbar-->

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#"><spring:message
				code="title.application" /></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor03" aria-controls="navbarColor02"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarColor03">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Features</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#">Pricing</a></li>
				<li class="nav-item"><a class="nav-link" href="#">About</a></li>
			</ul>
			<ul class="nav nav-pills" >
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
					role="button" aria-haspopup="true" aria-expanded="false">Dropdown</a>
					<div class="dropdown-menu" x-placement="bottom-start"
						style="position: absolute; transform: translate3d(0px, 38px, 0px); top: 0px; left: 0px; will-change: transform;">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a> <a
							class="dropdown-item" href="#">Something else here</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Separated link</a>
					</div></li>
			</ul>
		</div>
	</nav>

	<nav class="navbar navbar-default navbar-static-top"
		style="margin-bottom: 0">
		<!-- Navbar Header-->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">SB Admin v2.0</a>
		</div>
		<!-- Navbar Menu -->
		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><spring:url value="/home/profile" var="profile"
							htmlEscape="true" /> <a href="${profile}"><i
							class="fa fa-user fa-fw"></i> <spring:message
								code="menu.user.profile" /></a></li>
					<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
					</li>
					<li class="divider"></li>
					<li><spring:url value="/home/logout" var="logout"
							htmlEscape="true" /> <a href="${logout}"><i
							class="fa fa-sign-out fa-fw"></i> <spring:message
								code="menu.user.logout" /></a></li>
				</ul></li>

		</ul>
	</nav>
</div>


</body>

