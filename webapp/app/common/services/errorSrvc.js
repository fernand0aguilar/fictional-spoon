"use strict";

angular.module("pinoquio.error", ['oitozero.ngSweetAlert'])

.factory("ErrorSrvc", ["$mdDialog", "$timeout", "$document", function($mdDialog, $timeout, $document) {
  var service = {};

  service.showError = function(title, message,time) {
    var bodyRef = angular.element($document[0].body);
    bodyRef.addClass("error_overflow");

    $mdDialog.show({
      templateUrl: 'app/common/templates/toast/errorToast.tpl.html',
      locals: {
        title: title,
        message: message
      },
      controller: "errorToastCtrl"
    }).then(function() {
      bodyRef.removeClass("error_overflow");
    });
  }

  return service;
}])

.controller("errorToastCtrl", ["$scope", "$mdDialog", "title", "message", function($scope, $mdDialog, title, message) {
  $scope.title = title;
  $scope.message = message;

  $scope.closeDialog = function() {
    $mdDialog.hide();
  }
}]);
