var app = angular.module("app", ['restangular', 'ui.bootstrap']);

app.config( function($routeProvider, RestangularProvider){
    RestangularProvider.setBaseUrl('/acsp/');
});

app.controller('AeronavesController', function($scope, $http, $modal, Restangular){

    $scope.orderProp = 'certificadoMatricula';


    $scope.list = function(){
        $http.get('/acsp/aeronaves').success(function(data) {
            $scope.aeronaves = data;
        });
    }

    $scope.save = function(){
        if($scope.aeronave.id === undefined){
            console.log("adicionando ")
        }
        else {
            console.log("atualizando ")
        }

        Restangular.all('aeronave').post("aeronave", $scope.aeronave).then(function(){
            console.log("Object saved OK");
        }, function(){
            console.log("There was an error saving");
        });
        console.log("Saving " + $scope.aeronave.modelo);
    };

    $scope.disable = function(id){
        console.log("Disabling " + id);
    };

    $scope.load = function(id){
        console.log("Loading " + id);
        Restangular.one("aeronave", id).get().then(function(aeronave) {
            $scope.aeronave = aeronave;
            console.log("carregada " + aeronave.certificadoMatricula);
        });

    };

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