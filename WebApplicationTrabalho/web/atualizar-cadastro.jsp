<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/header.jsp" %>

<% pageContext.setAttribute("cliente", String.valueOf(session.getAttribute("login")), PageContext.SESSION_SCOPE);%>

<jsp:useBean id="dao" class="dao.UsuarioDAO" />


<h1>Cadastre-se</h1>
<c:forEach var="usuario" items="${dao.findUsuarioLogin(cliente)}">
    <form method="post" action="<%=request.getContextPath()%>/Controller?command=EditarUsuario">
        Login: <input name="login" value="${usuario.login}" class="form-control"   /> <br/>
        Nome: <input name="nome" value="${usuario.nome}" class="form-control" required  /> <br/>
        Email: <input name="email" value="${usuario.email}" class="form-control" required /><br/>
        Senha: <input name="senha" value="" class="form-control" required /><br/>
        <input name="id" type="hidden" value="${usuario.id}" />
        
        <input name="dataCadastro" type="hidden" value="${usuario.dataCadastro}" />
        <input name="dataNascimento" type="hidden" value="${usuario.dataNascimento}" />
        
        <input type="submit" value="Cadastrar" class="btn btn-primary" />
    </form>  
</c:forEach>
</div><!-- /.container -->        
<%@include file="/WEB-INF/jsp/footer.jsp" %>