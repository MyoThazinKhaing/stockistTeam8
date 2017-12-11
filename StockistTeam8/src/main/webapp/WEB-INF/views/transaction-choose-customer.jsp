<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h3>Choose customer</h3>
<form:form method="POST" modelAttribute="customer"
	action="${pageContext.request.contextPath}/mechanic/choosecustomer.html">
	<form:select path="customerId">
		<form:option value="" label="...." />
		<form:options items="${custlist}" /> 
	</form:select>
	<%-- 				<td><form:errors path="managerId" cssStyle="color: red;" /></td> --%>
	<c:if test="${fn:length(custList) gt 0}">
		<table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<thead>
				<tr class="listHeading">
					<th><spring:message />Customer Id</th>
					<th><spring:message />Customer Name</th>
					<th><spring:message />Phone Number</th>
					<%-- code="fieldLabel.name" --%>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${custList}">
					<tr class="listRecord">
						<td>${customer.customerId}</td>
						<td>${customer.customerName}</td>
						<td>${customer.contactNumber}</td>
						<td><input type="submit" value="Create" /></td>
						<!-- 						<td align="center"><a -->
						<%-- 							href="${pageContext.request.contextPath}/mechanic/create.html"><spring:message --%>
						<%-- 									code="Select" /></a></td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</form:form>