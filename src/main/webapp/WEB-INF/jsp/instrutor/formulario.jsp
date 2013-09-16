<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title"><spring:message code="instrutor.titulo"/></h4>
            </div>
            <c:url value="/instrutor" var="urlAction"/>
            <form:form action="${urlAction}" method="POST" commandName="instrutor" role="form">
                <div class="modal-body">
                    <jsp:include page="fieldSet.jsp"/>
                </div>
                <div class="modal-footer">
                    <div class="btn-group pull-right">
                        <button type="button" class="btn btn-default" data-dismiss="modal"><spring:message code="formulario.botaoFechar"/></button>
                        <button type="reset" class="btn btn-default"><spring:message code="formulario.botaoLimpar"/></button>
                        <button type="button" class="btn btn-primary insereAction"><spring:message code="formulario.botaoSalvar"/></button>
                    </div>
                </div>
            </form:form>

        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
