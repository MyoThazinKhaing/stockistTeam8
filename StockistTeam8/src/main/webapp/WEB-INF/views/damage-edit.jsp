<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$("#datepicker1").datepicker({
			dateFormat : "yy-mm-dd"
		});
	});
	
</script>

<h3>Edit Damage page</h3>
<form:form method="POST" modelAttribute="damage"
	action="${pageContext.request.contextPath}/admin/damage/edit/${damage.damageId}.html">
	<form:hidden path="damageId" />
	<form:hidden path="partNumber" />
	<form:hidden path="quantity" />
<table>
		<tbody>
		   
			
			
			<tr>
				<td>Send Date</td>
				<td><form:input path="sendDate"  readonly="true"/>
				
				</td>
				
			</tr>
			
			<tr>
				<td>Receive Date</td>
				<td><form:input size="16" path="receiveDate" id="datepicker1" /></td>
				<td><form:errors cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>Status</td>
				
				<td><form:select path="status">
						
						<form:options items="${slist}" />
					</form:select></td>
				
				<td></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
			</tbody>
			</table>
			</form:form>
