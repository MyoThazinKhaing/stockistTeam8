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

.list-group-item-action{
	text-align:center;
	font-weight: bold;
	font-size: 1.25em;
}

</style>

</head>
<body>
	<div class="list-group">
		<spring:url value="/login" var="home" htmlEscape="true" />
		<a href="${home}" class="list-group-item list-group-item-action">
			<spring:message code="menu.home" /> </a>

		<div>
			<hr class="style14">
		</div>
		<c:if test="${sessionScope.USERSESSION.user.username != null}">
			<c:forEach var="role" items="${sessionScope.USERSESSION.user.role}">
				<c:choose>
					<c:when test="${role eq 'admin'}">
						<%-- <c:if test="${requestScope['javax.servlet.forward.request_uri'] eq ulist}"></c:if> --%>
						<spring:url value="/product/catalogue" var="ulist" htmlEscape="true" />
						<a href="${ulist}"
							class="list-group-item list-group-item-action"><spring:message code="menu.browseCatalog" />
						</a>
						<spring:url value="/transaction/list" var="rlist" htmlEscape="true" />
						<a href="${rlist}" class="list-group-item list-group-item-action">
							<spring:message code="menu.browseTransaction" />
						</a>
						<spring:url value="/user/list" var="elist"
							htmlEscape="true" />
						<a href="${elist}" class="list-group-item list-group-item-action">
							<spring:message code="menu.manageUser" />
						</a>
						<spring:url value="/supplier/list" var="dlist"
							htmlEscape="true" />
						<a href="${dlist}" class="list-group-item list-group-item-action">
							<spring:message code="menu.browseSupplier" />
						</a>
						<spring:url value="/reorder/list" var="dlist"
							htmlEscape="true" />
						<a href="${dlist}" class="list-group-item list-group-item-action">
							<spring:message code="menu.ReorderReport" />
						</a>
					</c:when>
					<c:when test="${role eq 'mechanic' }">
						<spring:url value="/product/catalogue" var="ulist" htmlEscape="true" />
						<a href="${ulist}"
							class="list-group-item list-group-item-action"><spring:message code="menu.browseCatalog" />
						</a>
						<spring:url value="/transaction/list" var="rlist" htmlEscape="true" />
						<a href="${rlist}" class="list-group-item list-group-item-action">
							<spring:message code="menu.browseTransaction" />
						</a>
					</c:when>

				</c:choose>

			</c:forEach>
		</c:if>
	</div>
</body>

