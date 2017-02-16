<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/header.jsp" %>

<% pageContext.setAttribute("cliente", String.valueOf(session.getAttribute("login")), PageContext.SESSION_SCOPE);%>

<jsp:useBean id="dao" class="dao.UsuarioDAO" />

<h1>Atualizar Cadastro</h1>

    <c:forEach var="usuario" items="${dao.findUsuarioLogin(cliente)}">
        <form method="post" action="<%=request.getContextPath()%>/Controller?command=EditarUsuario">


            Nome: <input name="nome" value="${usuario.nome}" class="form-control" required  /> <br/>
            Email: <input name="email" value="${usuario.email}" class="form-control" required /><br/>
            Senha: <input name="senha" value="${usuario.senha}" class="form-control" /><br/>

            <input name="login" type="hidden" value="${usuario.login}" />
            <input name="id" type="hidden" value="${usuario.id}" />

            Cadastrado em:<input name="dataCadastro" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${usuario.dataCadastro}" />" />
            Nascimento: <input name="dataNascimento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${usuario.dataNascimento}" />" />

            <input type="submit" value="Atualizar" class="btn btn-primary" />
        </form>  
    </c:forEach>

</div><!-- /.container -->        
<%@include file="/WEB-INF/jsp/footer.jsp" %>