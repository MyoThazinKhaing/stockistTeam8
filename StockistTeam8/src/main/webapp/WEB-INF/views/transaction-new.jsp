<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html><head><title></title>
<link rel="STYLESHEET" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-ui.theme.css" />

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script>
	 $(document).ready(function() {
		$("#fuck").datepicker({
			dateFormat : "dd/mm/yy"
		});
	}); 
	</script>
</head>

<h3>New Transaction page</h3>
<form:form method="POST" modelAttribute="transaction"
	action="${pageContext.request.contextPath}/mechanic/create.html">

	<table>
		<tbody>
			<tr>
				<td>Customer Name</td>
				<td><form:select path="customerId">
						<%-- <form:option value="123" label="...." /> --%>
						<form:options items="${custlist}" />
					</form:select></td><td></td><td></td>
				<%-- 				<td><form:errors path="managerId" cssStyle="color: red;" /></td> --%>
			<td>PartNumber</td>
			<td><select name="product">
          <c:forEach items="${plist}" var="product">
      <option>${product.partNumber}</option>
    </c:forEach>
      </select></td>
      
      <tr>
		<td>Date</td>	
       <td><form:input type="date" size="16" path="consumeDate" id="fuck" />
       <form:errors path="consumeDate" cssStyle="color: red;" /><td></td><td></td><td></td>

	
			<!-- non spring tag. its normal html tag -->
			
			<td>Quantity</td>
			<td><input name="quantity" type="text"/></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>

	</form:form>
 <table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<tr class="listHeading">
				<th>Transaction ID</th>
				<th>Part Number</th>
				<th>Quantity</th>
				
			</tr>
			<c:forEach var="trans" items="${transDetail}">
				<tr class="listRecord">
					<td>${trans.transactionId}</td> 
						<td>${trans.partNumber}</td> 
					<td>${trans.quantity}</td>
				</tr>
			</c:forEach>
		</table>
 </html>