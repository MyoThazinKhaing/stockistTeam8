<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>

<style>
.editrow {
	margin: 20px 0px;
}

.label-field {
	text-align: right;
	padding-top: 5;
}
</style>
</head>
<body>
	<h3>Fill in the following to create a new user</h3>

	<form:form method="POST" modelAttribute="user"
		action="${pageContext.request.contextPath}/user/create.html">
		<div style="margin: 20px 0 0 0">
			<div class="row editrow">
				<div class="col-sm-3 label-field">Username</div>
				<div class="col-sm-5">
					<form:input path="username" class="form-control" />
				</div>
				<div>
					<form:errors path="username" cssStyle="color: red;" />
				</div>
			</div>
			<div></div>
			<div class="row editrow">
				<div class="col-sm-3  label-field">Password</div>
				<div class="col-sm-5">
					<form:input path="password" type="password" class="form-control" />
				</div>
				<div>
					<form:errors path="password" cssStyle="color: red;" />
				</div>
			</div>
			<div></div>
			<div class="row editrow">
				<div class="col-sm-3 label-field">Role</div>
				<div class="col-sm-5">
					<form:select path="role" items="${eidlist}" class="form-control" />
				</div>
				<div>
					<form:errors path="role" cssStyle="color: red;" />
				</div>
			</div>
			<div></div>
			<div class="row editrow">
				<div class="col-sm-3 label-field">Status</div>
				<div class="col-sm-5">
					<form:select path="status" items="${statuslist}"
						class="form-control" />
				</div>
				<div>
					<form:errors path="status" cssStyle="color: red;" />
				</div>
			</div>
			<div></div>
			<div class="row editrow">
				<div class="col-sm-3 label-field"></div>
				<div class="col-sm-5">
					<input type="submit" value="Create" class="btn btn-primary" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="${pageContext.request.contextPath}/user/list.html"
						class="btn btn-danger"> Cancel </a>
				</div>
			</div>
			<div class="row editrow">
				<div class="col-sm-3 label-field"></div>
				<div class="col-sm-5">
					<c:choose>
						<c:when test="${message == null}">
							<div></div>
						</c:when>
						<c:when test="${message == true}">
							<span style="color: green"><spring:message
									code="message.successUserCreate" /></span>
						</c:when>
						<c:when test="${message == false}">
							<span style="color: red"><spring:message
									code="error.username.repeat" /></span>
						</c:when>
						<c:otherwise>
							<div></div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>

		</div>


	</form:form>
</body>