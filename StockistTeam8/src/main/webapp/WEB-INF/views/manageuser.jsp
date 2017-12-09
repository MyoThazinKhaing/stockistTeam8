<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3>User List page</h3>
<a href="${pageContext.request.contextPath}/admin/user/create">Add
	User</a>
<c:if test="${fn:length(userList) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<thead>
			<tr class="listHeading">
				<th><spring:message code="fieldLabel.username" /></th>
				<th><spring:message code="fieldLabel.password" /></th>
				<th><spring:message code="fieldLabel.role" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${userList}">
				<tr class="listRecord">
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.role}</td>
					<td align="center"><a
						href="${pageContext.request.contextPath}/admin/user/edit/${user.username}.html"><spring:message
								code="caption.edit" /></a></td>
					<td><a
						href="${pageContext.request.contextPath}/admin/user/delete/${user.username}.html"><spring:message
								code="caption.delete" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>