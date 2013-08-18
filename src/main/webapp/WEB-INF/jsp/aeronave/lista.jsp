<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>

	<table class="table table-striped table-hover">
        <thead>
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
            <td></td>
        </thead>
        <tbody>
		<c:forEach var="aeronave" items="${listaDeAeronaves}">
			<tr>
                <td>${aeronave.certificadoMatricula}</td>
				<td>${aeronave.marca}</td>
                <td>${aeronave.modelo}</td>
                <td>${aeronave.apoliceSeguro}</td>
                <td>${aeronave.manualVoo}</td>
                <td>${aeronave.checkList}</td>
                <td>${aeronave.diarioBordo}</td>
                <td>${aeronave.ativo}</td>
                <td>${aeronave.motivoInatividade}</td>
                <td>
                    <div class="btn-group">
                        <a class="btn btn-default" href="http://localhost:8080/acsp/aeronave/${aeronave.id}" value="Editar">Editar</a>
                        <a class="btn btn-default" href="http://localhost:8080/acsp/aeronave/${aeronave.id}/apaga" value="Apagar">Apagar</a>
                    </div>
                </td>
			</tr>
		</c:forEach>
        </tbody>
	</table>
<hr/>
<a href="http://localhost:8080/acsp/aeronave" class="btn btn-default btn-lg">Adicionar</a>
<c:import url="../../includes/footer.jsp"/>