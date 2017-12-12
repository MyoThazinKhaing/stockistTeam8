<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>

<style>
.editrow{
	margin: 20px 0px;
}
.label-field{
text-align:right; 
padding-top:5;
}
</style>
</head>
<h3>User List page</h3>

<form:form method="POST"
	action="${pageContext.request.contextPath}/admin/user/list">
	<table class="framed">
		<tr>

			<td><img
				src="${pageContext.request.contextPath}/image/icon_search.gif"
				alt="" align="middle"></td>
			<td>
			<td><select name="criteria">
					<option value="role">Role</option>
					<option value="userName">Username</option>

			</select></td>
			<td colspan="3"><input type="text" name="description" size="40" /></td>

			<td rowspan="2"><input type="submit" value="Search" /></td>

		</tr>


	</table>
</form:form>
<a href="${pageContext.request.contextPath}/admin/user/create">Add
	User</a>
<c:if test="${fn:length(userList) gt 0}">
	<table class="table table-hover">
		<thead>
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.username" /></th>
				<th><spring:message code="fieldLabel.password" /></th>
				<th><spring:message code="fieldLabel.role" /></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
				<tr class="listRecord">
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.role}</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/admin/user/edit/${user.username}.html"><i
										class="fa fa-pencil fa-2x" aria-hidden="true"></i></a></td>
					<td><a
						href="${pageContext.request.contextPath}/admin/user/delete/${user.username}.html"><i
										class="fa fa-trash-o fa-2x" aria-hidden="true"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="pagination">
		<ul class="pagination">
		
		<c:url value="/admin/user/list" var="prev">
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
					<c:url value="/admin/user/list" var="url">
						<c:param name="page" value="${i.index}" />
					</c:url>
					<a href='<c:out value="${url}" />'>${i.index}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:url value="/admin/user/list" var="next">
			<c:param name="page" value="${page + 1}" />
		</c:url>
		<c:if test="${page + 1 <= maxPages}">
			<a href='<c:out value="${next}" />' class="pn next">Next</a>
		</c:if>
		</ul>
	</div>
</c:if>
<c:if test="${fn:length(userList) eq 0}">
			<p>No records found.</p>
		</c:if>