<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>

	<h3>Transaction History</h3>

	<table style="cellspacing: 2; cellpadding: 2; border: 1;">

		<tr class="listHeading">
			<th><spring:message code="TransactionId" /></th>
			<th><spring:message code="PartNumber" /></th>
			<th><spring:message code="Quantity" /></th>
			<th><spring:message code="Customer Name" /></th>
			<th><spring:message code="Transaction Date" /></th>
			<th><spring:message code="User" /></th>

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
							
							<td align="left"><fmt:formatDate value="${transList.consumeDate}" pattern="d MMMM yyyy" /></td>
							<td align="left">${transList.userName}</td>
						</c:if>
					</c:forEach>
				</tr>
			</c:forEach>
	</table>
</body>
</html>

