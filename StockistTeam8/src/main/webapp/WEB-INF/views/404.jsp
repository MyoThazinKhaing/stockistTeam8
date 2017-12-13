<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title>NOT FOUND!</title>
<meta name="decorator" content="nodeco" />
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


<style type="text/css">
div{
	min-width:100%;
	min-height:100%;
	text-align:center;
	padding-top:50px;
}

img{
	width:40%;
	height:auto;
	
}


</style>

</head>
<body>
<div>
	
	<p>
	<img alt="NOT FOUND!" src="https://image.freepik.com/free-icon/question-mark-in-a-circle_318-48536.jpg" >
	<h1>404 Page Not Found</h1>
	</p>
	
	<h3><a href="${pageContext.request.contextPath}/login"><i class="fa fa-home" aria-hidden="true"></i>
	&nbsp;Return to home</a></h3>
</div>
</body>
</html>