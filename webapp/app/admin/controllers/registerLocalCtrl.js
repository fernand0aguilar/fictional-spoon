"use strict";

angular.module("pinoquio.registerLocal", [])

.config(['$stateProvider', function($stateProvider) {
    $stateProvider.state('main.registerLocal', {
        url: '/registerLocal',
        templateUrl: 'app/admin/templates/registerLocal.tpl.html',
        controller: 'RegisterLocalCtrl'
    });
}])

.controller("RegisterLocalCtrl", ["$scope", "$state", "PhoneSrvc", "RegisterSrvc", "ErrorSrvc", "BuildingSrvc", "$anchorScroll", function($scope, $state, PhoneSrvc, RegisterSrvc, ErrorSrvc, BuildingSrvc, $anchorScroll) {

    $scope.local = {
        registryDate: new Date(),
        phone: {
            phoneCategory:{
              id:4
            }
        }
    };

    angular.element(document)
        .ready(function() {
            BuildingSrvc.getAll()
                .then($scope.getBuildingsSuccess, $scope.getBuildingsError);
            PhoneSrvc.getAllRamal().then($scope.getPhonesSuccess, $scope.getPhonesError);
        });

    $scope.getBuildingsSuccess = function(response) {
        $scope.buildings = response.data;
    };

    $scope.getBuildingsError = function(error) {
        console.log(error);
    };

    $scope.getPhonesSuccess = function(response) {
        $scope.phones = response.data;
    };

    $scope.getPhonesError = function(error) {
        console.log(error);
    };

    $scope.registerLocal = function() {
        $anchorScroll();
        console.log($scope.local);
        RegisterSrvc.validateLocal($scope.local)
            .then($scope.validateLocalSuccess, $scope.validateLocalError);
    };

    $scope.validateLocalSuccess = function(response) {
        if (response.data.length > 0) {
            var parent = angular.element(document.getElementById("main_div"));

            $mdDialog.show({
                templateUrl: 'app/admin/templates/toast/invalidField.toast.tpl.html',
                parent: parent,
                locals: {
                    messages: response.data
                },
                controller: "InvalidFieldsCtrl",
                clickOutsideToClose: true,
                scope: $scope,
                preserveScope: true,
            });
        } else {
            RegisterSrvc.registerLocal($scope.local)
                .then($scope.registerLocalSuccess, $scope.registerLocalError);
        }
    };

    $scope.validateLocalError = function(error) {
        ErrorSrvc.showError("Erro", "Algum campo não está preenchido corretamente");
    };

    $scope.registerLocalSuccess = function() {
        if ($state.params.userId == 0) {
            $state.go("main.home", {}, {
                reload: true
            });
            ErrorSrvc.showError("Local cadastrado com sucesso");
        } else {
            $state.go("main.registerLocal", {}, {
              reload: true
            });
            ErrorSrvc.showError("Local cadastrado com sucesso");
        }
    };

    $scope.registerLocalError = function() {
        $anchorScroll();
        ErrorSrvc.showError("Erro", "Algum campo não está preenchido corretamente");
    };

}])
