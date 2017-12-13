<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>

<head>
<style>
.editrow {
	margin: 20px 0px;
}

.label-field {
	text-align: right;
	padding-top: 5;
}
</style>

</head>
<body>
	<h3>New Product Page</h3>
	<form:form method="POST" modelAttribute="product"
		action="${pageContext.request.contextPath}/product/create.html">
		<div style="margin: 20px 0 0 0">
			<div class="row editrow">
				<div class="col-sm-3 label-field">Part Name</div>
				<div class="col-sm-5">
					<form:input path="partNumber" readonly="true" class="form-control" />
				</div>
				<div>
					<form:errors path="partNumber" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow">
				<div class="col-sm-3  label-field">Unit Price</div>
				<div class="col-sm-5">
					<form:input path="unitPrice" class="form-control" />
				</div>
				<div>
					<form:errors path="unitPrice" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow">
				<div class="col-sm-3 label-field">Description</div>
				<div class="col-sm-5">
					<form:input path="description" class="form-control" />
				</div>
				<div>
					<form:errors path="description" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow">
				<div class="col-sm-3 label-field">Colour</div>
				<div class="col-sm-5">
					<form:input path="colour" class="form-control" />
				</div>
				<div>
					<form:errors path="colour" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow">
				<div class="col-sm-3 label-field">Dimension</div>
				<div class="col-sm-5">
					<form:input path="dimension" class="form-control" />
				</div>
				<div>
					<form:errors path="dimension" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow label-field">
				<div class="col-sm-3">Manufacturer</div>
				<div class="col-sm-5">
					<form:input path="manufacturer" class="form-control" />
				</div>
				<div>
					<form:errors path="manufacturer" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow">
				<div class="col-sm-3 label-field">Supplier Id</div>
				<div class="col-sm-5">
					<form:select class="form-control" path="supplierId">
						<form:option value="" label="...." />
						<form:options items="${supplierList}" />
					</form:select>
				</div>
				<div>
					<form:errors path="supplierId" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow label-field">
				<div class="col-sm-3">Reorder Level</div>
				<div class="col-sm-5">
					<form:input path="reorderLevel" class="form-control" />
				</div>
				<div>
					<form:errors path="reorderLevel" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow label-field">
				<div class="col-sm-3">Minimum Reorder Quantity</div>
				<div class="col-sm-5">
					<form:input path="minimumReorderQuantity" class="form-control" />
				</div>
				<div>
					<form:errors path="minimumReorderQuantity" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow label-field">
				<div class="col-sm-3">Shelf Location</div>
				<div class="col-sm-5">
					<form:input path="shelfLocation" class="form-control" />
				</div>
				<div>
					<form:errors path="shelfLocation" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow label-field">
				<div class="col-sm-3 label-field">Stock</div>
				<div class="col-sm-5">
					<form:input path="stock" class="form-control" />
				</div>
				<div>
					<form:errors path="stock" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow">
				<div class="col-sm-3 label-field">Status</div>
				<div class="col-sm-5">
					<form:select class="form-control" path="status">
						<form:option value="Active" />
						<form:option value="InActive" />
					</form:select>
				</div>
				<div>
					<form:errors path="status" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow">
				<div class="col-sm-3 label-field"></div>
				<div class="col-sm-5">
					<input type="submit" value="Update" class="btn btn-primary" />
				</div>

			</div>
		</div>
	</form:form>
</body>
</html>
