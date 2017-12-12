<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Suppliers List</title>
<style type="text/css">
</style>
</head>
<body>
	<h3>Supplier List</h3>
	<form:form method="POST" modelAttribute="supplier"
		action="${pageContext.request.contextPath}/admin/supplier/searchByName/${supplierName}.html">
		<div class="row" style="margin: 20px 0 0 0">

			<div class="col-sm-1">
				<span><i class="fa fa-search fa-2x" aria-hidden="true"></i></span>
			</div>
			<div class="col-sm-2" style="display: flex; justify-content: flex-end;  ">
				<label style="margin-bottom:0 !important; padding:5 0 !important;"> Search by Name</label>
			</div>
			<div class="col-sm-7" style="padding-left: 0;">

				<form:input class="form-control form-control" path="supplierName"
					onfocus="this.value='';" />
			</div>

			<div class="col-sm-2">
				<input type="submit" class="btn btn-primary" value="Search"
					style="font-size: 1em" />
			</div>


		</div>
	</form:form>
	<div style="margin: 20px 0 0 0">
		<a href="${pageContext.request.contextPath}/admin/supplier/create">Add
			Supplier</a>
	</div>
	
	<!-- Table starts here -->
	<div style="padding: 30 30 30 0; font-size:0.9em" >
		<c:if test="${fn:length(supplierList) gt 0}">
			<table class="table table-hover" style="font-size: 1em"
				id="supplierTable">
				<thead>
					<tr class="listHeading">
						<th scope="col">Supplier ID</th>
						<th scope="col">Supplier Name</th>
						<th scope="col">Supplier Address</th>
						<th scope="col">Supplier Country</th>
						<th scope="col">Supplier Contact Number</th>
						<th scope="col">Supplier Contact Name</th>
						<th scope="col">Supplier Website</th>
						<th scope="col">Supplier Status</th>
						<th scope="col"><spring:message code="caption.edit" /></th>
						<%-- <th><spring:message code="caption.delete" /></th> --%>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="supplier" items="${supplierList}">
						<tr class="table-light">
							<td>${supplier.supplierId}</td>
							<td>${supplier.supplierName}</td>
							<td>${supplier.address}</td>
							<td>${supplier.country}</td>
							<td>${supplier.contactNumber}</td>
							<td>${supplier.contactName}</td>
							<td>${supplier.website}</td>
							<td>${supplier.status}</td>

							<td><a
								href="${pageContext.request.contextPath}/admin/supplier/edit/${supplier.supplierId}.html"><i
									class="fa fa-pencil fa-2x" aria-hidden="true"></i></a></td>
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
	</div>
	
</body>