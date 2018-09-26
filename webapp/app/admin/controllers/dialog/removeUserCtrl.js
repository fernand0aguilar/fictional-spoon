'use strict';

angular.module('pinoquio.removeUser', ['pinoquio.employee'])

.controller("RemoveUserCtrl", ["$scope", "$mdDialog", "user", "EmployeSrvc", "$rootScope", function($scope, $mdDialog, user, EmployeSrvc, $rootScope) {
  angular.element(document).ready(function() {
    $scope.username = user.name;
  });
  $scope.date = new Date();

  $scope.removeUser = function() {
    EmployeSrvc.removeUser(user.id, $scope.date).then($scope.removeUserSuccess, $scope.removeUserError);
  }

  $scope.removeUserSuccess = function(resposne) {
    $rootScope.$broadcast('removeUser', {
      userId: user.id
    });
    $mdDialog.hide();
  }

  $scope.removeUserError = function(error) {
    console.error(error);
  }
}])
