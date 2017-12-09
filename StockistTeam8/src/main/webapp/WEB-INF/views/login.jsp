<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
	<%-- <spring:url value="/css/simple.css" var="style"/>
	<link rel="STYLESHEET" type="text/css"
		href="${style}" /> --%>
</head>
<body>
<form:form modelAttribute="user" method="POST" action="${pageContext.request.contextPath}/home/authenticate" >
	<table class="framed" >
		<tr>
			<td>
			<spring:message code="fieldLabel.username" /></td>
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
			<td>
			<form:button name="submit" type="submit" value="s">
				</form:button></td>
			<td>
			<form:button name="clear" type="reset" value="r">
				</form:button>
				</td>
		</tr>
	</table>
</form:form>
</body>
</html>