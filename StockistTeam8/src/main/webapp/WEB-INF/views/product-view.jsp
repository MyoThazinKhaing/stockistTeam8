<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View product details</title>
</head>
<body>
	<h3>Product Catalogue</h3>
	<table width='500' id="sig" cellspacing='0' cellpadding='0'
		border-spacing='0' style="margin: 0; padding: 0;">
		<tbody>
			<tr>
				<th><b>Part Number</th>
				<td>${product.partNumber}</td>

			</tr>
			<tr>
				<th>Unit Price</th>
				<td>${product.unitPrice}</td>
			</tr>
			<tr>
				<th>Description</th>
				<td>${product.description}</td>
			</tr>
			<tr>
				<th>Manufacturer</th>
				<td>${product.manufacturer}</td>
			</tr>
			<tr>
				<th>Supplier</th>
				<td>${product.supplierId}</td>
			</tr>
			<tr>
				<th>Stock Level</th>
				<td>${product.stock}</td>
			</tr>
			<tr>
				<th>Reorder Level</th>
				<td>${product.reorderLevel}</td>
			</tr>
			<tr>
				<th>Minimum Reorder Quantity</th>
				<td>${product.minimumReorderQuantity}</td>
			</tr>
		</tbody>
	</table>
	
	&nbsp;
	<input type="button"
		onclick="location.href='${pageContext.request.contextPath}/product/transaction-history/${product.partNumber}.html';"
		style="width:15%; background-color: #4CAF50; /* Green */ border: none; color: white; padding: 5px 5px; text-align: center; text-decoration: none; display: inline-block;"
		value="View Transaction History" />
</body>
</html>