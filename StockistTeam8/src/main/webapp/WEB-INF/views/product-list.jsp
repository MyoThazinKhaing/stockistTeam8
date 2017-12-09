
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<h3>Employee List page</h3>

  <a href="${pageContext.request.contextPath}/admin/product/create">Add
	Product</a>
	<c:if test="${fn:length(plist) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			  <tr class="listHeading">
				<th><spring:message code="fieldLabel.partNumber" /></th>
				<th><spring:message code="fieldLabel.unitPrice" /></th>
				<th><spring:message code="fieldLabel.colour" /></th>
				<th><spring:message code="fieldLabel.dimension" /></th>
				<th><spring:message code="fieldLabel.manufacturer" /></th>
				<th><spring:message code="fieldLabel.supplierId" /></th>
				<th><spring:message code="fieldLabel.reorderLevel" /></th>
				<th><spring:message code="fieldLabel.stock" /></th>
				
				<th><spring:message code="caption.edit" /></th>
				<th><spring:message code="caption.delete" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${plist}">
				<tr class="listRecord">
					<td>${product.partNumber}</td>
					<td>${product.unitPrice}</td>
					<td>${product.colour}</td>
					<td>${product.dimension}</td>
					<td>${product.manufacturer}</td>
					<td>${product.supplierId}</td>
					<td>${product.reorderLevel}</td>
					<td>${product.stock}</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/admin/product/edit/${product.partNumber}.html"><spring:message
								code="caption.edit" /></a></td>
					<td><a
						href="${pageContext.request.contextPath}/admin/product/delete/${product.partNumber}.html"><spring:message
								code="caption.delete" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
