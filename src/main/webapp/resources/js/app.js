var app = angular.module("app", ['restangular', 'ui.bootstrap']);

app.config( function($routeProvider, RestangularProvider){
    RestangularProvider.setBaseUrl('/acsp/');
});

app.controller('InstrutoresController', function($scope, $http, $modal, Restangular){

    $scope.list = function(){
        $http.get('/acsp/instrutores').success(function(data) {
            $scope.instrutores = data;
        });
    }

    $scope.save = function(){
        Restangular.all('instrutor').post("instrutor", $scope.instrutor).then(function(){
            console.log("Object saved OK");
        }, function(){
            console.log("There was an error saving");
        });
        $scope.list();
    };

    //TODO: create directive
    $scope.style = function(stat){
        if(stat) {
            return "fa fa-check-circle-o fa-lg";
        }{
            return "fa fa-circle-o fa-lg";
        }
    };

    $scope.novoInstrutor = function () {
        $scope.instrutor = null;
    };

});

app.controller('AeronavesController', function($scope, $http, $modal, Restangular){

    $scope.orderProp = 'certificadoMatricula';

    $scope.list = function(){
        $http.get('/acsp/aeronaves').success(function(data) {
            $scope.aeronaves = data;
        });
    }

    $scope.save = function(){
        Restangular.all('aeronave').post("aeronave", $scope.aeronave).then(function(){
            console.log("Object saved OK");
        }, function(){
            console.log("There was an error saving");
        });
        $scope.list();
    };

    $scope.disable = function(id){
        Restangular.one("aeronave", id).remove();
    };

    $scope.load = function(id){
        Restangular.one("aeronave", id).get().then(function(aeronave) {
            $scope.aeronave = aeronave;
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

    $scope.novaAeronave = function () {
        $scope.aeronave = null;
    };


});

app.controller('AlunosController', function($scope, $http, $modal, Restangular){

    $scope.orderProp = 'nome';


    $scope.list = function(){
        $http.get('/acsp/alunos').success(function(data) {
            $scope.alunos = data;
        });
    }

    $scope.save = function(){
        Restangular.all('aluno').post("aluno", $scope.aluno).then(function(){
            console.log("Object saved OK");
        }, function(){
            console.log("There was an error saving");
        });
        $scope.list();
    };

    $scope.disable = function(id){
        console.log("Disabling " + id);
        Restangular.one("aluno", id).remove();
    };

    $scope.load = function(id){
        Restangular.one("aluno", id).get().then(function(aeronave) {
            $scope.aluno = aluno;
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

    $scope.novoAluno = function () {
        $scope.aluno = null;
    };

});

app.controller('SociosController', function($scope, $http, $modal, Restangular){

    $scope.orderProp = 'nome';


    $scope.list = function(){
        $http.get('/acsp/socios').success(function(data) {
            $scope.socios = data;
        });
    }

    $scope.save = function(){
        Restangular.all('socio').post("socio", $scope.socio).then(function(){
            console.log("Object saved OK");
        }, function(){
            console.log("There was an error saving");
        });
        $scope.list();
    };

    $scope.disable = function(id){
        console.log("Disabling " + id);
        Restangular.one("socio", id).remove();
    };

    $scope.load = function(id){
        Restangular.one("socio", id).get().then(function(aeronave) {
            $scope.socio = socio;
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

    $scope.novoSocio = function () {
        $scope.socio = null;
    };
});

app.controller('AtendentesController', function($scope, $http, $modal, Restangular){

    $scope.orderProp = 'nome';

    $scope.list = function(){
        $http.get('/acsp/atendentes').success(function(data) {
            $scope.atendentes = data;
        });
    }

    $scope.save = function(){
        Restangular.all('atendente').post("atendente", $scope.atendente).then(function(){
            console.log("Object saved OK");
        }, function(){
            console.log("There was an error saving");
        });
        $scope.list();
    };

    $scope.disable = function(id){
        console.log("Disabling " + id);
        Restangular.one("atendente", id).remove();
    };

    $scope.load = function(id){
        Restangular.one("atendente", id).get().then(function(aeronave) {
            $scope.atendente = socio;
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

    $scope.novoAtendente = function () {
        $scope.atendente = null;
    };
});