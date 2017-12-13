<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$("#datepicker1").datepicker({
			dateFormat : "yy-mm-dd"
		});
	});
	$(document).ready(function() {
		$("#datepicker2").datepicker({
			dateFormat : "yy-mm-dd"
		});
	});
</script>

<h3>New Damage page</h3>
<form:form method="POST" modelAttribute="damage"
	action="${pageContext.request.contextPath}/admin/damage/create.html">
	<table>
		<tbody>
		   
			
			<tr>
				<td>Part Number</td>
				<td><form:select path="partNumber">
						
						<form:options items="${plist}" />
					</form:select></td>
					<td><form:errors path="partNumber" cssStyle="color: red;" /></td>
				
			</tr>
			<tr>
				<td>Quantity</td>
				<td><form:input path="quantity"/></td>
				<td><form:errors path="quantity" cssStyle="color: red;" /></td></tr>
				
			 <tr>
				<td>Send Date</td>
				<td><form:input size="16" path="sendDate" id="datepicker1" /></td>
				<td><form:errors path="sendDate" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Receive Date</td>
				<td><form:input size="16" path="receiveDate" id="datepicker2" /></td>
				<td><form:errors path="receiveDate" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>Status</td>
				<td><form:select path="status">
						
						<form:options items="${slist}" />
					</form:select></td>

				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create" /></td>
				<td> <a href="${pageContext.request.contextPath}/admin/damage/list.html"> cancel
			</a></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>



