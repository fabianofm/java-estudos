<%-- 
    Document   : cadastrar-opcionais
    Created on : 07/02/2017, 09:57:56
    Author     : fabia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     
        <h1>Cadastre um novo item opcional</h1>

        <form method="post" action="<%=request.getContextPath()%>/Controller?command=AdicionarServicoOpcional">
            Nome: <input name="nome"/><br/>
            <input type=text name="tipo" list=tipo >
            <datalist id=tipo >
               <option> Comidas
               <option> Bebidas
               <option> Enfeites
               <option> Diversão    
            </datalist>
            <input type="submit"/>
        </form>  
    </body>
</html>