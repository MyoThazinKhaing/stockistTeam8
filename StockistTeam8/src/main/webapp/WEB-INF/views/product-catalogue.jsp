<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Catalogue</title>
</head>
<body>
	<h3>Product Catalogue</h3>

	<form:form modelAttribute="product" method="POST"
		action="${pageContext.request.contextPath}/product/search">
		<div class="row" style="margin: 20px 0 0 0">
			<div class="col-sm-4">
				<div class="row">
					<div class="col-sm-2">
						<i class="fa fa-search fa-2x" aria-hidden="true"></i>
					</div>
					<div class="col-sm-10">
						<select class="form-control" name="criteria">
							<option value="partNumber">Part number</option>
							<option value="description">Description</option>
							<option value="colour">Colour</option>
							<option value="manufacturer">Manufacturer</option>
						</select>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<input class="form-control form-control" type="text"
					name="description" />
			</div>

			<div class="col-sm-2">
				<input type="submit" class="btn btn-primary" value="Search"
					style="font-size: 1em" />
			</div>


		</div>
	</form:form>

	<div>
		<a href="${pageContext.request.contextPath}/product/catalogue"><spring:message
				code="Display all products" /></a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/product/create">Add
			Product</a>
	</div>
	<form:form method="GET"
		action="${pageContext.request.contextPath}/product/catalogue">
		<div style="padding: 30 30 30 0;">
			<c:if test="${fn:length(pList) gt 0}">
				<table class="table table-hover" style="font-size: 1em">
					<thead>
						<tr>
							<th scope="col"><spring:message code="Part Number" /></th>
							<th scope="col"><spring:message code="Description" /></th>
							<th style="min-width: 300px"></th>
							<th scope="col"><spring:message code="Colour" /></th>
							<td align="right"><strong><spring:message
										code="Unit Price" /></strong></td>
							<th scope="col"><spring:message code="caption.detail" /></th>
							<c:if test="${sessionScope.USERSESSION.user.role eq 'admin'}">
								<th scope="col"><spring:message code="caption.edit" /></th>
							</c:if>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" items="${pList}">
							<tr>
								<td>${product.partNumber}</td>
								<td colspan=2>${product.description}</td>
								<td>${product.colour}</td>
								<td align="right">$<fmt:formatNumber
										value="${product.unitPrice}" type="number" pattern="#,##0.00" /></td>

								<td><a
									href="${pageContext.request.contextPath}/product/${product.partNumber}.html"><i
										class="fa fa-list-alt fa-2x" aria-hidden="true"></i></a></td>
								<c:if test="${sessionScope.USERSESSION.user.role eq 'admin'}">
									<td><a
										href="${pageContext.request.contextPath}/product/edit/${product.partNumber}.html"><i
											class="fa fa-pencil fa-2x" aria-hidden="true"></i></a></td>
								</c:if>
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
		</div>
		<c:if test="${fn:length(pList) eq 0}">
			<p>No records found.</p>
		</c:if>
	</form:form>
</body>
</html>