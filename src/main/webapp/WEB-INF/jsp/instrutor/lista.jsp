<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>

	<table class="table table-striped table-hover">
        <thead>
            <td>ID</td>
            <td>Nome do instrutor</td>
            <td>Código anac</td>
            <td>RG</td>
            <td>CPF</td>
            <td>Escolaridade</td>
            <td>Título de Eleitor</td>
            <td>Nome de Pista</td>
            <td>CHT</td>
            <td>CMA</td>
            <td>Ativo</td>
            <td>Quantidade de Horas Ministradas</td>
            <td></td>
        </thead>
        <tbody>
		<c:forEach var="instrutor" items="${listaDeInstrutores}">
			<tr id="instrutor_<c:out value="${instrutor.id}"/>">
                <td><c:out value="${instrutor.id}"/></td>
				<td id="instrutorNome<c:out value="${instrutor.id}"/>"><c:out value="${instrutor.nome}"/></td>
				<td><c:out value="${instrutor.codigoANAC}"/></td>
				<td><c:out value="${instrutor.rg}"/></td>
				<td><c:out value="${instrutor.cpf}"/></td>
				<td><c:out value="${instrutor.escolaridade.descricao}"/></td>
				<td><c:out value="${instrutor.tituloEleitor}"/></td>
				<td><c:out value="${instrutor.nomePista}"/></td>
				<td><c:out value="${instrutor.cht}"/></td>
				<td><c:out value="${instrutor.cma}"/></td>
				<td><c:out value="${instrutor.ativo}"/></td>
				<td><c:out value="${instrutor.quantidadeHorasMinistrada}"/></td>
                <td>
                    <div class="btn-group btn-group-sm">
                        <input type="button" class="btn btn-default editaInstrutorAction" id="editar_<c:out value="${instrutor.id}"/>" value="Editar" instrutorid="<c:out value="${instrutor.id}"/>"/>
                        <input type="button" class="btn btn-default apagaInstrutorAction" id="apagar_<c:out value="${instrutor.id}"/>" value="Apagar" instrutorid="<c:out value="${instrutor.id}"/>"/>
                    </div>
                </td>
			</tr>
		</c:forEach>
        </tbody>
	</table>

<!-- Button trigger modal -->
<a id="instrutorModalBtn" data-toggle="modal" href="#myModal" class="btn btn-default btn-lg">Novo Instrutor</a>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Instrutor</h4>
            </div>
            <div class="modal-body">
                <c:import url="fieldSet.jsp"/>
            </div>
            <div class="modal-footer">
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<c:import url="../../includes/footer.jsp"/>
