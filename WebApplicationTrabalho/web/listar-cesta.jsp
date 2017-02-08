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

        <c:choose>
            <c:when test="${sessionScope.login != null && sessionScope.login ne 'admin'}">
                <% pageContext.setAttribute("cliente", String.valueOf(session.getAttribute("login")), PageContext.SESSION_SCOPE);
                %>
            </c:when>
            
            <c:when test="${sessionScope.login == 'admin'}">
               
                <% pageContext.setAttribute("cliente", String.valueOf(request.getParameter("clienteLogin")), PageContext.SESSION_SCOPE);
                %>
            </c:when>
        </c:choose>

        <h1>Lista de  ${sessionScope.cliente}</h1>
        
        <jsp:useBean id="dao" class="dao.CestaDAO" />
        <ul>
            <c:forEach var="item" items="${dao.findItens(cliente)}">
                <li>${item.item}</li>
            </c:forEach>
        </ul>    


    </body>
</html>
