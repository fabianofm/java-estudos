<%-- 
    Document   : index
    Created on : 26/01/2017, 13:45:59
    Author     : fab
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <ul>
            <li><a href="<%=request.getContextPath()%>/login.jsp">Login</a></li>
            <li><a href="<%=request.getContextPath()%>/adiciona-pessoa.jsp">Add Pessoa</a></li>
            <li><a href="<%=request.getContextPath()%>/pessoa.jsp">Lista de Pessoa</a></li>
            <li><a href="<%=request.getContextPath()%>/Controller?command=ExibePaginaColorados">Exibe Página para Colorados</a></li>
        </ul>
    </body>
</html>

