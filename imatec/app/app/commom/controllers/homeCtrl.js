(function() {
  "use strict";

  angular.module("imatec.home", [])

  .config(['$stateProvider', function($stateProvider) {
    $stateProvider.state('home', {
      url: '/home',
      templateUrl: 'app/commom/templates/home.tpl.html',
      controller: 'HomeCtrl'
    });
  }])

  .controller("HomeCtrl", ["$scope", "$window","ToastSrvc", function($scope, $window, ToastSrvc) {
    $scope.showToast = function() {
      ToastSrvc.showToast("AEB", 2000);
    }

    $scope.showLogin = function($window) {
      
    }
  }]);
})();
