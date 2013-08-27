<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>

	<table class="table table-striped table-hover">
        <thead>
        	<td>Código</td>
            <td>Cert. Matrícula</td>
            <td>Marca</td>
            <td>Modelo</td>
            <td>Apólice de Seguro</td>
            <td>Manual de vôo</td>
            <td>Check List</td>
            <td>Diário de Bordo</td>
            <td>Aeronave Ativa</td>
            <td>Motivo de Inatividade</td>
            <td></td>
        </thead>
        <tbody>
		<c:forEach var="aeronave" items="${listaDeAeronaves}">
			<tr id="aeronave_<c:out value="${aeronave.id}"/>">
                <td><c:out value="${aeronave.id}"/></td>
				<td>${aeronave.certificadoMatricula}</td>
				<td>${aeronave.marca}</td>
                <td id="aeronaveModelo<c:out value="${aeronave.id}"/>"><c:out value="${aeronave.modelo}"/></td>
                <td>${aeronave.apoliceSeguro}</td>
                <td>${aeronave.manualVoo}</td>
                <td>${aeronave.checkList}</td>
                <td>${aeronave.diarioBordo}</td>
                <td>${aeronave.ativo}</td>
                <td>${aeronave.motivoInatividade}</td>
               <td>
                    <span class="icon-edit icon-2x editaAeronaveAction" aeronaveid="<c:out value="${aeronave.id}"/>"></span>
                    &nbsp;
                    <span class="icon-remove-circle icon-2x apagaAeronaveAction" aeronaveid="<c:out value="${aeronave.id}"/>"></span>
                </td>
			</tr>
		</c:forEach>
        </tbody>
	</table>
    <ul class="pagination pull-right">
        <li class="active">
            <a href="/acsp/aeronaves?page=1?page.size=5?page.sort=id">1</a>
        </li>
        <li>
            <a href="/acsp/aeronaves?page=2?page.size=5?page.sort=id">2</a>
        </li>
        <li>
            <a href="/acsp/aeronaves?page=3?page.size=5?page.sort=id">3</a>
        </li>
        <li>
            <a href="/acsp/aeronaves?page=4?page.size=5?page.sort=id">4</a>
        </li>
    </ul>

<!-- Button trigger modal -->
<a id="aeronaveModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Nova Aeronave</a>

<c:import url="formulario.jsp"/>

<c:import url="../../includes/footer.jsp"/>