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
    <a ng-click="newEntity()" id="aulaModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Adicionar Aula</a>

    <%-- Formulario para inserir nova aeronave --%>
    <!-- Modal -->
    <script type="text/ng-template" id="myModalContent.html">
        <div class="modal-dialog" ng-controller="AulasController">
            <div ng-init="loadAeronaves()"></div>
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title"><spring:message code="aula.titulo"/></h4>
                </div>
                <form>
                    <div class="modal-body">
                        <div class="validation_error">
                            <div class="alert alert-danger" ng-repeat="error in validation.fieldErrors">
                                {{error.message}}
                            </div>
                            <br/>
                        </div>

                        <input type="hidden" ng-model="aula.id"/>


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
                            <div ng-repeat="aeronave in aeronaves" class="form-horizontal">
                                <label>
                                <input type="checkbox" class="checkbox-inline"
                                       id="aeronave_{{aeronave.id}}" ng-model="aula.aeronaves" ng-true-value="{{aeronave.id}}"/>
                                {{aeronave.marca}} {{aeronave.modelo}} - {{aeronave.certificadoMatricula}}
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="btn-group pull-right">
                            <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="cancel()">
                                <spring:message code="formulario.botaoFechar"/>
                            </button>
                            <button ng-click="saveAndClose(aula)" aria-hidden="true" type="button" class="btn btn-primary">
                                <spring:message code="formulario.botaoSalvar"/>
                            </button>
                        </div>
                    </div>
                </form>

            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </script>

    </div>

<jsp:include page="../../includes/footer.jsp"/>