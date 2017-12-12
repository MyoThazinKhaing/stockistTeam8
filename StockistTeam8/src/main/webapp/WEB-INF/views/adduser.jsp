<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<h3>Fill in the following to create a new user</h3>
<form:form method="POST" commandName="user"
	action="${pageContext.request.contextPath}/admin/user/create.html">
	<table>
		<tbody>
			<!-- 			<tr> -->
			<%-- 				<td><spring:message code="fieldLabel.userId" /></td> --%>
			<%-- 				<td><form:input path="userId" /></td> --%>
			<%-- 				<td><form:errors path="userId" cssStyle="color: red;" /></td> --%>
			<!-- 			</tr> -->
			<tr>
				<td><spring:message code="fieldLabel.username" /></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" required="required"
						cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.password" /></td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" required="required"
						cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.role" /></td>
				<td><form:select path="role" items="${eidlist}" /></td>
				<td><form:errors path="role" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table> 
	<c:if test="${message != error}">
		<div>
		<spring:message code="message.successUserCreate" />
		</div>

	</c:if>
</form:form>
