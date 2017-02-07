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
       

    <jsp:useBean id="dao" class="dao.UsuarioDAO" />
    <ul>
        <c:forEach var="usuario" items="${dao.findUsuarioEntities()}">
            <li>${usuario.id}</li>
            <li>${usuario.nome} - ${usuario.login}</li>
            <li>${usuario.email}</li>
        </c:forEach>
    </ul>    


</body>
</html>
