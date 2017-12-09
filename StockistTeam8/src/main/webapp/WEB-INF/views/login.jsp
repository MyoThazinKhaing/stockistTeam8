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
.box {	
	padding: 20px;
	background-color: #eee;
	width:35%;

	
}
</style>
</head>
<body>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

	<div class="box">
		<form:form modelAttribute="user" method="POST"
			action="${pageContext.request.contextPath}/home/authenticate">
			<div class="form-group">
				<label class="col-form-label" for="unInput">Username</label> <input
					type="text" class="form-control" placeholder="Username"
					id="unInput"> <label class="col-form-label" for="pwInput">Password</label>
				<input type="text" class="form-control" placeholder="Password"
					id="pwInput">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>

	<%-- 	<form:form modelAttribute="user" method="POST"
		action="${pageContext.request.contextPath}/home/authenticate">
		<table class="framed">
			<tr>
				<td><spring:message code="fieldLabel.username" /></td>
				<td colspan="3"><form:input path="username" size="40" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.password" /></td>
				<td colspan="3"><form:password path="password" size="40" /></td>
			</tr>
			<tr>
				<td colspan="4">&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><form:button name="submit" type="submit" value="s">
					</form:button></td>
				<td><form:button name="clear" type="reset" value="r">
					</form:button></td>
			</tr>
		</table>
	</form:form> --%>


</body>
</html>