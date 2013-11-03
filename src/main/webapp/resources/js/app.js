var app = angular.module("app", []);

app .config( function($routeProvider){

});

app.controller('AeronavesController', function($scope, $http){

    $http.get('/acsp/aeronaves').success(function(data) {
        $scope.aeronaves = data;
    });

    $scope.orderProp = 'certificadoMatricula';

    $scope.saveAeronave = function(){
        console.log("Whatever ");
        $scope.aeronaves.push({certificadoMatricula: $scope.certificadoMatricula, marca: $scope.marca, modelo: $scope.modelo});
        $scope.certificadoMatricula = 'FOI';
    };
});