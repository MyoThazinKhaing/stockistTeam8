<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<h3>Fill in the following to create a new user</h3>

<form:form method="POST" commandName="user"
	action="${pageContext.request.contextPath}/admin/user/create.html">
<%-- 	<table>
		<tbody>
			<!-- 			<tr> -->
							<td><spring:message code="fieldLabel.userId" /></td>
							<td><form:input path="userId" /></td>
							<td><form:errors path="userId" cssStyle="color: red;" /></td>
			<!-- 			</tr> -->
			<tr>
				<td><spring:message code="fieldLabel.username" /></td>
				<td><form:input path="username" /></td>
				<td><form:errors path="username" required="required"
						cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.password" /></td>
				<td><form:input path="password" type="password"/></td>
				<td><form:errors path="password" required="required"
						cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.role" /></td>
				<td><form:select path="role" items="${eidlist}" /></td>
				<td><form:errors path="role" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><spring:message code="fieldLabel.status" /></td>
				<td><form:select path="status" items="${statuslist}" /></td>
				<td><form:errors path="status" cssStyle="color: red;" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table> 
	<c:if test="${message != error}">
		<div>
		<spring:message code="message.successUserCreate" />
		</div>

	</c:if>
</form:form> --%>
		<div style="margin: 20px 0 0 0">
				<div class="row editrow">
					<div class="col-sm-3 label-field" >Username</div>
					<div class="col-sm-5"><form:input path="username" class="form-control" /></div>
					<div><form:errors path="username" cssStyle="color: red;" /></div>
				</div>
				<div>
				</div>
				<div class="row editrow">
				<div class="col-sm-3  label-field">Password</div>
				<div class="col-sm-5"><form:input path="password" type="password" class="form-control" /></div>
					<div><form:errors path="password" cssStyle="color: red;" /></div>
				</div>
					<div>
				</div>
				<div class="row editrow">
					<div class="col-sm-3 label-field">Role</div>
					<div class="col-sm-5"><form:select path="role" items="${eidlist}" class="form-control" /></div>
					<div><form:errors path="role" cssStyle="color: red;" /></div>
				</div>
					<div>
				</div>
				<div class="row editrow">
					<div class="col-sm-3 label-field">Status</div>
					<div class="col-sm-5"><form:select path="status" items="${statuslist}" class="form-control"/></div>
					<div><form:errors path="status" cssStyle="color: red;" /></div>
				</div>
					<div>
				</div>
				<div class="row editrow">
					<div class="col-sm-3 label-field"></div>
					<div class="col-sm-5"><input type="submit" value="Create" 
						class="btn btn-primary" /></div>
				</div>

		</div>
		<c:choose>
		<c:when test="${message == null}"><div></div></c:when>
		<c:when test="${message == true}"><spring:message code="message.successUserCreate" /></c:when>
		<c:when test="${message == false}"><spring:message code="error.username.repeat" /></c:when>
		<c:otherwise><div> </div></c:otherwise>	
		</c:choose>
<%-- 
			<c:if test="${message != error}">
		<div>
		<spring:message code="message.successUserCreate" />
		</div>

	</c:if> --%>

	
	</form:form>