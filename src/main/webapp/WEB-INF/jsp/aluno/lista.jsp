<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>

	<table class="table table-striped table-hover">
        <thead>
            <th>ID</th>
            <th>Nome do aluno</th>
            <th>Código anac</th>
            <th>RG</th>
            <th>CPF</th>
            <th></th>
        </thead>
        <tbody>
		<c:forEach var="aluno" items="${listaDeAlunos}">
			<tr id="aluno_<c:out value="${aluno.id}"/>">
                <td><c:out value="${aluno.id}"/></td>
				<td id="alunoNome<c:out value="${aluno.id}"/>"><c:out value="${aluno.nome}"/></td>
				<td><c:out value="${aluno.codigoANAC}"/></td>
				<td><c:out value="${aluno.rg}"/></td>
				<td><c:out value="${aluno.cpf}"/></td>
                <td>
                    <div class="btn-group">
                        <input type="button" class="btn btn-default editaAlunoAction" id="editar_<c:out value="${aluno.id}"/>" value="Editar" alunoid="<c:out value="${aluno.id}"/>"/>
                        <input type="button" class="btn btn-default apagaAlunoAction" id="apagar_<c:out value="${aluno.id}"/>" value="Apagar" alunoid="<c:out value="${aluno.id}"/>"/>
                    </div>
                </td>
			</tr>
		</c:forEach>
        </tbody>
	</table>

<!-- Button trigger modal -->
<a id="alunoModalBtn" data-toggle="modal" href="#myModal" class="btn btn-default btn-lg">Novo Aluno</a>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Aluno</h4>
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