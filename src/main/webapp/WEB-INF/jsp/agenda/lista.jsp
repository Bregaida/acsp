<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>
	<table>
		<tr>
			<td>Data de agendamento</td>
			<td>Nome do Aluno</td>
			<td>Instrutor</td>
			<td colspan="3">Aeronave</td> 
			
		</tr>
		
		<c:forEach var="agenda" items="${listaDeAgendas}">
			<tr>
                 <td>${agenda.dataReserva}</td>
				<td>${agenda.aluno.nome }</td>
				<td>${agenda.instrutor.nome }</td>
				<td>${agenda.aeronave.modelo }</td>
		        <td><a href="http://localhost:8080/acsp/agenda/${agenda.id}">EDITAR</a>  ||  </td>
                <td><a href="http://localhost:8080/acsp/agenda/${agenda.id}/apaga">APAGA</a></td>
			</tr>
		</c:forEach>
	</table>
<hr/>
<a href="http://localhost:8080/acsp/agenda">Adicionar</a>
<c:import url="../../includes/footer.jsp"/>