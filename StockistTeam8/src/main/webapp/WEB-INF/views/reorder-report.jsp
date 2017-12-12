<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>

	<h3>Inventory Report</h3>
<form:form method="POST" modelAttribute="supplier"
	action="${pageContext.request.contextPath}/reorder/search.html">

	<form:select path="supplierId">
    <form:options items="${slist}" />
</form:select>
	<input type="submit" value="Search" />
</form:form>
		
<%-- <h3>Inventory Reorder Report for supplier ${plist.supplierId}</h3> --%>

 <c:set var = "total" scope = "session" value = "0"/>
			<table style="cellspacing: 2; cellpadding: 2; border: 1;width:100%">
				<tr class="listHeading">
					<th>Part No. </th>
					<th>Unit.Price</th>
					<th>Qty.</th>
					<th>Reorder Level</th>
					<th>Min.Ord.Qty.</th>
					<th>Ord.Qty.</th>
					<th>Price</th>
				</tr>
				<c:forEach var="product" items="${plist}">
					<tr class="listRecord">
						<td>${product.partNumber}</td>
						<td>${product.unitPrice}</td>
						<td>${product.stock}</td>
						<td>${product.reorderLevel}</td>
						<td>${product.minimumReorderQuantity}</td>

<c:set var = "quantity" scope = "session" value = "${product.stock}"/>	
<c:set var = "reorderQuantity" scope = "session" value = "${product.reorderLevel}"/>
<c:set var = "minreorderQuantity" scope = "session" value = "${product.minimumReorderQuantity}"/>								
<c:choose> 
<c:when test='${product.reorderLevel gt quantity}'> 
						
<c:set var = "minusVal" scope = "session" value = "${product.reorderLevel-quantity}"/>
<c:choose> 
<c:when test='${product.minimumReorderQuantity gt minusVal}'> 
<td>
<c:set var = "price" scope = "session" value = "${product.minimumReorderQuantity}"/>
${product.minimumReorderQuantity} </td>
 </c:when> 
  <c:otherwise><td>
  <c:set var = "price" scope = "session" value = "${minusVal}"/>
   <c:out value="${minusVal}"/>  </td></c:otherwise> 
  </c:choose>							
</c:when>	
<c:otherwise><td> 
 <c:set var = "price" scope = "session" value = "0"/>
 <c:out value="0"/>  </td></c:otherwise> 
</c:choose>
	     <%--        <fmt:parseNumber var = "i" type = "number" value = "${price}" /> --%>
				<c:set var = "total" scope = "session" value = "${(product.unitPrice*price)+total}"/>
						<td>${product.unitPrice*price}</td>
						
					</tr>
					
					
				</c:forEach>
				<tr>
				<td></td><td></td><td></td><td></td><td></td>
				<td>Total</td>
				<td><c:out value="${total}"/></td>
					</tr>
			</table>
	


</body>