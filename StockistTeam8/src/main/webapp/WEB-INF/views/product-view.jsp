<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View product details</title>
<style>
.editrow {
	margin: 20px 0px;
}

.label-field {
	text-align: right;
	padding-top: 5;
}

.title{
	border-right:solid 1px;
	border-color: rgba(204, 198, 198, 0.4);
	max-width:70px
}

</style>



</head>
<body>
	<h3>Product Details</h3>
	<div style="width: 80%; padding: 30 30 30 0;">
	<table class="table table-hover" style="font-size: 1em;">
		<tbody>
			<tr>
				<th scope="col" class="title">Part Number</th>
				<td class="field">${product.partNumber}</td>

			</tr>
			<tr>
				<th scope="col" class="title">Unit Price</th>
				<td>${product.unitPrice}</td>
			</tr>
			<tr>
				<th scope="col" class="title">Description</th>
				<td>${product.description}</td>
			</tr>
			<tr>
				<th scope="col" class="title">Manufacturer</th>
				<td>${product.manufacturer}</td>
			</tr>
			<tr>
				<th scope="col" class="title">Supplier</th>
				<td>${supplier.supplierName}</td>
			</tr>
			<tr>
				<th scope="col" class="title">Stock Level</th>
				<td>${product.stock}</td>
			</tr>
			<tr>
				<th scope="col" class="title">Reorder Level</th>
				<td>${product.reorderLevel}</td>
			</tr>
			<tr>
				<th scope="col" class="title">Minimum Reorder Quantity</th>
				<td>${product.minimumReorderQuantity}</td>
			</tr>
		</tbody>
	</table>
	<div class="row">
		<div class="col-sm-6" >
			<input type="button" class="btn btn-primary"
				onclick="location.href='${pageContext.request.contextPath}/product/catalogue';"
				style="text-align: center; text-decoration: none;"
				value="< Back to product catalogue" />
		</div>
		<div align="right" class="col-sm-6" >
			<input type="button" class="btn btn-primary"
				onclick="location.href='${pageContext.request.contextPath}/transaction/list/${product.partNumber}.html';"
				style="text-align: center; text-decoration: none;"
				value="View transaction history >" />
		</div>
	</div>
</div>
</body>
</html>