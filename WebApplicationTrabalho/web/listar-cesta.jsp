<%-- 
    Document   : Usuario
    Created on : 30/01/2017, 12:11:10
    Author     : fabia
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       ${sessionScope.login}
       
       <% 
            
            String value=request.getParameter("clienteLogin").toString();
           
           if(value != null ){
               
              String cliente=request.getParameter("clienteLogin").toString();
           
           } else {
               String cliente = (String)session.getAttribute("login");
           }
           
           
            
            
       %>
${value}
    <jsp:useBean id="dao" class="dao.CestaDAO" />
    <ul>
        <c:forEach var="item" items="${dao.findItens(cliente)}">
            <li>${item.item}</li>
            
        </c:forEach>
    </ul>    


</body>
</html>
