<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>

<div class="clearfix">
    <table class="table table-striped table-hover">
        <thead>
        <th>Número de Inscrição</th>
        <th>Nome do sócio</th>
        <th>Código anac</th>
        <th>RG</th>
        <th>CPF</th>
        <th>Escolaridade</th>
        <th>Título de Eleitor</th>
        <th>Nome de Pista</th>
        <th>CHT</th>
        <th>CMA</th>
        <th>Ativo</th>
        <th></th>
        </thead>
        <tbody>
        <c:forEach var="socio" items="${listaDeSocios}">
            <tr id="<c:out value="${socio.id}"/>">
                <td><c:out value="${socio.numeroInscricao}"/></td>
                <td><c:out value="${socio.nome}"/></td>
                <td><c:out value="${socio.codigoANAC}"/></td>
                <td><c:out value="${socio.rg}"/></td>
                <td><c:out value="${socio.cpf}"/></td>
                <td><c:out value="${socio.escolaridade.descricao}"/></td>
                <td><c:out value="${socio.tituloEleitor}"/></td>
                <td><c:out value="${socio.nomePista}"/></td>
                <td><c:out value="${socio.cht}"/></td>
                <td><c:out value="${socio.cma}"/></td>
                <td><span class="${socio.ativo?'icon-check':'icon-check-empty'}"></span></td>
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
<a id="socioModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Novo Socio</a>

<c:import url="formulario.jsp"/>

<c:import url="../../includes/footer.jsp"/>