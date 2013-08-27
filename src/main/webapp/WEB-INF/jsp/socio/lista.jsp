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
                    	<span id="editar_<c:out value="${socio.id}"/>" class="icon-edit icon-2x editaSocioAction" socioid="<c:out value="${socio.id}"/>"></span>
                    	&nbsp;
                    	<span id="apagar_<c:out value="${socio.id}"/>" class="icon-remove-circle icon-2x apagaSocioAction" socioid="<c:out value="${socio.id}"/>"></span>
                	</td>
				</tr>
			</c:forEach>
        </tbody>
	</table>
	<ul class="pagination pull-right">
        <li class="active">
            <a href="/acsp/socios?page=1?page.size=5?page.sort=id">1</a>
        </li>
        <li>
            <a href="/acsp/socios?page=2?page.size=5?page.sort=id">2</a>
        </li>
        <li>
            <a href="/acsp/socios?page=3?page.size=5?page.sort=id">3</a>
        </li>
        <li>
            <a href="/acsp/socios?page=4?page.size=5?page.sort=id">4</a>
        </li>
    </ul>

<!-- Button trigger modal -->
<a id="socioModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Novo Socio</a>

<c:import url="formulario.jsp"/>

<c:import url="../../includes/footer.jsp"/>