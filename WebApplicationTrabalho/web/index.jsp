<%-- 
    Document   : index
    Created on : 26/01/2017, 13:45:59
    Author     : fab
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
        
    <c:if test="${sessionScope.login  != null}" > 
        Bem-vindo, ${sessionScope.login }!
    </c:if>  

    <ul>
        <li><a href="<%=request.getContextPath()%>/login.jsp">Login</a></li>
        <li><a href="<%=request.getContextPath()%>/cadastro.jsp">Cadastro</a></li>
        <li><a href="<%=request.getContextPath()%>/Controller?command=CadastrarOpcionais">Cadastrar Opcionais</a></li>
        <li><a href="<%=request.getContextPath()%>/Controller?command=ListarUsuarios">Listar de Usuarios</a></li>
        <li><a href="<%=request.getContextPath()%>/Controller?command=ListarOpcionais">Listar Opcionais</a></li>
        <li><a href="<%=request.getContextPath()%>/Controller?command=ExibePaginaColorados">Exibe Página para Colorados</a></li>
        <li><a href="<%=request.getContextPath()%>/Controller?command=Logout">Logout</a></li>
    </ul>
</body>
</html>


