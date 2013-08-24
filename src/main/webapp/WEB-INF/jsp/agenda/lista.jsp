<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../../includes/header.jsp"/>

	<table class="table table-striped table-hover">
        <thead>
          	<td>Data de agendamento</td>
			<td>Nome do Aluno</td>
			<td>Instrutor</td>
			<td>Aeronave</td>
			<td></td> 
        </thead>
        <tbody>
		<c:forEach var="agenda" items="${listaDeAgendas}">
			<tr id="agenda_<c:out value="${agenda.id}"/>">
            	<td><fmt:formatDate value="${agenda.dataReserva}" pattern="dd/MM/yyyy" /></td> 
				<td>${agenda.aluno.nome }</td>
				<td>${agenda.instrutor.nome }</td>
				<td>${agenda.aeronave.modelo }</td>
				
                <td>
                    <span id="editar_<c:out value="${agenda.id}"/>" class="icon-edit icon-2x editaAgendaAction" agendaid="<c:out value="${agenda.id}"/>"></span>
                    &nbsp;
                    <span id="apagar_<c:out value="${agenda.id}"/>" class="icon-remove-circle icon-2x apagaAgendaAction" agendaid="<c:out value="${agenda.id}"/>"></span>
                </td>
			</tr>
		</c:forEach>
        </tbody>
	</table>

<!-- Button trigger modal -->
<a id="agendaModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Novo Agendamento</a>

<c:import url="formulario.jsp"/>

<c:import url="../../includes/footer.jsp"/>