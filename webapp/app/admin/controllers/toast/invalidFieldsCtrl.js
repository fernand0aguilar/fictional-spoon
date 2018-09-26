"use strict";

angular.module('pinoquio.registerUser')

.controller("InvalidFieldsCtrl", ['$scope', 'messages', '$mdDialog', function($scope, messages, $mdDialog) {
  $scope.messages = messages;

  $scope.closeDialog = function() {
    $mdDialog.hide();
  }
}]);
