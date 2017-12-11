
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


 <table width="100%"> <tr>
<td class="supplierHeader"> Supplier List page</td>

<td class="supplierHeader"><form:form method="POST" modelAttribute="supplier"
	action="${pageContext.request.contextPath}/admin/supplier/searchByName/${supplierName}.html">

	Search By name
	<form:input path="supplierName"  style="width: 300px;" onfocus="this.value='';"/>
	
	 <input type="submit" value="Search" class="blcass"/>
	

	</form:form>
	
</td>
<td class="supplierHeader"><a href="${pageContext.request.contextPath}/admin/supplier/create">Add
	Supplier</a>
</td></tr>
</table> 
<div class="line"></div>



	<c:if test="${fn:length(supplierList) gt 0}">
	<table style="cellspacing: 2; cellpadding: 2; border: 1;" id="supplierTable">
		<thead>
			<tr class="listHeading">
				<th>Supplier ID</th>
				<th>Supplier Name</th>
				<th>Supplier Address</th>
				<th>Supplier Country</th>
				<th>Supplier Contact Number</th>
				<th>Supplier Contact Name</th>
				<th>Supplier Website</th>
				<th>Supplier Status</th>
				<th><spring:message code="caption.edit" /></th>
				<%-- <th><spring:message code="caption.delete" /></th> --%>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="supplier" items="${supplierList}">
				<tr class="listRecord">
					<td>${supplier.supplierId}</td>
					<td>${supplier.supplierName}</td>
					<td>${supplier.address}</td>
					<td>${supplier.country}</td>
					<td>${supplier.contactNumber}</td>
					<td>${supplier.contactName}</td>
					<td>${supplier.website}</td>
					<td>${supplier.status}</td>
					
					<td align="center"><a
						href="${pageContext.request.contextPath}/admin/supplier/edit/${supplier.supplierId}.html"><spring:message
								code="caption.edit" /></a></td>
					<%-- <td><a
						href="${pageContext.request.contextPath}/admin/supplier/delete/${supplier.supplierId}.html"><spring:message
								code="caption.delete" /></a></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
