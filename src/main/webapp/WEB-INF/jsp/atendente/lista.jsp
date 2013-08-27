<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>

	<table class="table table-striped table-hover">
        <thead>
            <td>ID</td>
            <td>Nome do Atendente</td>
            <td>RG</td>
            <td>CPF</td>
            <td>Escolaridade</td>
            <td>Título de Eleitor</td>
            <td>Ativo</td>
            <td></td>
        </thead>
        <tbody>
		<c:forEach var="atendente" items="${listaDeAtendentes}">
			<tr id="atendente_<c:out value="${atendente.id}"/>">
                <td><c:out value="${atendente.id}"/></td>
				<td id="atendenteNome<c:out value="${atendente.id}"/>"><c:out value="${atendente.nome}"/></td>
				<td><c:out value="${atendente.rg}"/></td>
				<td><c:out value="${atendente.cpf}"/></td>
				<td><c:out value="${atendente.escolaridade.descricao}"/></td>
				<td><c:out value="${atendente.tituloEleitor}"/></td>
				<td><c:out value="${atendente.ativo}"/></td>
                <td>
                    <span class="icon-edit icon-2x editaAtendenteAction" atendenteid="<c:out value="${atendente.id}"/>"></span>
                    &nbsp;
                    <span class="icon-remove-circle icon-2x apagaAtendenteAction" atendenteid="<c:out value="${atendente.id}"/>"></span>
                </td>
			</tr>
		</c:forEach>
        </tbody>
	</table>
    <ul class="pagination pull-right">
        <li class="active">
            <a href="/acsp/atendentes?page=1?page.size=5?page.sort=id">1</a>
        </li>
        <li>
            <a href="/acsp/atendentes?page=2?page.size=5?page.sort=id">2</a>
        </li>
        <li>
            <a href="/acsp/atendentes?page=3?page.size=5?page.sort=id">3</a>
        </li>
        <li>
            <a href="/acsp/atendentes?page=4?page.size=5?page.sort=id">4</a>
        </li>
    </ul>

<!-- Button trigger modal -->
<a id="atendenteModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Novo Atendente</a>

<c:import url="formulario.jsp"/>

<c:import url="../../includes/footer.jsp"/>