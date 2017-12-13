<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>

<style>
.editrow {
	margin: 20px 0px;
}

.label-field {
	text-align: right;
	padding-top: 5;
}
</style>

<h3>New Damage page</h3>
<div style="margin: 30px 30px 30px 0">
<form:form method="POST" modelAttribute="damage"
	action="${pageContext.request.contextPath}/damage/create">
	
		<div class="row editrow">	
			<div class="col-sm-3 label-field">Part Number</div>
			<div class="col-sm-5">
				<form:select path="partNumber" class="custom-select">						
						<form:options items="${plist}" />
					</form:select>
					
			</div>
			<div>
				<form:errors path="partNumber" cssStyle="color: red;" />
			</div>
		</div>
		<div class="row editrow">
			<div class="col-sm-3  label-field">Unit Price</div>
			<div class="col-sm-5">
				<form:input path="quantity" class="form-control" />
			</div>
			<div>
				<form:errors path="quantity" cssStyle="color: red;" />
			</div>
		</div>
		<div class="row editrow">
			<div class="col-sm-3 label-field">Send Date</div>
			<div class="col-sm-5">
				<form:input path="sendDate" class="custom-select" type="date" />
			</div>
			<div>
				<form:errors path="sendDate" cssStyle="color: red;" />
			</div>
		</div>
<%-- 		<div class="row editrow">
			<div class="col-sm-3 label-field">Receive Date</div>
			<div class="col-sm-5">
				<form:input path="receiveDate" class="custom-select" type="date" />
			</div>
			<div>
				<form:errors path="receiveDate" cssStyle="color: red;" />
			</div>
		</div> --%>
		<div class="row editrow">
			<div class="col-sm-3 label-field"></div>
			<div class="col-sm-5">
			<input type="submit" value="Create" class="btn btn-primary"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a  href="${pageContext.request.contextPath}/damage/list.html" class="btn btn-danger" >
				Cancel </a>
				</div>
		</div>
		<form:hidden path="damageId" />
		<form:hidden path="status" />
	
	
</form:form>