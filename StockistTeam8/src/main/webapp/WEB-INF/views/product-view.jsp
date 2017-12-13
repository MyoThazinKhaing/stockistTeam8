<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View product details</title>
</head>
<body>
	<h3>Product Details</h3>
	<table width='500' ; style="cellspacing: 2; cellpadding: 2; border: 1;">
		<tbody>
			<tr>
				<th><b>Part Number</th>
				<td align="right">${product.partNumber}</td>

			</tr>
			<tr>
				<th>Unit Price</th>
				<td align="right"><fmt:formatNumber value="${product.unitPrice}" pattern="$#,##0.00" /></td>
			</tr>
			<tr>
				<th>Description</th>
				<td align="right">${product.description}</td>
			</tr>
			<tr>
				<th>Manufacturer</th>
				<td align="right">${product.manufacturer}</td>
			</tr>
			<tr>
				<th>Supplier</th>
				<td align="right">${supplier.supplierName}</td>
			</tr>
			<tr>
				<th>Stock Level</th>
				<td align="right">${product.stock}</td>
			</tr>
			<tr>
				<th>Reorder Level</th>
				<td align="right">${product.reorderLevel}</td>
			</tr>
			<tr>
				<th>Minimum Reorder Quantity</th>
				<td align="right">${product.minimumReorderQuantity}</td>
			</tr>
		</tbody>
	</table>

	&nbsp;
	
	<input type="button"
		onclick="location.href='${pageContext.request.contextPath}/product/catalogue';"
		style="width: 20%; text-align: center; text-decoration: none;"
		value="<Back to product catalogue" />
	<input type="button"
		onclick="location.href='${pageContext.request.contextPath}/transactions/${product.partNumber}.html';"
		style="width: 20%; text-align: center; text-decoration: none;"
		value="View transaction history>" />


</body>
</html>