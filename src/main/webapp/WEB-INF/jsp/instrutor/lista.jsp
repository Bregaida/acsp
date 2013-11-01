<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../includes/header.jsp"/>

<div class="clearfix">
    <table class="table table-striped table-hover table-condensed datatabled">
        <thead>
        <th>Nome do instrutor</th>
        <th>Nome de Pista</th>
        <th>Código anac</th>
        <th>CPF</th>
        <th>CHT</th>
        <th>CMA</th>
        <th>Ativo</th>
        <th>Qth. Hr/Aula</th>
        <th></th>
        </thead>
        <tbody>
        <c:forEach var="instrutor" items="${listaDeInstrutores}">
        	 <tr id="<c:out value="${instrutor.id}"/>">
                <td class="hidden"><c:out value="${instrutor.id}"/></td>
                <td id="instrutorNome<c:out value="${instrutor.id}"/>"><c:out value="${instrutor.nome}"/></td>
                <td><c:out value="${instrutor.nomePista}"/></td>
                <td><c:out value="${instrutor.codigoANAC}"/></td>
                <td><c:out value="${instrutor.cpf}"/></td>
                <td><c:out value="${instrutor.cht}"/></td>
                <td><c:out value="${instrutor.cma}"/></td>
                <td><span class="${instrutor.ativo?'icon-check':'icon-check-empty'}"></span></td>
                <td><c:out value="${instrutor.quantidadeHorasMinistrada}"/></td>
                <td>
                    <div class="btn-group btn-custom-block">
                        <span class="icon-edit icon-2x editaAction"></span>
                        <span class="icon-remove-circle icon-2x apagaAction"></span>
                        <span class="icon-plane icon-2x aeronaveAction"></span>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Button trigger modal -->
<a id="instrutorModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Novo Instrutor</a>

<jsp:include page="formulario.jsp"/>
<jsp:include page="formularioAeronavesHabilitadas.jsp"/>

<jsp:include page="../../includes/footer.jsp"/>