<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit User page</h3>

<form:form method="POST" modelAttribute="user"
	action="${pageContext.request.contextPath}/admin/user/edit/${user.username}.html">
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
				<td><form:input path="password" /></td>
				<td><form:errors path="password" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.role" /></td>
				<td><form:select path="role" items="${eidlist}" /></td>
				<td><form:errors path="role" cssStyle="color: red;" /></td>
			</tr>
		
			<tr>
				<td><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>
