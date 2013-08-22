<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>

	<table class="table table-striped table-hover">
        <thead>
            <td>ID</td>
            <td>Número de Inscrição</td>
            <td>Nome do sócio</td>
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
	        <c:forEach var="socio" items="${listaDeSocios}">
				<tr id="socio_<c:out value="${socio.id}"/>">
	                <td><c:out value="${socio.numeroInscricao}"/></td>
					<td><c:out value="${socio.rg}"/></td>
					<td id="socioNome<c:out value="${socio.id}"/>"><c:out value="${socio.nome}"/></td>
					<td><c:out value="${socio.codigoANAC}"/></td>
					<td><c:out value="${socio.rg}"/></td>
					<td><c:out value="${socio.cpf}"/></td>
					<td><c:out value="${socio.escolaridade.descricao}"/></td>
					<td><c:out value="${socio.tituloEleitor}"/></td>
					<td><c:out value="${socio.nomePista}"/></td>
					<td><c:out value="${socio.cht}"/></td>
					<td><c:out value="${socio.cma}"/></td>
					<td><c:out value="${socio.ativo}"/></td>
	                <td>
	                    <div class="btn-group btn-group-sm">
	                        <input type="button" class="btn btn-default editaSocioAction" id="editar_<c:out value="${socio.id}"/>" value="Editar" socioid="<c:out value="${socio.id}"/>"/>
	                        <input type="button" class="btn btn-default apagaSocioAction" id="apagar_<c:out value="${socio.id}"/>" value="Apagar" socioid="<c:out value="${socio.id}"/>"/>
	                    </div>
	                </td>
				</tr>
			</c:forEach>
        </tbody>
	</table>

<!-- Button trigger modal -->
<a id="socioModalBtn" data-toggle="modal" href="#myModal" class="btn btn-default btn-lg">Novo Sócio</a>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Sócio</h4>
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
