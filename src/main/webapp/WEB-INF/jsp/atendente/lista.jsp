<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>

<div class="clearfix">
    <table class="table table-striped table-hover datatabled">
        <thead>
        <th class="hidden">ID</th>
        <th>Nome do Atendente</th>
        <th>CPF</th>
        <th>Ativo</th>
        <th></th>
        </thead>
        <tbody>
        <c:forEach var="atendente" items="${listaDeAtendentes}">
            <tr id="<c:out value="${atendente.id}"/>">
                <td class="hidden"><c:out value="${atendente.id}"/></td>
                <td id="atendenteNome<c:out value="${atendente.id}"/>"><c:out value="${atendente.nome}"/></td>
                <td><c:out value="${atendente.cpf}"/></td>
                <td><span class="${atendente.ativo?'icon-check':'icon-check-empty'}"></span></td>
                <td>
                    <div class="btn-group btn-custom-block">
                        <span class="icon-edit icon-2x editaAction"></span>
                        <span class="icon-remove-circle icon-2x apagaAction"></span>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<!-- Button trigger modal -->
<a id="atendenteModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Novo Atendente</a>

<c:import url="formulario.jsp"/>

<c:import url="../../includes/footer.jsp"/>