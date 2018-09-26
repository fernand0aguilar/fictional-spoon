(function() {
  'use strict';
  // this function is strict...
}());

angular.module("pinoquio.updateUser", [])

  .config(['$stateProvider', function($stateProvider) {
    $stateProvider.state('main.updateUser', {
      url: '/updateUser/:userId',
      templateUrl: 'app/admin/templates/updateUser.tpl.html',
      controller: 'UpdateUserCtrl'
    });
  }])

  .controller("UpdateUserCtrl", ["$scope", "$state", "$stateParams", "EmployeSrvc", "ErrorSrvc", "$anchorScroll", function($scope, $state, $stateParams, EmployeSrvc, ErrorSrvc, $anchorScroll) {

    $scope.user = {
      filiation: {},
      rg: {
        expeditionDate: new Date(),
      },
      birthDate: new Date(),
      entryDate: new Date(),
      insideCompanyPhone: {
        phoneCategory: {
          id: 4
        }
      },
      outsideEmployee: {
        cltExpedition: new Date(),
        entryDate: new Date(),
      },
      publicEmployee: {
        incomeDate: new Date(),
        nominationDate: new Date(),
        publicationDate: new Date(),
      },
      laborData: {
        firstJob: new Date(),
      },
      spouse: {
        birthDate: new Date(),
      },
      healthInsurance: {
        expirationDate: new Date(),
      },

    };

    $scope.findEmployeeSuccess = function(response) {
      $scope.user = response.data;

      if ($scope.user.entryDate) {
        $scope.user.entryDate = new Date($scope.user.entryDate);
      }

      if ($scope.user.registryDate) {
        $scope.user.registryDate = new Date($scope.user.registryDate);
      }

      if ($scope.user.birthDate) {
        $scope.user.birthDate = new Date($scope.user.birthDate);
      }

      if ($scope.user.rg.expeditionDate) {
        $scope.user.rg.expeditionDate = new Date($scope.user.rg.expeditionDate);
      }

      if ($scope.user.healthInsurance) {
        if ($scope.user.healthInsurance.expirationDate) {
          $scope.user.healthInsurance.expirationDate = new Date($scope.user.healthInsurance.expirationDate);
        }
      }

      if ($scope.user.laborData) {
        if ($scope.user.laborData.firstJob) {
          $scope.user.laborData.firstJob = new Date($scope.user.laborData.firstJob);
        }
      }
    };

    $scope.findEmployeeError = function(error) {
      console.error(error);
    };

    EmployeSrvc.findEmployee($stateParams.userId)
      .then($scope.findEmployeeSuccess, $scope.findEmployeeError);

  }]);
