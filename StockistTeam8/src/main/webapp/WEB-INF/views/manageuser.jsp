<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>User List page</h3>

<form:form method="POST"
	action="${pageContext.request.contextPath}/user/list">
	<div class="row" style="margin: 20px 0 0 0">
		<div class="col-sm-4">
			<div class="row">
				<div class="col-sm-2">
					<i class="fa fa-search fa-2x" aria-hidden="true"></i>
				</div>
				<div class="col-sm-10">
					<select class="form-control" name="criteria">
						<option value="partNumber">Role</option>
						<option value="description">Username</option>
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
<a href="${pageContext.request.contextPath}/user/create">Add User</a>
<c:if test="${fn:length(userList) gt 0}">
	<div style="padding: 30 30 30 0;">
		<table class="table table-hover" style="font-size: 1em">
			<thead>
				<tr>
					<th scope="col"><spring:message code="fieldLabel.username" /></th>
					<th scope="col"><spring:message code="fieldLabel.password" /></th>
					<th scope="col"><spring:message code="fieldLabel.role" /></th>
					<th scope="col"><spring:message code="fieldLabel.status" /></th>
					<th scope="col"></th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td>${user.username}</td>
						<td>${user.password}</td>
						<td>${user.role}</td>
						<td>
						<c:if test="${user.status=='inactive'}"><span style="color:red;">${user.status }</span></c:if>
						<c:if test="${user.status=='active'}"><span style="color:green;">${user.status }</span></c:if>
			
						</td>
						<td align="center"><a
							href="${pageContext.request.contextPath}/user/edit/${user.username}.html"><i
										class="fa fa-pencil fa-2x" aria-hidden="true"></i></a></td>
						<td><a
							href="${pageContext.request.contextPath}/user/delete/${user.username}.html"><i
										class="fa fa-trash-o fa-2x" aria-hidden="true"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div id="pagination">

			<c:url value="/user/list" var="prev">
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
						<c:url value="/user/list" var="url">
							<c:param name="page" value="${i.index}" />
						</c:url>
						<a href='<c:out value="${url}" />'>${i.index}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:url value="/user/list" var="next">
				<c:param name="page" value="${page + 1}" />
			</c:url>
			<c:if test="${page + 1 <= maxPages}">
				<a href='<c:out value="${next}" />' class="pn next">Next</a>
			</c:if>
		</div>
	</div>
</c:if>

<c:if test="${fn:length(userList) eq 0}">
	<p>No records found.</p>
</c:if>