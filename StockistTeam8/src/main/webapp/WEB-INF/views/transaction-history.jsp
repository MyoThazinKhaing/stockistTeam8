<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>

	<h3>Transaction History</h3>
	<c:if test="${fn:length(transDetailList) gt 0}">
<div style="padding: 30 30 30 0;">
		<table class="table table-hover" style="font-size: 1em">

			<tr class="listHeading">
				<th scope="col"><spring:message code="TransactionId" /></th>
				<th scope="col"><spring:message code="PartNumber" /></th>
				<th scope="col"><spring:message code="Quantity" /></th>
				<th scope="col"><spring:message code="Customer Name" /></th>
				<th scope="col"><spring:message code="Transaction Date" /></th>
				<th scope="col"><spring:message code="User" /></th>

				<c:forEach var="transDetailList" items="${transDetailList}">
					<tr class="listRecord">
						<td align="left">${transDetailList.transactionId}</td>
						<td align="left">${transDetailList.partNumber}</td>
						<td align="left">${transDetailList.quantity}</td>
						<c:forEach var="transList" items="${transList}">
							<c:if
								test="${transDetailList.transactionId eq transList.transactionId }">
								<c:forEach var="custList" items="${custList}">
									<c:if test="${custList.customerId eq transList.customerId }">
										<td align="left">${custList.customerName}</td>
									</c:if>
								</c:forEach>

								<td align="left"><fmt:formatDate
										value="${transList.consumeDate}" pattern="d MMMM yyyy" /></td>
								<td align="left">${transList.userName}</td>
							</c:if>
						</c:forEach>
					</tr>
				</c:forEach>
		</table>
		</div>
	</c:if>
	<c:if test="${fn:length(transDetailList) eq 0}">
		<p>No records found.</p>
	</c:if>
	<input type="button" class="btn btn-primary"
		onclick="location.href='${pageContext.request.contextPath}/product/catalogue';"
		style="width: 20%; text-align: center; text-decoration: none;"
		value="< Back to product catalogue" />
</body>
</html>

