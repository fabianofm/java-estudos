<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/header.jsp" %>

   
    <c:if test="${empty sessionScope.login}" > 
        <h1>Cadastre-se</h1>
        <form method="post" action="<%=request.getContextPath()%>/Controller?command=AdicionarUsuario">
            Nome: <input name="nome" class="form-control" required placeholder="Preencha este campo." /> <br/>
            Email: <input name="email" class="form-control" required placeholder="Preencha este campo." /><br/>
            Login: <input name="login" class="form-control" required placeholder="Preencha este campo."/><br/>
            Senha: <input name="senha" class="form-control" required placeholder="Preencha este campo." /><br/>
            Nascimento: <input name="dataNascimento" class="form-control" required placeholder="Preencha este campo."  /><br/>
            <input type="submit" value="Cadastrar" class="btn btn-primary" />
        </form>  
    </c:if>
</div><!-- /.container -->        
<%@include file="/WEB-INF/jsp/footer.jsp" %>