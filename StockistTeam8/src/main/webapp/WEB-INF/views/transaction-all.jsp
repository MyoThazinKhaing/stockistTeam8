<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body>

	<h3>Transaction History</h3>
	
	<a href="${pageContext.request.contextPath}/transaction/create">Add
				Transaction</a>
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
			<div id="pagination">

		<c:url value="/transaction/list" var="prev">
			<c:param name="page" value="${page-1}" />
		</c:url>
		<c:if test="${page > 1}">
			<a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
		</c:if>

		<c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
			<c:choose>
				<c:when test="${page == i.index}">
					<span>${i.index}</span>
				</c:when>
				<c:otherwise>
					<c:url value="/transaction/list" var="url">
						<c:param name="page" value="${i.index}" />
					</c:url>
					<a href='<c:out value="${url}" />'>${i.index}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:url value="/transaction/list" var="next">
			<c:param name="page" value="${page + 1}" />
		</c:url>
		<c:if test="${page + 1 <= maxPages}">
			<a href='<c:out value="${next}" />' class="pn next">Next</a>
		</c:if>
	</div>
		</c:if>
	</div>
</body>
</html>

