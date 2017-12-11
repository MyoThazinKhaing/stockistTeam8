   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Salary</th></tr>  
   <c:forEach var="pro" items="${list}">   
   <tr>  
   <td>${pro.partNumber}</td>  
   <td>${pro.unitPrice}</td>  
   <td>${pro.description}</td>  
   <td>${pro.colour}</td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <a href="/pagin/1">1</a>   
   <a href="/pagin/2">2</a>   
   <a href="/pagin/3">3</a>  