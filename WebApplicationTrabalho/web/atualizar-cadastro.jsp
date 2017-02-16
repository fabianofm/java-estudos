<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/header.jsp" %>

    <% pageContext.setAttribute("cliente", String.valueOf(session.getAttribute("login")), PageContext.SESSION_SCOPE); %>

   <jsp:useBean id="dao" class="dao.UsuarioDAO" />
   <c:forEach var="usuario" items="${dao.findUsuarioLogin(cliente)}">
    <h1>Cadastre-se</h1>
    <form method="post" action="<%=request.getContextPath()%>/Controller?command=EditarUsuario">
        <input name="nome" type="hidden" value="${usuario.id}" class="form-control" />
        <input name="nome" type="hidden" value="01/01/1991" class="form-control" />
        Nome: <input name="nome" value="${usuario.nome}" class="form-control" required  /> <br/>
        Email: <input name="email" value="${usuario.email}" class="form-control" required /><br/>

        Senha: <input name="senha" value="" class="form-control" required /><br/>
        Nascimento: <input name="dataNascimento" value="01/01/1991" class="form-control"  /><br/>
        <input type="submit" value="Cadastrar" class="btn btn-primary" />
    </form>  
</c:forEach>
</div><!-- /.container -->        
<%@include file="/WEB-INF/jsp/footer.jsp" %>