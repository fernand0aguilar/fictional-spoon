"use strict";

angular.module("pinoquio.leave", [])

.controller("RegisterLeaveCtrl", ["$scope", "EmployeSrvc", "$stateParams", "$mdDialog", "user", "LeaveSrvc", function($scope, EmployeSrvc, $stateParams, $mdDialog, user, LeaveSrvc) {

  angular.element(document).ready(function() {
    LeaveSrvc.getLeaveTypes().then($scope.getLeaveTypesSuccess, $scope.getLeaveTypesError);
  });

  $scope.getLeaveTypesSuccess = function(response) {
    $scope.leaveTypes = response.data;
    console.log(response);
  }

  $scope.getLeaveTypesError = function(error) {
    console.error(error);
  }

  $scope.leave = {
    date: new Date(),
    endDate: new Date()
  };

  $scope.showInterval = false;

  angular.element(document).ready(function() {
    $scope.employee = user;
  });

  $scope.calculate = function() {
    LeaveSrvc.calculateLeave($scope.leave).then($scope.calculateLeaveSuccess, $scope.calculateLeaveError);
  }

  $scope.calculateLeaveSuccess = function(response) {
    $scope.leave = response.data;
    $scope.showInterval = true;
  }

  $scope.calculateLeaveError = function(error) {
    console.error(error);
  }

  $scope.confirm = function() {
    var leave = $scope.leave;
    var justify = $scope.parseJustify(leave.justify);
    if (justify) {
      LeaveSrvc.registerLeave(leave.beginDate, leave.numberOfDays, user.id, justify).then($scope.registerLeaveSuccess, $scope.registerLeaveError);
    } else {
      // nothing
    }
  }

  $scope.parseJustify = function(justify) {
    var code = justify.split(" - ")[0];
    for (var leaveType in $scope.leaveTypes) {
      var checkJustify = $scope.leaveTypes[leaveType];
      if (checkJustify.code == code) {
        return checkJustify;
      } else {
        // nothing to do.
      }
    }
  }

  $scope.registerLeaveSuccess = function(response) {
    $mdDialog.hide();
    console.log(response);
  }
  $scope.registerLeaveError = function(error) {
    console.error(error);
  }
}])
