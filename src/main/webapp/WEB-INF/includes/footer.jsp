<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</div> <!-- fim do miolo da pagina -->
<!-- Footer -->
<br/>
<hr/>
<div id="footer">
    <div class="container">
        <p class="text-muted credit"><a href="https://github.com/Bregaida/acsp">ACSP</a> é um projeto open source.</p>
    </div>
</div>

<!-- jQuery (necessary for Bootstraps JavaScript plugins) -->
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.10.2.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.10.3.custom.min.js"/>"></script>
<!-- Enable responsive features in IE8 with Respond.js (https://github.com/scottjehl/Respond) -->
<script type="text/javascript" src="<c:url value="/resources/js/respond.min.js"/>"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootbox.min.js"/>"></script>

<script type="text/javascript" src="<c:url value="/resources/js/underscore-min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/underscore.string.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/modal.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/tooltip.js"/>"></script>

<script type="text/javascript" src="<c:url value="/resources/js/common-utils.js"/>"></script>

<!-- remover esses js porcos e nojentos portuga explica a mandinga para o incluir e alterar -->
<script type="text/javascript" src="<c:url value="/resources/js/atendentes.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/instrutores.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/socios.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/aulas.js"/>"></script>

<c:if test="${formHasError}">
    <script type="text/javascript">
        //Exibe o form ao carregar a pagina se o mesmo tem erros de validação.
        //Não esquecer de popular a variavel no controller dentro do result.hasError()
        $(function() {
            $('#myModal').modal('show');
        });
    </script>
</c:if>

</body>
</html>