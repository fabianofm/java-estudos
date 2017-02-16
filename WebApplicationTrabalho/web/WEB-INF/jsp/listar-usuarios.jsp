<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/header.jsp" %>


<jsp:useBean id="dao" class="dao.UsuarioDAO" />
    <ul>
        <c:forEach var="usuario" items="${dao.findUsuarioEntities()}">

            <h3>${usuario.nome}</h3>
            
            <li> Visualizar Itens: <a href="<%=request.getContextPath()%>/listar-cesta.jsp?clienteLogin=${usuario.login}">${usuario.login}</a></li>
            <li>${usuario.email}</li>
            <li>Cadastrado em: ${usuario.dataCadastro}</li>
            <li>Nascimento: ${usuario.dataNascimento}</li>
        
        <hr />
    </c:forEach>
    </ul>    

</div><!-- /.container -->        
<%@include file="/WEB-INF/jsp/footer.jsp" %>