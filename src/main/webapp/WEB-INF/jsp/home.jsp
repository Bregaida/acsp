<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../includes/header.jsp"/>

<div class="row">
    <div class="col-md-8">
        <div id='calendar'></div>
    </div>
    <div class="col-xs-6 col-md-4">
        <h5>Aeronaves disponíveis - hoje</h5>
        <table class="table">
            <thead>
                <td>Aeronave</td>
                <td>Horários</td>
            </thead>
            <tr>
                <td>PT-IZQ - Cherokee</td>
                <td>09-11, 11-12, 13-14, 16-17</td>
            </tr>
            <tr>
                <td>PR-MRG - A330</td>
                <td>13-14, 16-17</td>
            </tr>
        </table>
        <hr/>
        <h5>Instrutores disponíveis - hoje</h5>
        <table class="table">
            <thead>
            <td>Instrutor</td>
            <td>Horários</td>
            </thead>
            <tr>
                <td>Santos Dumont</td>
                <td>09-11, 11-12, 13-14, 16-17</td>
            </tr>
            <tr>
                <td>Barão Vermelho</td>
                <td>13-14, 16-17</td>
            </tr>
        </table>
        <div class="row">
            <div class="col-md-6 pull-left">
            	<!-- Button trigger modal -->
				<a id="agendaModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Novo Agendamento</a>
            </div>
        </div>
    </div>
</div>

<c:import url="/agendamento"/>
<jsp:include page="../includes/footer.jsp"/>