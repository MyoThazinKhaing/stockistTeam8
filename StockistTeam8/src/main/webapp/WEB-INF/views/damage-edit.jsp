<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<style>
.editrow {
	margin: 20px 0px;
}

.label-field {
	text-align: right;
	padding-top: 5;
}
</style>

<h3>Edit Damage page</h3>
<div style="margin: 30px 30px 30px 0">
	<form:form method="POST" modelAttribute="damage"
		action="${pageContext.request.contextPath}/damage/edit/${damage.damageId}.html">

		<div class="row editrow">
			<div class="col-sm-3 label-field">Part Number</div>
			<div class="col-sm-5">
				<form:input path="partNumber" readonly="true" class="form-control" />
			</div>
		</div>
		<div class="row editrow">
			<div class="col-sm-3  label-field">Unit Price</div>
			<div class="col-sm-5">
				<form:input path="quantity" readonly="true" class="form-control" />
			</div>
		</div>
		<div class="row editrow">
			<div class="col-sm-3 label-field">Send Date</div>
			<div class="col-sm-5">
				<form:input path="sendDate" readonly="true" class="form-control" />
			</div>
		</div>
		<div class="row editrow">
			<div class="col-sm-3 label-field">Receive Date</div>
			<div class="col-sm-5">
				<form:input path="receiveDate" class="form-control" type="date" />
			</div>
			<div>
				<form:errors path="receiveDate" cssStyle="color: red;" />
			</div>
		</div>
		<div class="row editrow">
			<div class="col-sm-3 label-field"></div>
			<div class="col-sm-5">
				<input type="submit" value="Update" class="btn btn-primary" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/damage/list.html"
					class="btn btn-danger"> Cancel </a>
			</div>

		</div>
		<form:hidden path="damageId" />
		<form:hidden path="status" />

	</form:form>
</div>