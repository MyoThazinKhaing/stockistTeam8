
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<table width="100%">
	<tr>
		<td class="supplierHeader">Supplier List page</td>

		<td class="supplierHeader"><form:form method="POST"
				modelAttribute="supplier"
				action="${pageContext.request.contextPath}/admin/supplier/searchByName/${supplierName}.html">

	Search By name
	<form:input path="supplierName" style="width: 300px;"
					onfocus="this.value='';" />

				<input type="submit" value="Search" class="blcass" />


			</form:form></td>
			@nbsp
		<td class="supplierHeader"><a
			href="${pageContext.request.contextPath}/admin/supplier/create">Add
				Supplier</a></td>
	</tr>
</table>
<div class="line"></div>



<c:if test="${fn:length(supplierList) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;"
		id="supplierTable">
		<thead>
			<tr class="listHeading">
				<th>Supplier ID</th>
				<th>Supplier Name</th>
				<th>Supplier Address</th>
				<th>Supplier Country</th>
				<th>Supplier Contact Number</th>
				<th>Supplier Contact Name</th>
				<th>Supplier Website</th>
				<th>Supplier Status</th>
				<th><spring:message code="caption.edit" /></th>
				<%-- <th><spring:message code="caption.delete" /></th> --%>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="supplier" items="${supplierList}">
				<tr class="listRecord">
					<td>${supplier.supplierId}</td>
					<td>${supplier.supplierName}</td>
					<td>${supplier.address}</td>
					<td>${supplier.country}</td>
					<td>${supplier.contactNumber}</td>
					<td>${supplier.contactName}</td>
					<td>${supplier.website}</td>
					<td>${supplier.status}</td>

					<td align="center"><a
						href="${pageContext.request.contextPath}/admin/supplier/edit/${supplier.supplierId}.html"><spring:message
								code="caption.edit" /></a></td>
					<%-- <td><a
						href="${pageContext.request.contextPath}/admin/supplier/delete/${supplier.supplierId}.html"><spring:message
								code="caption.delete" /></a></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="pagination">

		<c:url value="/admin/supplier/list" var="prev">
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
					<c:url value="/admin/supplier/list" var="url">
						<c:param name="page" value="${i.index}" />
					</c:url>
					<a href='<c:out value="${url}" />'>${i.index}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:url value="/admin/supplier/list" var="next">
			<c:param name="page" value="${page + 1}" />
		</c:url>
		<c:if test="${page + 1 <= maxPages}">
			<a href='<c:out value="${next}" />' class="pn next">Next</a>
		</c:if>
	</div>

</c:if>
