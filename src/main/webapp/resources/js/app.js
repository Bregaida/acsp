'use strict';

var app = angular.module("app", ['ngRoute', 'restangular', 'ui.bootstrap']);

app.config( function($routeProvider, RestangularProvider){
    RestangularProvider.setBaseUrl('/acsp/');
});

app.controller('GenericController', function($scope, $http, $modal, Restangular){

    $scope.orderProp = 'certificadoMatricula';
    $scope.entityType =  null;//type will be aeronave, for example
    $scope.entitiesType = null;//type will be aeronaves, for example

    $scope.setEntitiesType = function(entitiesType){
        $scope.entitiesType = entitiesType;
    }

    $scope.setEntityType = function(entityType){
        $scope.entityType = entityType;
    }

    $scope.list = function(){
        $http.get('/acsp/' + $scope.entitiesType).success(function(data) {
            $scope.entities = data;
        });
    }

    $scope.disable = function(id){
        Restangular.one($scope.entityType, id).remove();
    }

    //TODO: create directive
    $scope.style = function(stat){
        if(stat) {
            return "fa fa-check-circle-o fa-lg";
        }{
            return "fa fa-circle-o fa-lg";
        }
    };

    $scope.newEntity = function () {
        $scope.entity = null;
        var modalInstance = $modal.open({
            templateUrl: 'myModalContent.html',
            controller: ModalInstanceCtrl,
            resolve: {
                entity: function () {
                    return $scope.entity;
                },
                save: function(){
                    return $scope.save;
                },
                entityType: function(){
                    return $scope.entityType;
                }
            }
        });

        modalInstance.result.then(function (entity) {
            $scope.list();
        }, function () {
            $scope.entity = null;
        });
    };

    $scope.load = function (id) {

        Restangular.one($scope.entityType, id).get().then(function(entity) {
            $scope.entity = entity;

            var modalInstance = $modal.open({
                templateUrl: 'myModalContent.html',
                controller: ModalInstanceCtrl,
                resolve: {
                    entity: function () {
                        return entity;
                    },
                    save: function(){
                        return $scope.save;
                    },
                    entityType: function(){
                        return $scope.entityType;
                    }
                }
            });

            modalInstance.result.then(function (entity) {//When the modal closes with SAVE
                $scope.list();
            }, function () {//on dismiss
                $scope.entity = null;
            });
        });
    };

    var ModalInstanceCtrl = function ($scope, $modalInstance, entity, entityType) {

        $scope.entity = entity;

        $scope.saveAndClose = function (anEntity) {
            $scope.entity = anEntity;
            Restangular.all(entityType).post(entityType, anEntity).then(function(){
                $modalInstance.close(anEntity);
            }, function(){
                console.log("There was an error saving " + anEntity);
            });
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };

});


app.controller('AulasController', function($scope, $http, $modal, Restangular){

    $scope.orderProp = 'materia';

    $scope.list = function(){
        $http.get('/acsp/aulas').success(function(data) {
            $scope.aulas = data;
        });
    }

    $scope.save = function(){
        Restangular.all('aula').post("aula", $scope.aula).then(function(){
            console.log("Object saved OK");
        }, function(){
            console.log("There was an error saving");
        });
        $scope.list();
    };

    $scope.disable = function(id){
        console.log("Disabling " + id);
        Restangular.one("aula", id).remove();
    };

    $scope.load = function(id){
        Restangular.one("aula", id).get().then(function(aula) {
            $scope.aula = aula;
        });

    };

    //TODO: create directive
    $scope.style = function(stat){
        if(stat) {
            return "fa fa-check-circle-o fa-lg";
        }{
            return "fa fa-circle-o fa-lg";
        }
    };

    $scope.novaAula = function () {
        $scope.aula = null;
    };

});
