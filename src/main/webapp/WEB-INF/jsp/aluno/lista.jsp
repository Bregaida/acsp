<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>

	<table class="table table-striped table-hover">
        <thead>
            <td>ID</td>
            <td>Nome do aluno</td>
            <td>Código anac</td>
            <td>RG</td>
            <td>CPF</td>
            <td>Escolaridade</td>
            <td>Título de Eleitor</td>
            <td>Nome de Pista</td>
            <td>CHT</td>
            <td>CMA</td>
            <td>Ativo</td>
            <td></td>
        </thead>
        <tbody>
		<c:forEach var="aluno" items="${listaDeAlunos}">
			<tr id="aluno_<c:out value="${aluno.id}"/>">
                <td><c:out value="${aluno.id}"/></td>
				<td id="alunoNome<c:out value="${aluno.id}"/>"><c:out value="${aluno.nome}"/></td>
				<td><c:out value="${aluno.codigoANAC}"/></td>
				<td><c:out value="${aluno.rg}"/></td>
				<td><c:out value="${aluno.cpf}"/></td>
				<td><c:out value="${aluno.escolaridade.descricao}"/></td>
				<td><c:out value="${aluno.tituloEleitor}"/></td>
				<td><c:out value="${aluno.nomePista}"/></td>
				<td><c:out value="${aluno.cht}"/></td>
				<td><c:out value="${aluno.cma}"/></td>
				<td><c:out value="${aluno.ativo}"/></td>
                <td>
                    <span id="editar_<c:out value="${aluno.id}"/>" class="icon-edit icon-2x editaAlunoAction" alunoid="<c:out value="${aluno.id}"/>"></span>
                    &nbsp;
                    <span id="apagar_<c:out value="${aluno.id}"/>" class="icon-remove-circle icon-2x apagaAlunoAction" alunoid="<c:out value="${aluno.id}"/>"></span>
                </td>
			</tr>
		</c:forEach>
        </tbody>
	</table>

<!-- Button trigger modal -->
<a id="alunoModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Novo Aluno</a>

<c:import url="formulario.jsp"/>

<c:import url="../../includes/footer.jsp"/>