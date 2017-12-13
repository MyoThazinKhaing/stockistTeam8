<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Damage List Page</h3>
<a href="${pageContext.request.contextPath}/admin/damage/create">New
	Damage Record</a>
<form:form method="POST" modelAttribute="damage"
	action="${pageContext.request.contextPath}/admin/damage/search.html">
	<tr>
		<td>please select a part number</td>
		<td><form:select path="partNumber">

				<form:options items="${plist}" />
			</form:select></td>

		<td><input type="submit" value="Search" /></td>
		<td><a href="${pageContext.request.contextPath}/admin/damage/list"><spring:message
			code="Display all damages" /></a></td>
	</tr>
	
</form:form>

<c:if test="${fn:length(damageList) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
				<th>Damage Id</th>
				<th>Part Number</th>
				<th>Quantity</th>
				<th>Send Date</th>
				<th>Receive Date</th>
				<th>Status</th>
				<!-- <th>Received</th> -->
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="damage" items="${damageList}">
				<tr class="listRecord">
					<td>${damage.damageId}</td>
					<td>${damage.partNumber}</td>
					<td>${damage.quantity}</td>
					<td>${damage.sendDate}</td>
					<td>${damage.receiveDate}</td>
					<td>${damage.status}</td>
					<%-- <c:if test="${damage.status eq 'received'}">
						<td> </td>
					</c:if>
					<c:if test="${damage.status gt 'received'}">
						<td align="center"><a
							href="${pageContext.request.contextPath}/admin/damage/received/${damage.damageId}.html">Received</a></td>
					</c:if> --%>
					<td align="center"><a
						href="${pageContext.request.contextPath}/admin/damage/edit/${damage.damageId}.html">Edit</a></td>
					<td><a
						href="${pageContext.request.contextPath}/admin/damage/delete/${damage.damageId}.html">Delete</a></td>
					<td></td>
				</tr>
			</c:forEach>
	</table>
</c:if>
<br />
<br />
<table>
	<tr>
		<td align="center">${message}</td>
	</tr>
</table>