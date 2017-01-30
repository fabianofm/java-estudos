<%-- 
    Document   : adiciona-pessoa
    Created on : 27/01/2017, 17:01:20
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
        <h1>Adiciona Contato!</h1>

        <form method="post" action="/WebApplicationTrabalho/Controller?command=AdicionarPessoa">
            Nome: <input name="nome"/><br/>
            Email: <input name="email"/><br/>
            Senha: <input name="senha"/><br/>
            Nascimento: <input name="dataNascimento"/><br/>
            <input type="submit"/>
        </form>
    </body>
</html>
