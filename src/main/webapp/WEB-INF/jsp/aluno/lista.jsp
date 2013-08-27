<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>

	<table class="table table-striped table-hover">
        <thead>
            <th class="hidden">ID</th>
            <th>Nome do aluno</th>
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
		<c:forEach var="aluno" items="${listaDeAlunos}">
			<tr id="<c:out value="${aluno.id}"/>">
                <td class="hidden"><c:out value="${aluno.id}"/></td>
				<td id="alunoNome<c:out value="${aluno.id}"/>"><c:out value="${aluno.nome}"/></td>
				<td><c:out value="${aluno.codigoANAC}"/></td>
				<td><c:out value="${aluno.rg}"/></td>
				<td><c:out value="${aluno.cpf}"/></td>
				<td><c:out value="${aluno.escolaridade.descricao}"/></td>
				<td><c:out value="${aluno.tituloEleitor}"/></td>
				<td><c:out value="${aluno.nomePista}"/></td>
				<td><c:out value="${aluno.cht}"/></td>
				<td><c:out value="${aluno.cma}"/></td>
				<td><span class="${aluno.ativo?'icon-check':'icon-check-empty'}"></span></td>
                <td>
                    <span class="icon-edit icon-2x editaAlunoAction" alunoid="<c:out value="${aluno.id}"/>"></span>
                    &nbsp;
                    <span class="icon-remove-circle icon-2x apagaAlunoAction" alunoid="<c:out value="${aluno.id}"/>"></span>
                </td>
			</tr>
		</c:forEach>
        </tbody>
	</table>
    <ul class="pagination pull-right">
        <li class="active">
            <a href="/acsp/alunos?page=1?page.size=5?page.sort=id">1</a>
        </li>
        <li>
            <a href="/acsp/alunos?page=2?page.size=5?page.sort=id">2</a>
        </li>
        <li>
            <a href="/acsp/alunos?page=3?page.size=5?page.sort=id">3</a>
        </li>
        <li>
            <a href="/acsp/alunos?page=4?page.size=5?page.sort=id">4</a>
        </li>
    </ul>

<!-- Button trigger modal -->
<a id="alunoModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Novo Aluno</a>

<c:import url="formulario.jsp"/>

<c:import url="../../includes/footer.jsp"/>