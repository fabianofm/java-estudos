<%-- 
    Document   : pessoa
    Created on : 30/01/2017, 12:11:10
    Author     : fabia
--%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.transaction.UserTransaction"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Pessoa"%>
<%@page import="java.util.List"%>
<%@page import="dao.PessoaDAO"%>
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
            PessoaDAO dao = new PessoaDAO();
            List<Pessoa> list = dao.findPessoaEntities();
        %>

        <ul>
            <% for (Pessoa item : list) {%>
            <li>
                <li><%=item.getId()%></li>
                <li><%=item.getNome()%></li>
                <li><%=item.getEmail()%></li>
            </li>
            <%}%>
        </ul>


    </body>
</html>
