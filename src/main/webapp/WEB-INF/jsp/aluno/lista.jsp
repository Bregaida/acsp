<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<jsp:include page="../../includes/header.jsp"/>

<div ng-controller="AlunosController">

    <div ng-init="list()"></div>

    <div class="clearfix">
        <table class="table table-striped table-hover table-condensed datatabled">
            <thead>
            <th>Nome do aluno</th>
            <th>Código anac</th>
            <th>CPF</th>
            <th>Nome de Pista</th>
            <th>CHT</th>
            <th>CMA</th>
            <th>Ativo</th>
            <th></th>
            </thead>
            <tbody>
                <tr ng-repeat="aluno in alunos">
                    <td>{{aluno.nome}}</td>
                    <td>{{aluno.codigoANAC}}</td>
                    <td>{{aluno.cpf}}</td>
                    <td>{{aluno.nomePista}}</td>
                    <td>{{aluno.cht}}</td>
                    <td>{{aluno.cma}}</td>
                    <td><i ng-class="style(aluno.ativo)"></i> </td>
                    <td>
                        <div class="btn-group btn-custom-block">
                            <span class="icon-edit icon-2x"></span>
                            <span class="icon-remove-circle icon-2x"></span>
                            <span class="icon-plane icon-2x"></span>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>

    <!-- Button trigger modal -->
    <a ng-click="novoAluno()" id="alunoModalBtn" data-toggle="modal" href="#myModal" class="btn btn-primary btn-lg">Novo Aluno</a>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title"><spring:message code="aluno.titulo"/></h4>
                </div>
                <form>
                    <div class="modal-body">


                        <input type="hidden" id="id" ng-model="aluno.id"/>

                        <div class="form-group">
                            <label for="nome"><spring:message code="aluno.nome"/></label>
                            <input type="text" ng-model="aluno.nome" id="nome" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="rg"><spring:message code="aluno.rg"/></label>
                            <input type="text" ng-model="aluno.rg" id="rg" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="cpf"><spring:message code="aluno.cpf"/></label>
                            <input type="text" ng-model="aluno.cpf" id="cpf" class="form-control cpf" size="14" maxlength="14"/>
                        </div>

                        <div class="form-group">
                            <label for="alistamentoMilitar"><spring:message code="aluno.alistamentoMilitar"/></label>
                            <input type="text" ng-model="aluno.alistamentoMilitar" id="alistamentoMilitar" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="escolaridade"><spring:message code="aluno.Escolaridade"/></label>
                            <select items="${escolaridades}" ng-model="aluno.escolaridade" id="escolaridade" itemValue="id" itemLabel="descricao" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="tituloEleitor"><spring:message code="aluno.tituloEleitor"/></label>
                            <input type="text" ng-model="aluno.tituloEleitor" id="tituloEleitor" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="codigoANAC"><spring:message code="aluno.codigoANAC"/></label>
                            <input type="text" ng-model="aluno.codigoANAC" id="codigoANAC" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="nomePista"><spring:message code="aluno.nomePista"/></label>
                            <input type="text" ng-model="aluno.nomePista" id="nomePista" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="cht"><spring:message code="aluno.CHT"/></label>
                            <input type="text" ng-model="aluno.cht" id="cht" class="form-control"/>
                        </div>

                        <div class="form-group">
                            <label for="cma"><spring:message code="aluno.CMA"/></label>
                            <input type="text" ng-model="aluno.cma" id="cma" class="form-control"/>
                        </div>

                        <div class="checkbox">
                            <label for="ativo">
                                <checkbox ng-model="aluno.ativo" id="ativo"/>
                                <spring:message code="aluno.ativo"/>
                            </label>
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
                            <button type="button" class="btn btn-primary insereAction">
                                <spring:message code="formulario.botaoSalvar"/>
                            </button>
                        </div>
                    </div>
                </form>

            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <!-- Modal -->
    <div class="modal fade" id="aeronaveModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title"><spring:message code="aluno.titulo"/></h4>
                </div>
                <form>
                    <div class="modal-body">
                        <hidden ng-model="aluno.id"/>

                        <div class="form-group">
                            <label for="aeronave"><spring:message code="aluno.aeronaves"/></label>
                            <ul class="form-inline">
                                <checkboxes ng-model="aluno.aeronaves" id="aeronave" items="${listaDeAeronaves}" itemValue="id" element="li class='checkbox-inline'" />
                            </ul>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="btn-group pull-right">
                            <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="cancel()">
                                <spring:message code="formulario.botaoFechar"/>
                            </button>
                            <button type="reset" class="btn btn-default" ng-click="cancel()">
                                <spring:message code="formulario.botaoLimpar"/>
                            </button>
                            <button type="button" class="btn btn-primary" data-dismiss="modal" ng-click="save()">
                                <spring:message code="formulario.botaoSalvar"/>
                            </button>
                        </div>
                    </div>
                </form>

            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    </div>
</div>

<jsp:include page="../../includes/footer.jsp"/>