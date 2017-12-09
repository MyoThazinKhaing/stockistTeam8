<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
<style>
.list-group-item {
	background-color: transparent;
	border: none;
}
.nav-pills .nav-link.active, .nav-pills .show>.nav-link {
    background-color: #104982;
}
div.dropdown-menu.show{
    left:auto !important;
    right: 5 !important;
    top: 10 !important;
    margin-right:-6px !important;
}

.dropdown-item {
	font-size: 1.25em;
}
</style>
</head>


</body>


<div>

	<!-- Main Navbar-->
	<div class="navbox">
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			<h1>
				<a class="navbar-brand" href="#"> <i class="fa fa-car fa-2x" aria-hidden="true"></i> 
				<span style="font-size:2rem">&nbsp;&nbsp;&nbsp;TEAM 8 STOCKLIST</span></a>
			</h1>
			<!-- <button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarColor03" aria-controls="navbarColor03"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button> -->
			
			<div class="collapse navbar-collapse" id="navbarColor03">
				<ul class="nav nav-pills" style="margin-left: auto;">
					<li class="nav-item dropdown"><a
						style="color: white; font-size: 1.25em"
						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-haspopup="true" aria-expanded="false"> <i
							class="fa fa-user fa-2x" aria-hidden="true"></i>
					</a>
						<div class="dropdown-menu" x-placement="bottom-start"
							style="position: absolute; transform: translate3d(0px, 38px, 0px); top: 0px; left: 0px; will-change: transform;">
							<a class="dropdown-item" href="#">Manage account</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="${pageContext.request.contextPath}/home/logout">Logout</a>
						</div></li>
				</ul>
				
			</div>

		</nav>
	</div>
</div>


</body>

