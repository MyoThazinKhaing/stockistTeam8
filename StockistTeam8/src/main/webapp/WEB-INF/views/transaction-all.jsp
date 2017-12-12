<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>

	<h3>Transaction History</h3>
	<div style="padding: 30 30 30 0;">
		<c:set var="transDetailsList" value="${transDetailList}" />
		<c:if test="${fn:length(transDetailsList) gt 0}">
			<table class="table table-hover" style="font-size: 1em">

				<thead>
					<tr>
						<th scope="col"><spring:message code="TransactionId" /></th>
						<th scope="col"><spring:message code="PartNumber" /></th>
						<th scope="col"><spring:message code="Quantity" /></th>
						<th scope="col"><spring:message code="Customer Name" /></th>
						<th scope="col"><spring:message code="Transaction Date" /></th>
						<th scope="col"><spring:message code="User" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="transDetailList" items="${transDetailList}">
						<tr class="table-light">
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
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>

