<%-- 
    Document   : Usuario
    Created on : 30/01/2017, 12:11:10
    Author     : fabia
--%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.transaction.UserTransaction"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="dao.UsuarioDAO"%>
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
        <%
            UsuarioDAO dao = new UsuarioDAO();
            List<Usuario> list = dao.findUsuarioEntities();
        %>

        <ul>
            <% for (Usuario item : list) {%>
            <li>
                <li><%=item.getId()%></li>
                <li><%=item.getNome()%></li>
                <li><%=item.getEmail()%></li>
            </li>
            <%}%>
        </ul>


    </body>
</html>
