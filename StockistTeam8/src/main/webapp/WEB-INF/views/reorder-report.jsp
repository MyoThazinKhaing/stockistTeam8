<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<style>
.header {
	font-weight: bold;
}

.price {
	padding-right: 30 !important;
}
</style>
</head>
<body>
	<div style="margin-left: 10; margin-right: 30">
		<div style="margin-top: 20; margin-bottom: 30;">
			<h5>Select a supplier from list</h5>
			<form method="GET"
				action="${pageContext.request.contextPath}/reorder/search.html">
				<select name="supplierName" class="custom-select">
					<option selected="${supplierName}" />
					<c:forEach var="supplier" items="${slist}">
						<c:choose>
							<c:when test="${supplierName eq supplier.supplierName}">
								<option selected>
									<c:out value="${supplier.supplierName}" />
								</option>
							</c:when>
							<c:otherwise>
								<option>
									<c:out value="${supplier.supplierName}" />
								</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select> <input type="submit" value="Search" class="btn btn-primary" />
			</form>
		</div>
		<div style="margin-top: 20; margin-bottom: 30; text-align: center;">
			<h2>
				<u>Inventory Reorder Report for Supplier ${supplier.supplierId}</u>
			</h2>
		</div>
		<table class="table table-hover" style="font-size: 1.2em">
			<thead>
				<tr>
					<td class="header" >Part No.</td>
					<td align="right" class="header" style="padding: 12 24 12 0">Unit.Price
					</td>
					<td align="center" class="header">Quantity</td>
					<td align="center" class="header">Reorder.Qty</td>
					<td align="center" class="header">Min.Order.Qty</td>
					<td align="center" class="header">Order.Qty</td>
					<td align="right" class="header">Price</td>
				</tr>
			</thead>

			<c:forEach items="${reportTable}" var="orderRow">
				<tr>
					<td>${orderRow[0]}</td>
					<td align="right" style="padding: 12 24 12 0">$${orderRow[1]}</td>
					<td align="center">${orderRow[2]}</td>
					<td align="center">${orderRow[3]}</td>
					<td align="center">${orderRow[4]}</td>
					<td align="center">${orderRow[5]}</td>
					<td align="right">$${orderRow[6]}</td>
				</tr>
			</c:forEach>

			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td align="center"><strong>Total</strong></td>
				<td align="right">$${totalPrice}</td>
			</tr>


		</table>

	</div>


</body>