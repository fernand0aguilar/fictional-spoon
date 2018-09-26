'use strict';

angular.module('pinoquio.phone', [])

    .controller("InsideCompanyPhoneCtrl", ["$scope", "$mdDialog", "user", "EmployeSrvc", "$rootScope", function($scope, $mdDialog, user, EmployeSrvc, $rootScope) {
        angular.element(document)
            .ready(function() {
                if (user.insideCompanyPhone) {
                    $scope.phone = user.insideCompanyPhone;
                } else {
                    $scope.phone = {};
                }
            });

        $scope.registerPhone = function() {
            EmployeSrvc.createInsideCompanyPhone(user.id, $scope.phone)
                .then($scope.saveInsideCompanyInfoSuccess, $scope.saveInsideCompanyInfoError);
        }

        $scope.saveInsideCompanyInfoSuccess = function(resposne) {
            $rootScope.$broadcast('insideCompanyPhoneChanged', {
                userId: user.id,
                phone: $scope.phone.number
            });
            $mdDialog.hide();
        }

        $scope.saveInsideCompanyInfoError = function(error) {
            console.error(error);
        }
    }])
