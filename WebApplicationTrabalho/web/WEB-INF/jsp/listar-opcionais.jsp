<%-- 
    Document   : Listar Opcionais
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
        <a href="#">Welcome, ${sessionScope.nome }</a>
    <li> <a href="<%=request.getContextPath()%>/Controller?command=LoginServlet" > Logout</a></li>


    <jsp:useBean id="dao" class="dao.ServicosOpcionaisDAO" />
    <ul>
        <c:forEach var="opcional" items="${dao.findServicosOpcionaisEntities()}">
            <li>${opcional.id}</li>
            <li>${opcional.nome} - ${usuario.login}</li>
            <li>${opcional.tipo}</li>
            </c:forEach>
    </ul>  


</body>
</html>
