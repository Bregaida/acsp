<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="../../includes/header.jsp"/>

<div class="clearfix">

    <table class="table table-striped table-hover datatabled">
        <thead>
            <th class="hidden">Código</th>
            <th><spring:message code="aeronave.certificadoMatricula"/></th>
            <th><spring:message code="aeronave.marca"/></th>
            <th><spring:message code="aeronave.modelo"/></th>
            <th><spring:message code="aeronave.manualVoo"/></th>
            <th><spring:message code="aeronave.checkList"/></th>
            <th><spring:message code="aeronave.diarioBordo"/></th>
            <th><spring:message code="aeronave.ativo"/></th>
            <th></th>
        </thead>
        <tbody ng-controller="AeronavesController">
            <tr ng-repeat="aeronave in aeronaves">
                <td class="hidden">{{aeronave.id}}</td>
                <td>{{aeronave.certificadoMatricula}}</td>
                <td>{{aeronave.marca}}</td>
                <td>{{aeronave.modelo}}</td>
                <td>{{aeronave.manualVoo}}</td>
                <td>{{aeronave.checkList}}</td>
                <td>{{aeronave.diarioBordo}}</td>
                <td>{{aeronave.ativo}}</td>
                <!-- 'icon-check':'icon-check-empty' -->
                <td>
                    <div class="btn-group btn-custom-block">
                        <span class="icon-edit icon-2x editaAction"></span>
                        <span class="icon-remove-circle icon-2x apagaAction"></span>
                    </div>
                </td>
            </tr>
        </tbody>
    </table>
</div>

<!-- Button trigger modal -->
<a id="aeronaveModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Nova Aeronave</a>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title"><spring:message code="aeronave.titulo"/></h4>
            </div>

            <form ng-submit="saveAeronave()">
                <div class="modal-body">

                    <input type="hidden" name="id" ng-model="aeronave.id"/>

                    <div class="form-group">
                        <label for="certificadoMatricula"><spring:message code="aeronave.certificadoMatricula"/></label>
                        <input name="certificadoMatricula" id="certificadoMatricula" class="form-control" ng-model="certificadoMatricula"/>
                    </div>

                    <div class="form-group">
                        <label for="marca"><spring:message code="aeronave.marca"/></label>
                        <input name="marca" id="marca" class="form-control" ng-model="marca"/>
                    </div>

                    <div class="form-group">
                        <label for="modelo"><spring:message code="aeronave.modelo"/></label>
                        <input name="modelo" id="modelo" class="form-control" ng-model="modelo"/>
                    </div>

                    <div class="form-group">
                        <label for="dentel"><spring:message code="aeronave.dentel"/></label>
                        <input name="dentel" id="dentel" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="fiam"><spring:message code="aeronave.fiam"/></label>
                        <input name="fiam" id="fiam" class="form-control"/>
                    </div>

                    <div class="form-group">
                        <label for="apoliceSeguro"><spring:message code="aeronave.apoliceSeguro"/></label>
                        <input type="text" name="apoliceSeguro" id="apoliceSeguro" class="form-control"/>
                    </div>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="fichaPesoBalanceamento" value="true" id="fichaPesoBalanceamento" />
                            <spring:message code="aeronave.fichaPesoBalanceamento"/>
                        </label>
                    </div>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="manualVoo" value="true" id="manualVoo" />
                            <spring:message code="aeronave.manualVoo"/>
                        </label>
                    </div>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="checkList" value="true" id="checkList" />
                            <spring:message code="aeronave.checkList"/>
                        </label>
                    </div>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="nsca3_5" value="true" id="nsca3_5" />
                            <spring:message code="aeronave.nsca3_5"/>
                        </label>
                    </div>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="nsca3_7" value="true" id="nsca3_7" />
                            <spring:message code="aeronave.nsca3_7"/>
                        </label>
                    </div>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="diarioBordo" value="true" id="diarioBordo" />
                            <spring:message code="aeronave.diarioBordo"/>
                        </label>
                    </div>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="ativo" value="true" id="ativo" />
                            <spring:message code="aeronave.ativo"/>
                        </label>
                    </div>

                    <div class="form-group">
                        <label for="motivoInatividade"><spring:message code="aeronave.motivoInatividade"/></label>
                        <input type="text" name="motivoInatividade" id="motivoInatividade" class="form-control"/>
                    </div>

                </div>
                <div class="modal-footer">
                    <div class="btn-group pull-right">
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            <spring:message code="formulario.botaoFechar"/>
                        </button>
                        <button type="reset" class="btn btn-default">
                            <spring:message code="formulario.botaoLimpar"/>
                        </button>
                        <input type="submit" value="<spring:message code="formulario.botaoSalvar"/>"/>
                    </div>
                </div>
            </form>

        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<jsp:include page="../../includes/footer.jsp"/>