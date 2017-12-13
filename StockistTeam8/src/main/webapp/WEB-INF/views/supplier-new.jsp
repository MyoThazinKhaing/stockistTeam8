<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<h3>New Supplier page</h3>
	<form:form method="POST" modelAttribute="supplier"
		action="${pageContext.request.contextPath}/supplier/create.html">
		<div style="margin: 20px 0 0 0">
			<div class="row editrow">
				<div class="col-sm-3 label-field">Supplier Name</div>
				<div class="col-sm-5">
					<form:input path="supplierName" class="form-control" />
				</div>
				<div>
					<form:errors path="supplierName" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow">
				<div class="col-sm-3  label-field">Supplier Address</div>
				<div class="col-sm-5">
					<form:input path="address" class="form-control" />
				</div>
				<div>
					<form:errors path="address" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow">
				<div class="col-sm-3 label-field">Supplier Country</div>
				<div class="col-sm-5">
					<form:input path="country" class="form-control" />
				</div>
				<div>
					<form:errors path="country" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow">
				<div class="col-sm-3 label-field">Supplier Contact Number</div>
				<div class="col-sm-5">
					<form:input path="contactNumber" class="form-control" />
				</div>
				<div>
					<form:errors path="contactNumber" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow">
				<div class="col-sm-3 label-field">Supplier Contact Name</div>
				<div class="col-sm-5">
					<form:input path="contactName" class="form-control" />
				</div>
				<div>
					<form:errors path="contactName" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow label-field">
				<div class="col-sm-3  label-field">Supplier Website</div>
				<div class="col-sm-5">
					<form:input path="website" class="form-control" />
				</div>
				<div>
					<form:errors path="website" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow">
				<div class="col-sm-3 label-field">Supplier Status</div>
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
					<input type="submit" value="Create" class="btn btn-primary" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="${pageContext.request.contextPath}/supplier/list.html"
						class="btn btn-danger"> Cancel </a>
				</div>

			</div>

		</div>
		</div>
	</form:form>
</body>

