(function() {
    "use strict";

    angular.module("imatec.login", [])

    .config(['$stateProvider', function($stateProvider) {

        $stateProvider.state('login', {

            url: '/login',
            templateUrl: 'app/commom/templates/login.tpl.html',
            controller: 'ImatecLoginCtrl'

        });

    }])

    .controller("ImatecLoginCtrl", ["$scope", "CryptoSrvc", "LoginSrvc", "ValidateSrvc", "SessionSrvc", "$state", function($scope, CryptoSrvc, LoginSrvc, ValidateSrvc, SessionSrvc, $state) {

        $scope.user = {};

        angular.element(document)
            .ready(function() {

            });

        $scope.executeLogin = function() {
            if ($scope.validateLoginFields) {
                $scope.user.password = CryptoSrvc.sha256Encrypt($scope.user.password);

                LoginSrvc.login($scope.user)
                    .then($scope.loginSuccess, $scope.loginError);
            } else {
                // nothing to do.
            }
        }

        $scope.validateLoginFields = function() {
            var messages = [];
            if (!ValidateSrvc.email($scope.user.login)) {
                messages.push("Email inválido");
            }
            if (!ValidateSrvc.password($scope.user.password)) {
                messages.push("Senha inválida");
            }

            if (messages.length == 0) {
                return true;
            } else {
                // TODO: Alert about invalid fields
                return false;
            }
        }

        $scope.loginSuccess = function(response) {
            CryptoSrvc.criptPhrase = $scope.user.password;
            SessionSrvc.setUser($scope.user);
            $scope.user = {};

            $state.go("main");
        }

        $scope.loginError = function(error) {
            console.error(error);
        }

    }]);

})();
