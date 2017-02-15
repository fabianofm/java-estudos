<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/header.jsp" %>
     


<div class="container-fluid">
  <div class="row-fluid">
    <div class="offset1 span8 pull-right">
 
        
            <jsp:useBean id="dao" class="dao.ServicosOpcionaisDAO" />
    <form method="post" action="<%=request.getContextPath()%>/Controller?command=AdicionarItemCesta">
        <c:forEach var="opcional" items="${dao.findServicosOpcionaisEntities()}" varStatus="id"> 
            
            <c:choose> 
                <c:when test="${opcional.tipo.equalsIgnoreCase('Bebidas')}"> 
                    <div class="checkbox">
                        <label class="${id.count % 2 == 0 ? 'odd' : 'even' }">
                            <input type="checkbox" name="item" value="${opcional.nome}"   />Bebida: ${opcional.nome}</label>
                    </div>    
                </c:when> 
                <c:when test="${opcional.tipo == 'Comidas'}">
                    <div class="checkbox">
                        <label class="${id.count % 2 == 0 ? 'odd' : 'even' }">
                            <input type="checkbox" name="item" value="${opcional.nome}"  />Comida: ${opcional.nome}</label>
                    </div>    
                </c:when>
                <c:when test="${opcional.tipo == 'Enfeites'}">
                    <div class="checkbox">
                        <label class="${id.count % 2 == 0 ? 'odd' : 'even' }">
                            <input type="checkbox" name="item" value="${opcional.nome}"  />Enfeite: ${opcional.nome}</label>
                    </div>    
                </c:when>   
                <c:when test="${opcional.tipo == 'Diversão'}">
                    <div class="checkbox">
                        <label class="${id.count % 2 == 0 ? 'odd' : 'even' }">
                            <input type="checkbox" name="item" value="${opcional.nome}"   />Diversão: ${opcional.nome}</label>
                    </div>
                </c:when>
                <c:otherwise>
                    ...
                </c:otherwise>
            </c:choose>
                  
        </c:forEach>
        <input type="hidden" name="login" value="${sessionScope.login }" />
        <input type="submit" value="Cadastrar" class="btn btn-primary" />
    </form>
        
        
    </div>
    
    <div class="span8" style="margin-left: 0;">
    
                <h3>Seus Itens</h3>
         <jsp:useBean id="daoCesta" class="dao.CestaDAO" />
        <ul>
            <c:forEach var="item" items="${daoCesta.findItens(login )}">
                <li><a href="<%=request.getContextPath()%>/Controller?command=RemoverItemCesta&id=${item.id}">${item.item}</a></li>
            </c:forEach>
        </ul> 
    </div>


  </div>

</div><!--/.fluid-container-->


        
        

        
        
</div><!-- /.container -->        
<%@include file="/WEB-INF/jsp/footer.jsp" %>