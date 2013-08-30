<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <form:hidden path="id"/>

    <div class="form-group">
        <form:errors path="*" cssClass="help-block alert-danger"/>
    </div>

    <div class="form-group">
        <label for="dataReserva">Dia e mes da reserva</label>
        <form:input path="dataReserva" id="dataReserva" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="aluno">Aluno</label>
        <form:select path="aluno.id" id="aluno" items="${listaDeAlunos}" itemValue="id" itemLabel="nome" cssClass="form-control" />
    </div>

    <div class="form-group">
        <label for="aeronave">Aeronave</label>
        <form:select path="aeronave.id" id="aeronave" items="${listaDeAeronaves}" itemValue="id" itemLabel="modelo" cssClass="form-control" />
    </div>

    <div class="form-group">
        <label>Horas Disponíveis</label>
        <form:select path="horario.id" id="horario" items="${listaDeHorarios}" itemValue="id" itemLabel="horarioAgenda" cssClass="form-control" />
    </div>

    <div class="form-group">
        <label for="qtdeHoras">Quantidade de Horas</label>
        <form:input path="qtdeHoras" id="qtdeHoras" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <label for="aula">Aula</label>
        <form:select path="aula.id" id="aula" items="${listaDeAulas}" itemValue="id" itemLabel="materia" cssClass="form-control" />
    </div>

    <div class="form-group">
        <label for="instrutor">Instrutores Disponíveis</label>
        <form:select path="instrutor.id" id="instrutor" items="${listaDeInstrutores}" itemValue="id" itemLabel="nome" cssClass="form-control" />
    </div>
   
    <div class="checkbox">
        <label>
            <form:checkbox path="flag360milhas" value="true"/>
            360 Milhas
        </label>
    </div>