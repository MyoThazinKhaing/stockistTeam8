<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<meta name="decorator" content="nodeco" />
<head>
<style>

.back{
	backgound:url('http://cdn3.wpbeginner.com/wp-content/uploads/2016/03/403forbiddenerror.jpg');
	background-size:cover;
	width:100%;
	height:100%
}

</style>

</head>
<body>
	<div class="back">
	<h3>
	<a href="${pageContext.request.contextPath}/login">Return to home</a>
	</h3>
	</div>
</body>
</html>