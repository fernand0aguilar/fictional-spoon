(function() {
    "use strict";

    angular.module("imatec.register", [])

    .config(['$stateProvider', function($stateProvider) {
        $stateProvider.state('register', {

            url: '/register',
            templateUrl: 'app/commom/templates/register.tpl.html',
            controller: 'ImatecRegisterCtrl'

        });

    }])

    .controller("ImatecRegisterCtrl", ["$scope", "CryptoSrvc", "RegisterSrvc", "ValidateSrvc", "SessionSrvc", "$state",
        function($scope, CryptoSrvc, RegisterSrvc, ValidateSrvc, SessionSrvc, $state) {

            $scope.registerUser = function() {
              $scope.user.password = CryptoSrvc.sha256Encrypt($scope.user.password);
                RegisterSrvc.register($scope.user).then($scope.registerSuccess, $scope.registerError);
            }

            $scope.registerSuccess = function(response) {
                console.log(response);
                $state.go('main');
                SessionSrvc.setUser($scope.user);

            }

            $scope.registerError = function(error) {
                alert("Houve um problema na requisição de Login.");
                console.log(error);
            }

            $scope.validateRegister = function(user){
              if(user.name == null && user.name.lenght > 16){
                return "Campo invalido";
              } else {
                // Do nothing
              }
            }
        }
    ])
})();
