<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3>User List page</h3>

<div></div>
<a href="${pageContext.request.contextPath}/admin/user/create">Add
	User</a>
<div></div>

<c:if test="${fn:length(userList) gt 0}">
	<table class="table table-light">
		<thead>
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.username" /></th>
				<th><spring:message code="fieldLabel.password" /></th>
				<th><spring:message code="fieldLabel.role" /></th>
				<th><spring:message code="fieldLabel.status" /></th>
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
					<td>${user.status}</td> 
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
</c:if>