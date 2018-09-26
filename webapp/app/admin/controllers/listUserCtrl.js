"use strict";

angular.module("pinoquio.listUser", ["pinoquio.removeUser"])

  .config(['$stateProvider', function($stateProvider) {
    $stateProvider.state('main.listUsers', {
      url: '/listUsers',
      templateUrl: 'app/admin/templates/listUsers.tpl.html',
      controller: 'ListUserCtrl'
    });
  }])

  .controller("ListUserCtrl", ["$scope", "ListUserSrvc", "$mdDialog", "$state", function($scope, ListUserSrvc, $mdDialog, $state) {
    $scope.page = 0;
    $scope.pagePlus1 = 1;
    $scope.userList = [];
    $scope.pages = [];

    $scope.search = {};

    angular.element(document)
      .ready(function() {
        ListUserSrvc.listAll()
          .then($scope.listAllSuccess, $scope.listAllError);
      });

    $scope.listAllSuccess = function(response) {
      $scope.userList = response.data.content;
      $scope.page = response.data.number;
      $scope.pagePlus1 = response.data.number + 1;
      $scope.isFirst = response.data.first;
      $scope.isLast = response.data.last;
      $scope.totalPages = response.data.totalPages;
      $scope.pages = [];

      var counter = 0;
      var starter = $scope.page - 2;
      while (counter < 5) {
        if (starter >= 0) {
          if (starter >= $scope.totalPages) {
            break;
          }
          $scope.pages.push(starter);
          counter++;
        }
        starter++;
      }
    }

    $scope.getTimeOfWork = function(user) {
      var time;

      if (user.exitDate) {
        time = new TimeCounter(user.entryDate, user.exitDate);
      } else {
        var date = new Date();
        time = new TimeCounter(user.entryDate, date.getTime());
      }

      return time.limitedBy();
    }

    $scope.searchEmployee = function() {
      ListUserSrvc.listAllByName($scope.search.word, 0)
        .then($scope.listAllSuccess, $scope.listAllError);
    }

    $scope.searchEmployeeSuccess = function(response) {
      //Nothing to do.
    }

    $scope.searchEmployeeError = function(error) {
      console.error(error);
    }

    $scope.changePage = function(page) {
      if (page >= 0 && page <= $scope.totalPages - 1) {
        if ($scope.search.word) {
          $scope.searchEmployee();
        } else {
          ListUserSrvc.listAll(page)
            .then($scope.listAllSuccess, $scope.listAllError);
        }
      }
    }

    $scope.listAllError = function(error) {
      console.error(error);
    }

    $scope.registerLeave = function(user) {
      $mdDialog.show({
        clickOutsideToClose: true,
        templateUrl: 'app/admin/templates/dialog/registerLeave.tpl.html',
        preserveScope: true,
        locals: {
          user: user
        },
        controller: 'RegisterLeaveCtrl'
      });
    }

    $scope.removeUser = function(user) {
      $mdDialog.show({
          clickOutsideToClose: true,
          templateUrl: 'app/admin/templates/dialog/removeUser.dial.tpl.html',
          preserveScope: true,
          locals: {
            user: user
          },
          controller: 'RemoveUserCtrl'
        })
        .then(function() {
          ListUserSrvc.listAll()
            .then($scope.listAllSuccess, $scope.listAllError);
        });
    }

    $scope.editUser = function(user) {
      $state.go('main.updateUser', {
        userId: user.id
      });
    }

    $scope.changePhone = function(user) {
      $mdDialog.show({
          clickOutsideToClose: true,
          templateUrl: 'app/admin/templates/dialog/insideCommpanyPhone.dial.tpl.html',
          preserveScope: true,
          locals: {
            user: user
          },
          controller: 'InsideCompanyPhoneCtrl'
        })
        .then(function() {
          ListUserSrvc.listAll()
            .then($scope.listAllSuccess, $scope.listAllError);
        });
    }

    $scope.getInsideCompanyPhone = function(phone) {
      if (phone) {
        return phone.number;
      } else {
        return "-"
      }
    }

    $scope.checkIfNumberExists = function(phone) {
      if (phone) {
        return true;
      } else {

        return false;
      }
    }

    $scope.currentDate = function() {
      return new Date();
    }
  }])
