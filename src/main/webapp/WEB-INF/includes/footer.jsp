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
<script type="text/javascript" src="<c:url value="/resources/js/LAB.js"/>"></script>
<script type="text/javascript">
$LAB
    .script("<c:url value="/resources/js/jquery-1.10.2.min.js"/>").wait()
    .script("<c:url value="/resources/js/jquery.dataTables.min.js"/>")
    .script("<c:url value="/resources/js/DT-bootstrap.js"/>")
    .script("<c:url value="/resources/js/common-utils.js"/>")
    .script("<c:url value="/resources/js/respond.min.js"/>")
    .script("<c:url value="/resources/js/bootstrap.min.js"/>")
    .script("<c:url value="/resources/js/bootbox.min.js"/>")
    .script("<c:url value="/resources/js/modal.js"/>")
    .script("<c:url value="/resources/js/jquery.mask.min.js"/>")
    .script("<c:url value="/resources/js/fullcalendar.min.js"/>")
    .script("<c:url value="/resources/js/tooltip.js"/>");
</script>

</body>
</html>