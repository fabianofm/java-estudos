<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/header.jsp" %>

        Olá Colorados, confira tudo sobre o inter aqui. <br/> <br/>

        <table border="1">
            <thead>
                <tr>
                    <th>Notícia</th>
                    <th>Link</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="i" begin="1" end="5" step="1" varStatus ="row">
                    <c:choose>
                        <c:when test="${row.count % 2 == 0}">
                            <c:set var="estiloLinha" value="odd"  />
                        </c:when>
                        <c:otherwise>
                            <c:set var="estiloLinha" value="even"  />
                        </c:otherwise>
                    </c:choose>

                    <tr class="${estiloLinha}">
                        <td>
                            <c:out value="Notícia número ${i}"  />
                        </td>
                        <td>
                            <c:out value="Em breve! Aguarde." />
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>       
</div><!-- /.container -->        
<%@include file="/WEB-INF/jsp/footer.jsp" %>