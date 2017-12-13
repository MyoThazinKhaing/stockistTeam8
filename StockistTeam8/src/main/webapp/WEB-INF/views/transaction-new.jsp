<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	<h3>New Transaction page</h3>
	<div style="margin: 30 30 30 0">
		<form:form method="POST" modelAttribute="transaction"
			action="${pageContext.request.contextPath}/transaction/create.html">

			<div class="row editrow">
				<div class="col-sm-4">
					<span>Customer Name</span> &nbsp;&nbsp;
					<form:select path="customerId" class="custom-select"
						items="${custlist}" />
				</div>
				<div class="col-sm-2"></div>
				<div class="col-sm-4">
					<span>Part Number</span> &nbsp;&nbsp; <select name="product"
						class="custom-select">
						<c:forEach items="${plist}" var="product">
							<option>${product.partNumber}</option>
						</c:forEach>
					</select>
				</div>
				<div class="col-sm-2"></div>
			</div>
			<div class="row editrow">
				<div class="col-sm-4">
					<span>Date</span>
					<form:input path="consumeDate" class="form-control" type="date"
						style="width:200px" />
				</div>
				<div class="col-sm-2"></div>
				<div class="col-sm-4">
					<span>Quantity</span><input name="quantity" type="number" min="1"
						class="form-control" required="required" style="width: 200px" />
				</div>
				<div class="col-sm-2"></div>
			</div>
			<div class="row editrow">
				<div class="col-sm-4">
					<input type="submit" class="btn btn-primary" value="Add"
						style="font-size: 1em" />
				</div>
			</div>
		</form:form>
	</div>

	<table class="table table-hover" style="font-size: 1em">
		<tr class="listHeading">
			<th scope="col">Transaction ID</th>
			<th scope="col">Part Number</th>
			<th scope="col">Quantity</th>

		</tr>
		<c:forEach var="trans" items="${transDetail}">
			<tr class="listRecord">
				<td>${trans.transactionId}</td>
				<td>${trans.partNumber}</td>
				<td>${trans.quantity}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>