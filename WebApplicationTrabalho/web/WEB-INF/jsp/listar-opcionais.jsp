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
        <style>
            .cor_a { background-color: activeborder; }
            .cor_b { background-color: activecaption; }
        </style>
    </head>
    <body> 
        <a href="#">Welcome, ${sessionScope.nome }</a>
    <li> <a href="<%=request.getContextPath()%>/Controller?command=LoginServlet" > Logout</a></li>


    <jsp:useBean id="dao" class="dao.ServicosOpcionaisDAO" />
    <form method="post">
        <c:forEach var="opcional" items="${dao.findServicosOpcionaisEntities()}" varStatus="id"> 
             <span class="${id.count % 2 == 0 ? 'cor_a' : 'cor_b' }">
            <c:choose> 
                <c:when test="${opcional.tipo.equalsIgnoreCase('Bebidas')}"> 
                    <input type="checkbox" name="bebidas" value="${opcional.nome}" />Bebida: ${opcional.nome} <br />
                </c:when> 
                <c:when test="${opcional.tipo == 'Comidas'}">
                    <input type="checkbox" name="comidas" value="${opcional.nome}" />Comida: ${opcional.nome} <br />
                </c:when>
                <c:when test="${opcional.tipo == 'Enfeites'}">
                    <input type="checkbox" name="enfeites" value="${opcional.nome}" />Enfeite: ${opcional.nome} <br />
                </c:when>   
                <c:when test="${opcional.tipo == 'Diversão'}">
                    <input type="checkbox" name="diversão" value="${opcional.nome}" />Diversão: ${opcional.nome} <br />
                </c:when>
                <c:otherwise>
                    ...
                </c:otherwise>
            </c:choose>
            </span>            
        </c:forEach>

        <input type="submit" value="Submit now" />
    </form>

</body>
</html>
