<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>

	<table class="table table-striped table-hover">
        <thead>
        	<th class="hidden">Código</th>
            <th>Cert. Matrícula</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Apólice de Seguro</th>
            <th>Manual de vôo</th>
            <th>Check List</th>
            <th>Diário de Bordo</th>
            <th>Aeronave Ativa</th>
            <th>Motivo de Inatividade</th>
            <th></th>
        </thead>
        <tbody>
		<c:forEach var="aeronave" items="${listaDeAeronaves}">
			<tr id="<c:out value="${aeronave.id}"/>">
                <td class="hidden"><c:out value="${aeronave.id}"/></td>
				<td>${aeronave.certificadoMatricula}</td>
				<td>${aeronave.marca}</td>
                <td id="aeronaveModelo<c:out value="${aeronave.id}"/>"><c:out value="${aeronave.modelo}"/></td>
                <td>${aeronave.apoliceSeguro}</td>
                <td><span class="${aeronave.manualVoo?'icon-check':'icon-check-empty'}"></span></td>
                <td><span class="${aeronave.checkList?'icon-check':'icon-check-empty'}"></span></td>
                <td><span class="${aeronave.diarioBordo?'icon-check':'icon-check-empty'}"></span></td>
                <td><span class="${aeronave.ativo?'icon-check':'icon-check-empty'}"></span></td>
                <td>${aeronave.motivoInatividade}</td>
               <td>
                   <div class="btn-group btn-custom-block">
                       <span class="icon-edit icon-2x editaAction"></span>
                       <span class="icon-remove-circle icon-2x apagaAction"></span>
                   </div>
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