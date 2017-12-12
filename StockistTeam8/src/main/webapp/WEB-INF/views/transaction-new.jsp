<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="STYLESHEET" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-ui.theme.css" />

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$("#datepicker1").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});
</script>
<h3>Choose Part Number</h3>
 <div align="left"><form:form method="POST" modelAttribute="transAndTransDetails"
	action="${pageContext.request.contextPath}/mechanic/createTrans.html">
	<%-- <c:set target="transAndTransDetails" property="transactionId" value="${transaction.transactionId}"/>  --%>
	
	<table><tr><td>Customer Name</td>
				<td> <form:select path="transaction.customerId">
						
						<form:option value="0" label="...." />
						<form:options items="${custlist}" />
</form:select></td> </tr>
	<tr><td>Date</td>
	<td>
	<form:input size="16" path="transaction.consumeDate" type="date"
					id="datepicker1" />
				<form:errors path="transaction.consumeDate" cssStyle="color: red;" />
	</td>
	</tr>
	
	<tr><td><input type="submit" value="Add Part Number" /></td></table>
	</form:form>
	
	</div>
	<div align="right">
	
	<form:form method="POST" modelAttribute="transAndTransDetails"
	action="${pageContext.request.contextPath}/mechanic/createTransDet.html">
	<table>
	<tr><td>Part Number</td>
	<td><form:input path="transactionDetails.partNumber" /></td>
				 </tr>
	<tr><td>Quantity</td>
	<td><form:input path="transactionDetails.quantity" /></td>
				<td><form:errors path="transactionDetails.quantity" cssStyle="color: red;" /></td>
	</tr>
	<tr><td><input type="submit" value="Create Record" /></td>
	</tr>
	</table>
</form:form>
</div>

<table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<tr class="listHeading">
				<th>TransactionID</th>
				<th>PartNumber</th>
				<th>Quantity</th>
			</tr>
<c:forEach var="transDet" items="${transactionDetails}">
				<tr class="listRecord">
					<td>${transDet.transactionId}</td>
					<td>${transDet.partNumber}</td>
					<td>${transDet.quantity}</td>
				</tr>
			</c:forEach>
		</table>