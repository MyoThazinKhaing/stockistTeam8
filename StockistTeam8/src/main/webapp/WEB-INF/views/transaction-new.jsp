<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h3>New Transaction page</h3>
<form:form method="POST" modelAttribute="transaction"
	action="${pageContext.request.contextPath}/mechanic/create.html">
	<table>
		<tbody>
			<tr>
				<td><spring:message code="fieldLabel.transactionId" /></td>
				<td><form:input path="transactionId" /></td>
				<%-- 				<td><form:errors path="employeeId" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.customerId" /></td>
				<td><form:select path="customerId">
						<form:option value="" label="...." />
						<form:options items="${customerchosen}" />
					</form:select></td>
				<%-- 				<td><form:errors path="managerId" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.consumeDate" /></td>
				<td><form:select path="consumeDate">
						<form:option value="" label="...." />
						<form:options items="${eidlist}" />
					</form:select></td>
				<%-- 				<td><form:errors path="managerId" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.username" /></td>
				<td><form:select path="userName">
						<form:option value="" label="...." />
						<form:options items="${eidlist}" />
					</form:select></td>
				<%-- 				<td><form:errors path="name" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>