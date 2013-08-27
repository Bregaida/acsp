<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>

	<table class="table table-striped table-hover">
        <thead>
            <th>Código da Aula</th>
            <th>Matéria</th>
            <th>Quantidade de Horas necessárias para instrutor</th>
            <th>Aeronaves Homologadas</th>
        </thead>

		<c:forEach var="aula" items="${listaDeAulas}" varStatus="status">
			<tr>
                <td>${aula.id}</td>
				<td>${aula.materia }</td>
				<td>${aula.quantidadeHorasNecessarias }</td>
				<td>
					<c:forEach var="aeronave" items="${aula.aeronaves}">
						${aeronave.modelo}&nbsp;
					</c:forEach>
				</td>
				<td>
                    <span id="editar_<c:out value="${aula.id}"/>" class="icon-edit icon-2x editaAulaAction" aulaid="<c:out value="${aula.id}"/>"></span>
                    &nbsp;
                    <span id="apagar_<c:out value="${aula.id}"/>" class="icon-remove-circle icon-2x apagaAulaAction" aulaid="<c:out value="${aula.id}"/>"></span>
                </td>
			</tr>
		</c:forEach>
	</tbody>
	</table>

<!-- Button trigger modal -->
<a id="aulaModalBtn" data-toggle="modal" href="#myModal" class="btn btn-default btn-lg">Adicionar Aula</a>

<%-- Formulario para inserir nova aeronave --%>
<c:import url="formulario.jsp"/>

<c:import url="../../includes/footer.jsp"/>