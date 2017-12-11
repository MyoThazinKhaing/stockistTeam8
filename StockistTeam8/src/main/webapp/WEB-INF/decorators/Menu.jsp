<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<style>
hr.style13 {
	height: 10px;
	border: 0;
	box-shadow: 0 10px 10px -10px #8c8b8b inset;
}

hr.style14 {
	border: 0;
	height: 1px;
	background-image: -webkit-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0);
	background-image: -moz-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0);
	background-image: -ms-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0);
	background-image: -o-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0);
}
a{
	font-size:1em;
}
</style>

</head>
<body>
	<div class="list-group">
		<spring:url value="/products/catalog" var="catalog" htmlEscape="true" />
		<a href="${catalog}" class="list-group-item list-group-item-action">
			Home </a>

		<div>
			<hr class="style14">
		</div>
		<c:if test="${sessionScope.USERSESSION.user.username != null}">
			<c:forEach var="role" items="${sessionScope.USERSESSION.user.role}">
				<c:choose>
					<c:when test="${role eq 'admin' }">
						<spring:url value="/admin/user/list" var="ulist" htmlEscape="true" />
						<a href="${ulist}"
							class="list-group-item list-group-item-action active"> <spring:message
								code="menu.admin.ulist" />
						</a>
						<spring:url value="/admin/role/list" var="rlist" htmlEscape="true" />
						<a href="${rlist}" class="list-group-item list-group-item-action">
							<spring:message code="menu.admin.rlist" />
						</a>
						<spring:url value="/admin/employee/list" var="elist"
							htmlEscape="true" />
						<a href="${elist}" class="list-group-item list-group-item-action">
							<spring:message code="menu.admin.elist" />
						</a>
						<spring:url value="/admin/department/list" var="dlist"
							htmlEscape="true" />
						<a href="${dlist}" class="list-group-item list-group-item-action">
							<spring:message code="menu.admin.dlist" />
						</a>
					</c:when>
					<c:when test="${role eq 'mechanic' }">
						<spring:url value="/manager/pending" var="pending"
							htmlEscape="true" />
						<a href="${pending}"
							class="list-group-item list-group-item-action"> <spring:message
								code="menu.coursesForApproval" />
						</a>
						<spring:url value="/manager/shistory" var="shistory"
							htmlEscape="true" />
						<a href="${shistory}"
							class="list-group-item list-group-item-action"> <spring:message
								code="menu.subordinateHistory" />
						</a>

					</c:when>

				</c:choose>

			</c:forEach>
		</c:if>
	</div>
</body>

