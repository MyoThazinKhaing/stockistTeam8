<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

</head>
<body>

	<h3>Inventory Report</h3>
	<form:form method="POST" modelAttribute="supplier"
		action="${pageContext.request.contextPath}/reorder/search.html">

		<form:select path="supplierId">
			<form:options items="${slist}" />
		</form:select>
		<input type="submit" value="Search" />
	</form:form>

	<%-- <h3>Inventory Reorder Report for supplier ${plist.supplierId}</h3> --%>

	<c:set var="total" scope="session" value="0" />
	<div style="padding: 30 30 30 0;">
	<table class="table table-hover" style="font-size: 1em">
		<tr class="listHeading">
			<th scope="col">Part No.</th>
			<td scope="col" align="right" style="padding: 12 35 12 12;"><strong>Unit.Price</strong></th>
			<th scope="col">Qty.</th>
			<th scope="col">Reorder Level</th>
			<th scope="col">Min.Ord.Qty.</th>
			<th scope="col">Ord.Qty.</th>
			<td scope="col" align="right" style="padding: 12 35 12 12;"><strong>Price</strong></th>
		</tr>
		<c:forEach var="product" items="${plist}">
			<tr class="listRecord">
				<td>${product.partNumber}</td>
				<td align="right" scope="col" style="padding: 12 35 12 12 ">$<fmt:formatNumber
						value="${product.unitPrice}" type="number" pattern="#,##0.00" /></td>
				<td>${product.stock}</td>
				<td>${product.reorderLevel}</td>
				<td>${product.minimumReorderQuantity}</td>

				<c:set var="quantity" scope="session" value="${product.stock}" />
				<c:set var="reorderQuantity" scope="session"
					value="${product.reorderLevel}" />
				<c:set var="minreorderQuantity" scope="session"
					value="${product.minimumReorderQuantity}" />
				<c:choose>
					<c:when test='${product.reorderLevel gt quantity}'>

						<c:set var="minusVal" scope="session"
							value="${product.reorderLevel-quantity}" />
						<c:choose>
							<c:when test='${product.minimumReorderQuantity gt minusVal}'>
								<td><c:set var="price" scope="session"
										value="${product.minimumReorderQuantity}" />
									${product.minimumReorderQuantity}</td>
							</c:when>
							<c:otherwise>
								<c:set var="price" scope="session" value="${minusVal}" />
								<td>${price}</td>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<td><c:set var="price" scope="session" value="0" /> <c:out
								value="0" /></td>
					</c:otherwise>
				</c:choose>
				<%--        <fmt:parseNumber var = "i" type = "number" value = "${price}" /> --%>
				<c:set var="total" scope="session"
					value="${(product.unitPrice*price)+total}" />
				<td align="right" style="padding: 12 35 12 12 ">$<fmt:formatNumber
						value="${(product.unitPrice*price)+total}" type="number"
						pattern="#,##0.00" /></td>

			</tr>


		</c:forEach>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td><strong>Total</strong></td>
			<td align="right" style="padding: 12 35 12 12 ">$<fmt:formatNumber
					value="${(product.unitPrice*price)+total}" type="number"
					pattern="#,##0.00" /></td>
		</tr>
	</table>
</div>


</body>