<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New Supplier page</h3>
<form:form method="POST" modelAttribute="supplier"
	action="${pageContext.request.contextPath}/admin/supplier/create.html">
	<table>
		<tbody>
			<tr>
				
				
				
			</tr>
			<tr>
				<td>Supplier Name</td>
				<td><form:input path="supplierName" style="width: 300px;"/></td>
				<td><form:errors path="supplierName" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Supplier Address</td>
				<td><form:input path="address" style="width: 300px;"/></td>
				<td><form:errors path="address" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Supplier Country</td>
				<td><form:input path="country" style="width: 300px;"/></td>
				<td><form:errors path="country" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Supplier Contact Number</td>
				<td><form:input path="contactNumber" style="width: 300px;"/></td>
				<td><form:errors path="contactNumber" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Supplier Contact Name</td>
				<td><form:input path="contactName" style="width: 300px;"/></td>
				<td><form:errors path="contactName" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Supplier Website</td>
				<td><form:input path="website" style="width: 300px;"/></td>
				<td><form:errors path="website" cssStyle="color: red;" /></td>
			</tr>
		
			<tr>
			<td></td>
				<td><input type="submit" value="Create" style="width: 100px;" class="blcass"/></td>
				<td></td>
				
			</tr>
		</tbody>
	</table>
</form:form>

