<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>

	<table class="table table-striped table-hover">
        <thead>
            <td>ID</td>
            <td>Nome</td>
            <td>Código anac</td>
            <td>RG</td>
            <td>CPF</td>
            <td>Escolaridade</td>
            <td>Título de Eleitor</td>
            <td>Nome de Pista</td>
            <td>CHT</td>
            <td>CMA</td>
            <td>Ativo</td>
            <td>Qtd. Hr/Aula</td>
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
                    <span class="icon-edit icon-2x editaInstrutorAction" instrutorid="<c:out value="${instrutor.id}"/>"></span>
                    &nbsp;
                    <span class="icon-remove-circle icon-2x apagaInstrutorAction" instrutorid="<c:out value="${instrutor.id}"/>"></span>
                </td>
			</tr>
		</c:forEach>
        </tbody>
	</table>
    <ul class="pagination pull-right">
        <li class="active">
            <a href="/acsp/instrutores?page=1?page.size=5?page.sort=id">1</a>
        </li>
        <li>
            <a href="/acsp/instrutores?page=2?page.size=5?page.sort=id">2</a>
        </li>
        <li>
            <a href="/acsp/instrutores?page=3?page.size=5?page.sort=id">3</a>
        </li>
        <li>
            <a href="/acsp/instrutores?page=4?page.size=5?page.sort=id">4</a>
        </li>
    </ul>

<!-- Button trigger modal -->
<a id="instrutorModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Novo Instrutor</a>

<c:import url="formulario.jsp"/>

<c:import url="../../includes/footer.jsp"/>