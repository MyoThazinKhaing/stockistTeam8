<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Change User Password Page</h3>

<form:form method="POST" commandName="user"
	action="${pageContext.request.contextPath}/changepw/${user.username}.html">

	<table>

		<tbody>
			<tr>
				<td><spring:message code="fieldLabel.username" /></td>
				<td><form:input path="username" readonly="true" /></td>
				<td><form:errors path="username" cssStyle="color: red;" /></td>
			</tr>
			<!-- 			<tr> -->
			<%-- 				<td><spring:message code="fieldLabel.username" /></td> --%>
			<%-- 				<td><form:input path="name" /></td> --%>
			<%-- 				<td><form:errors path="name" cssStyle="color: red;" /></td> --%>
			<!-- 			</tr> -->
			<tr>
				<td><spring:message code="fieldLabel.password" /></td>
				<td><form:input path="password" type="password" /></td>
				<td><form:errors path="password" /> <form:hidden path="role" />
					<form:hidden path="status" /></td>


			</tr>


			<tr>
				<td><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>


	</table>
	<c:choose>
		<c:when test="${message==null}"><div></div></c:when>
		<c:when test="${message==true}">
			<spring:message code="message.successUserPwChange"></spring:message>
		</c:when>
		<c:when test="${message==false}">
			<spring:message code="error.user.password.empty"></spring:message>
		</c:when>
		<c:otherwise>
			<div></div>
		</c:otherwise>
	</c:choose>

</form:form>
