<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../../includes/header.jsp"/>

<div class="clearfix">
    <table class="table table-striped table-hover datatabled">
        <thead>
        <th>Matéria</th>
        <th>Quantidade de Horas necessárias para instrutor</th>
        <th>Aeronaves Homologadas</th>
        <th></th>
        </thead>

        <tbody>
        <c:forEach var="aula" items="${listaDeAulas}" varStatus="status">
            <tr id="<c:out value="${aula.id}"/>">
                <td>${aula.materia }</td>
                <td>${aula.quantidadeHorasNecessarias }</td>
                <td>
                    <c:forEach var="aeronave" items="${aula.aeronaves}">
                        ${aeronave.modelo}&nbsp;
                    </c:forEach>
                </td>
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
</div>

<!-- Button trigger modal -->
<a id="aulaModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Adicionar Aula</a>

<%-- Formulario para inserir nova aeronave --%>
<c:import url="formulario.jsp"/>

<c:import url="../../includes/footer.jsp"/>