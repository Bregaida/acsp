<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>

	<table class="table table-striped table-hover">
        <thead>
            <td>Código da Aula</td>
            <td>Matéria</td>
            <td>Quantidade de Horas necessárias para instrutor</td>
            <td>Aeronaves Homologadas</td>
        </thead>
		<c:forEach var="aula" items="${listaDeAulas}" varStatus="status">
			
			<tr>
                <td>${aula.id}</td>
				<td>${aula.materia }</td>
				<td>${aula.quantidadeHorasNecessarias }</td>
				<td>
					<c:forEach var="aeronave" items="${aula.aeronaves}">
						${aeronave.modelo }&nbsp;
					</c:forEach>
				</td>
				<td>
                    <div class="btn-group btn-group-sm">
                        <a class="btn btn-default" href="http://localhost:8080/acsp/aula/${aula.id}" value="Editar">Editar</a>
                        <a class="btn btn-default" href="http://localhost:8080/acsp/aula/${aula.id}/apaga" value="Apagar">Apagar</a>
                    </div>
                </td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
<hr/>
<a href="http://localhost:8080/acsp/aula" class="btn btn-default btn-lg">Adicionar</a>
<c:import url="../../includes/footer.jsp"/>