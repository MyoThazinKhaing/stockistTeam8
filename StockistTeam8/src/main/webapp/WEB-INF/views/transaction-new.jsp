<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Make new transaction</h3>
	<form:form method="POST" modelAttribute="combinedTransaction"
		action="${pageContext.request.contextPath}/transactions/new">
		<table>
		<tr>
		<td><spring:message code="fieldLabel.transactions.customerId"/></td>
		<td><form:input path=" size="40" path="transactions.customerId"/></td>
		</tr>
		<tr>
		<td><spring:message code="fieldLabel.transactionsDetails.partNumber"/></td>
		<td><form:input path=" size="40" path="transactionsDetails.partNumber"/></td>
		</tr>
		<tr>
		<td><spring:message code="fieldLabel.transactionsDetails.quantity"/></td>
		<td><form:input path=" size="40" path="transactionsDetails.quantity"/></td>
		</tr>
		<tr>
		<td>&nbsp;</td>
		<td><form:button type="submit"/></td>
		</tr>
		</table>
		

	</form:form>
</body>
</html>