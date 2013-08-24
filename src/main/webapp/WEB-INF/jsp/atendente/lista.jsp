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
                    <div class="btn-group btn-group-sm">
                        <input type="button" class="btn btn-default editaAtendenteAction" id="editar_<c:out value="${atendente.id}"/>" value="Editar" atendenteid="<c:out value="${atendente.id}"/>"/>
                        <input type="button" class="btn btn-default apagaAtendenteAction" id="apagar_<c:out value="${atendente.id}"/>" value="Apagar" atendenteid="<c:out value="${atendente.id}"/>"/>
                    </div>
                </td>
			</tr>
		</c:forEach>
        </tbody>
	</table>

<!-- Button trigger modal -->
<a id="atendenteModalBtn" data-toggle="modal" href="#myModal" class="btn btn-default btn-lg">Novo Atendente</a>

<c:import url="formulario.jsp"/>

<c:import url="../../includes/footer.jsp"/>