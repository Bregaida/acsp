'use strict';

var app = angular.module("app", ['ngRoute', 'restangular', 'ui.bootstrap']);

app.config( function($routeProvider, RestangularProvider){
    RestangularProvider.setBaseUrl('/acsp/');
});

app.controller('GenericController', function($scope, $http, $modal, Restangular){

    $scope.entityType =  null;  //type will be aeronave, for example
    $scope.entitiesType = null; //type will be aeronaves, for example

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

    $scope.loadEducationLevels = function(){
        $http.get('/acsp/escolaridades').success(function(data) {
            $scope.educationLevels = data;
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
            $scope.validation = null;
            $scope.entity = anEntity;
            Restangular.all(entityType).post(entityType, anEntity).then(function(){
                $modalInstance.close(anEntity);
            }, function(error){
                $scope.validation = error.data;
            });
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };

});


app.controller('AulasController', function($scope, $http, $modal, Restangular){

    $scope.disable = function(id){
        Restangular.one("aula", id).remove();
    };

    $scope.list = function(){
        $http.get('/acsp/aulas').success(function(data) {
            $scope.aulas = data;
            for(var i=0; i < $scope.aulas.length; i++){
                var aula = $scope.aulas[i];
                aula.planes = "";
                for(var p=0; p < aula.aeronaves.length; p++){
                    aula.planes = aula.planes + aula.aeronaves[p].certificadoMatricula + ", ";
                }
            }
        });
    }

    $scope.loadAeronaves = function(){
        $http.get('/acsp/aeronaves').success(function(data){
            $scope.aeronaves = data;
            for(var i=0; i< $scope.aeronaves.length; i++){
                var plane = $scope.aeronaves[i];
                $scope.aeronaves[i].displayName = plane.certificadoMatricula + " - " +  plane.marca + " " + plane.modelo;
            }
        });
    }

    $scope.load = function (id) {

        Restangular.one("aula", id).get().then(function(entity) {
            $scope.aula = entity;

            var modalInstance = $modal.open({
                templateUrl: 'myModalContent.html',
                controller: ModalInstanceCtrl,
                resolve: {
                    aula: function () {
                        return $scope.aula;
                    },
                    aeronaves: function(){
                        return $scope.aeronaves;
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

    $scope.estaSelecionado = function(id){
        for(var i = 0; i < $scope.aula.aeronaves.length; i++){
            var aeronaveDaAula = $scope.aula.aeronaves[i];
            if(aeronaveDaAula.id == id){
                return true;
            }
        }
        return false;
    };

    $scope.newEntity = function () {
        $scope.entity = null;
        var modalInstance = $modal.open({
            templateUrl: 'myModalContent.html',
            controller: ModalInstanceCtrl,
            resolve: {
                aula: function () {
                    return $scope.aula;
                },
                aeronaves: function(){
                    return $scope.aeronaves;
                }
            }
        });

        modalInstance.result.then(function (entity) {
            $scope.list();
        }, function () {
            $scope.entity = null;
        });
    };

    var ModalInstanceCtrl = function ($scope, $modalInstance, aula, aeronaves) {

        $scope.aula = aula;

        $scope.saveAndClose = function (anEntity) {
            $scope.validation = null;
            Restangular.all("aula").post("aula", anEntity).then(function(){
                $modalInstance.close(anEntity);
            }, function(error){
                $scope.validation = error.data;
            });
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    };
});
