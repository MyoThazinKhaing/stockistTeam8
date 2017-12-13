<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Damage List Page</h3>
<div style="margin: 30px 30px 30px  0">
<c:set var="pList" scope="session" value="${plist}" />
<form:form method="POST" modelAttribute="damage" 
	action="${pageContext.request.contextPath}/damage/search.html">
<div class="row" style="margin: 20px 0 0 0">
			<div class="col-sm-2">
				Select a part number
			</div>
			<div class="col-sm-2">
						<form:select class="form-control" path="partNumber">
							<form:options items="${pList}" />
						</form:select>
			</div>

			<div class="col-sm-2">
				<input type="submit" class="btn btn-primary" value="Search"
					style="font-size: 1em" />
			</div>


		</div>
</form:form>
	
	<div>
		<a
			href="${pageContext.request.contextPath}/damage/list"><spring:message
					code="Display all damages" /></a>
	</div>

<div>
<a href="${pageContext.request.contextPath}/damage/create">New
	Damage Record</a></div>
<div class="row" style="margin: 20px 0 0 0">
<c:if test="${fn:length(damageList) gt 0}">
	<table class="table table-hover" style="font-size: 1em">
		<thead>
			<tr class="listHeading">
				<th scope="col">Damage Id</th>
				<th scope="col">Part Number</th>
				<th scope="col">Quantity</th>
				<th scope="col">Send Date</th>
				<th scope="col">Receive Date</th>
				<th scope="col">Status</th>
				<!-- <th>Received</th> -->
				<th scope="col">Edit</th>
				<th scope="col">Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="damage" items="${damageList}">
				<tr class="listRecord">
					<td>${damage.damageId}</td>
					<td>${damage.partNumber}</td>
					<td>${damage.quantity}</td>
					<td>${damage.sendDate}</td>
					<td>${damage.receiveDate}</td>
					<td>${damage.status}</td>
					
					<td align="center"><a
						href="${pageContext.request.contextPath}/damage/edit/${damage.damageId}.html"><i
										class="fa fa-pencil fa-2x" aria-hidden="true"></i></a></td>
					<td><a
						href="${pageContext.request.contextPath}/damage/delete/${damage.damageId}.html"><i
										class="fa fa-trash-o fa-2x" aria-hidden="true"></a></td>
					<td></td>
				</tr>
			</c:forEach>
	</table>
	<div id="pagination">

		<c:url value="/damage/list" var="prev">
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
					<c:url value="/damage/list" var="url">
						<c:param name="page" value="${i.index}" />
					</c:url>
					<a href='<c:out value="${url}" />'>${i.index}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:url value="/damage/list" var="next">
			<c:param name="page" value="${page + 1}" />
		</c:url>
		<c:if test="${page + 1 <= maxPages}">
			<a href='<c:out value="${next}" />' class="pn next">Next</a>
		</c:if>
	</div>
</c:if>
<br />
<br />
<table>
	<tr>
		<td align="center">${message}</td>
	</tr>
</table>
</div>
</div>