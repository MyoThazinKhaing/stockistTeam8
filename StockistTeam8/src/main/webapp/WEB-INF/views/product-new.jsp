<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<h3>New Product Page</h3>
<form:form method="POST" modelAttribute="product"
	action="${pageContext.request.contextPath}/product/create.html">
	<table>
		<tbody>
			<tr>
				<td>PartNumber"</td>
				<td><form:input path="partNumber" /></td>
				<td><form:errors path="partNumber" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>UnitPrice:$</td>
				<td><form:input path="unitPrice" /></td>
				<td><form:errors path="unitPrice" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>Description</td>
				<td><form:input path="description"  /></td>
				<td><form:errors path="description" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>colour</td>
				<td><form:input path="colour" /></td>
				<td><form:errors path="colour" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>Dimension</td>
				<td><form:input path="dimension" /></td>
				<td><form:errors path="dimension" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>Manufacturer</td>
				<td><form:input path="manufacturer" /></td>
				<td><form:errors path="manufacturer" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				 <td>SupplierId</td>
				 <td><form:select path="supplierId">
						
						<form:option value="" label="...." />
						<form:options items="${supplierList}" />
					</form:select></td>
				<td><form:errors path="supplierId" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>ReorderLevel</td>
				<td><form:input path="reorderLevel" /></td>
				<td><form:errors path="reorderLevel" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>MinimumReorderQuantity</td>
				<td><form:input path="minimumReorderQuantity" /></td>
				<td><form:errors path="minimumReorderQuantity" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>ShelfLocation</td>
				<td><form:input path="shelfLocation" /></td>
				<td><form:errors path="shelfLocation" cssStyle="color: red;" /></td>
			</tr>
			
			<tr>
				<td>Stock</td>
				<td><form:input path="stock" /></td>
				<td><form:errors path="stock" cssStyle="color: red;" /></td>
			</tr>
			<tr>
			<td>Status</td>
				<td><form:select path="status">						
						<%-- <form:option value="" label="...." /> --%>
						<form:option value="Active"/>
						<form:option value="InActive"/>
						
					</form:select></td>
						
				<td><form:errors path="status" cssStyle="color: red;" /></td>
				</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>
</html>
