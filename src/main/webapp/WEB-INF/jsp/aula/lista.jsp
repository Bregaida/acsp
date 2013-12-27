<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="../../includes/header.jsp"/>

<div ng-controller="AulasController">

    <div ng-init="list()"></div>

    <div class="clearfix">
        <table class="table table-striped table-hover datatabled">
            <thead>
            <th>Matéria</th>
            <th>Quantidade de Horas necessárias para instrutor</th>
            <th>Aeronaves Homologadas</th>
            <th></th>
            </thead>

            <tbody>
                <tr ng-repeat="aula in aulas" ng-click="load(aula.id)" data-toggle="modal" data-target="#myModal">
                    <td>{{aula.materia}}</td>
                    <td>{{aula.quantidadeHorasNecessarias}}</td>
                    <td>
                        //mostrar as aeronaves, aeronaves, aeronaves
                    </td>
                    <td>
                        <div class="btn-group btn-custom-block">
                            <span class="icon-edit icon-2x"></span>
                            <span class="icon-remove-circle icon-2x"></span>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

    <!-- Button trigger modal -->
    <a ng-click="novaAula()" id="aulaModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Adicionar Aula</a>

    <%-- Formulario para inserir nova aeronave --%>
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title"><spring:message code="aula.titulo"/></h4>
                </div>
                <form>
                    <div class="modal-body">
                        <div class="validation_error">
                            <div class="alert alert-danger" ng-repeat="error in validation.data.fieldErrors">
                                {{error.message}}
                            </div>
                            <br/>
                        </div>

                        <hidden ng-model="aula.id"/>


                        <div class="form-group">
                            <label for="materia"><spring:message code="aula.materia"/></label>
                            <input type="text" ng-model="aula.materia" id="materia" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="quantidadeHorasNecessarias"><spring:message code="aula.quantidadeHorasNecessarias"/></label>
                            <input type="text" ng-model="aula.quantidadeHorasNecessarias" id="quantidadeHorasNecessarias" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="aeronave">
                                <spring:message code="aula.aeronaves"/>
                            </label>
                            <ul class="form-inline">
                                <checkboxes ng-model="aula.aeronaves" id="aeronave" items="${listaDeAeronaves}" itemValue="id" element="li class='checkbox-inline'" />
                            </ul>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="btn-group pull-right">
                            <button type="button" class="btn btn-default" data-dismiss="modal">
                                <spring:message code="formulario.botaoFechar"/>
                            </button>
                            <button type="reset" class="btn btn-default" ng-click="cancel()">
                                <spring:message code="formulario.botaoLimpar"/>
                            </button>
                            <button type="button" class="btn btn-primary" ng-click="save()">
                                <spring:message code="formulario.botaoSalvar"/>
                            </button>
                        </div>
                    </div>
                </form>

            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    </div>

<jsp:include page="../../includes/footer.jsp"/>