<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	$(document).ready(function() {
		$("#datepicker2").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});
	
	/* jQuery */$(document).ready(function(){
	    var counter = 1;
	    jQuery('a.add-author').click(function(event){
	        event.preventDefault();

	        var newRow = jQuery('<tr><td>${transactiondetails.partNumber}</td>' +
	            counter + '<td>${transactiondetails.quantity}</td>' +
	            counter + '</tr>');
	            counter++;
	        jQuery('table."transactiondetails"').append(newRow);

	    });
	});
</script>
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
						<form:option value="123" label="...." />
						<form:options items="${custlist}" />
					</form:select></td>
				<%-- 				<td><form:errors path="managerId" cssStyle="color: red;" /></td> --%>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.consumeDate" /></td>
							<td><form:input size="16" path="consumeDate" id="datepicker1" />
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
		<table class ="transactiondetails" style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.partNumber" /></th>
				<th><spring:message code="fieldLabel.quantity" /></th>
			</tr>
		</thead>
		<tbody>
<!-- 			<c:forEach var="transactiondetails"> -->
				<tr class="listRecord">
				<td><form:input path="userName" /></td>
				<td><form:input path="userName" /></td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/admin/employee/edit/${employee.employeeId}.html"><spring:message
								code="caption.edit" /></a></td>
					<td><a
						href="#"><spring:message
								code="caption.delete" /></a></td>
				</tr>
<!-- 			</c:forEach> -->
		</tbody>
	</table>
	<a href="#" title="" class="add-author">Add part number</a>

</form:form>