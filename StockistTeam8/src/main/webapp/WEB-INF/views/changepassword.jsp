<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Change User Password Page</h3>
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
	<h3>Change Password</h3>
	<form:form method="POST" commandName="user"
		action="${pageContext.request.contextPath}/changepw/${user.username}.html">

		<div style="margin: 20px 0 0 0">
			<div class="row editrow">
				<div class="col-sm-3 label-field">
					<spring:message code="fieldLabel.username" />
				</div>
				<div class="col-sm-5">
					<form:input path="username" class="form-control" readonly="true" />
				</div>
				<div>
					<form:errors path="username" cssStyle="color: red;" />
				</div>
			</div>
			<div class="row editrow label-field">
				<div class="col-sm-3">
					<spring:message code="fieldLabel.password" />
				</div>
				<div class="col-sm-5">
					<form:input path="password" class="form-control" type="password"  />
				</div>
				<div>
					<form:errors path="password" cssStyle="color: red;" />
				</div>
			</div>

			<div class="row editrow">
				<div class="col-sm-3 label-field"></div>
				<div class="col-sm-5">
					<input type="submit" value="Update" class="btn btn-primary" />
				</div>

			</div>
		</div>
		<c:choose>
			<c:when test="${message==null}">
				<div></div>
			</c:when>
			<c:when test="${message==true}">
				<spring:message code="message.successUserPwChange"></spring:message>
			</c:when>
			<c:when test="${message==false}">
				<spring:message code="error.user.password.empty"></spring:message>
			</c:when>
			<c:otherwise>
				<div></div>
			</c:otherwise>
		</c:choose>

	</form:form>
</body>