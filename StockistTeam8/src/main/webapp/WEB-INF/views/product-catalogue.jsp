<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Catalogue</title>
</head>
<body>
	<h3>Product Catalogue</h3>

	<form:form method="POST"
		action="${pageContext.request.contextPath}/product/catalogue">
		<table class="framed">
			<tr>

				<td><img
					src="${pageContext.request.contextPath}/image/icon_search.gif"
					alt="" align="middle"></td>
				<td>
				<td><select name="criteria">
						<option value="partNumber">Part number</option>
						<option value="description">Description</option>
						<option value="colour">Colour</option>
						<option value="manufacturer">Manufacturer</option>
				</select></td>
				<td colspan="3"><input type="text" name="description" size="40" /></td>

				<td rowspan="2""><input type="submit" value="Search" /></td>

			</tr>


		</table>
	</form:form>
	<a href="${pageContext.request.contextPath}/product/catalogue"><spring:message
			code="Display all products" /></a>
	<form:form method="GET"
		action="${pageContext.request.contextPath}/product/catalogue">
		<a href="${pageContext.request.contextPath}/admin/product/create">Add
			Product</a>
		<c:if test="${fn:length(pList) gt 0}">
			<table width='600'
				; style="cellspacing: 2; cellpadding: 2; border: 1;">
				<thead>
					<tr class="listHeading">
						<th><spring:message code="Part Number" /></th>
						<th><spring:message code="Unit Price" /></th>
						<th><spring:message code="Description" /></th>
						<th><spring:message code="Colour" /></th>
						<th><spring:message code="Status" /></th>
						<th><spring:message code="caption.detail" /></th>
						<c:if test="${sessionScope.USERSESSION.user.role eq 'admin'}">
							<th><spring:message code="caption.edit" /></th>
						</c:if>
						<%-- This one is disable bcause Delete will be included in the edit function
						<th><spring:message code="caption.delete" /></th> --%>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${pList}">
						<tr class="listRecord">
							<td>${product.partNumber}</td>
							<td align=right style="padding-right: 1cm;">${product.unitPrice}</td>
							<td>${product.description}</td>
							<td>${product.colour}</td>
							<td>${product.status}</td>
							<td><a
								href="${pageContext.request.contextPath}/product/${product.partNumber}.html"><spring:message
										code="caption.detail" /></a></td>
							<c:if test="${sessionScope.USERSESSION.user.role eq 'admin'}">
								<td><a
									href="${pageContext.request.contextPath}/admin/product/edit/${product.partNumber}.html"><spring:message
											code="caption.edit" /></a></td>
							</c:if>
							<%-- This one is disable bcause Delete will be included in the edit function
							<td><a
								href="${pageContext.request.contextPath}/admin/product/delete/${product.partNumber}.html"><spring:message
										code="caption.delete" /></a></td> --%>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div id="pagination">

				<c:url value="/product/catalogue" var="prev">
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
							<c:url value="/product/catalogue" var="url">
								<c:param name="page" value="${i.index}" />
							</c:url>
							<a href='<c:out value="${url}" />'>${i.index}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:url value="/product/catalogue" var="next">
					<c:param name="page" value="${page + 1}" />
				</c:url>
				<c:if test="${page + 1 <= maxPages}">
					<a href='<c:out value="${next}" />' class="pn next">Next</a>
				</c:if>
			</div>
		</c:if>
		<c:if test="${fn:length(pList) eq 0}">
			<p>No records found.</p>
		</c:if>
	</form:form>
</body>
</html>