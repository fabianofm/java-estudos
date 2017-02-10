<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/header.jsp" %>

     
        <h1>Cadastre um novo item opcional</h1>

        <form method="post" action="<%=request.getContextPath()%>/Controller?command=AdicionarServicoOpcional">
            Nome: <input name="nome"  class="form-control" required placeholder="Preencha este campo." /><br/>
            <input type=text name="tipo" list=tipo  class="form-control" required placeholder="Preencha a categoria." />
            <datalist id=tipo  c  >
               <option> Comidas
               <option> Bebidas
               <option> Enfeites
               <option> Diversão    
            </datalist>
            <input type="submit" class="btn btn-primary" />
        </form>  
</div><!-- /.container -->        
<%@include file="/WEB-INF/jsp/footer.jsp" %>