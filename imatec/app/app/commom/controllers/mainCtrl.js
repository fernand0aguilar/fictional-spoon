(function() {
  "use strict";

  angular.module("imatec.main", ["imatec.home", "imatec.toast"])

  .config(['$stateProvider', function($stateProvider) {
    $stateProvider.state('main', {
      url: '/main',
      templateUrl: 'app/commom/templates/main.tpl.html',
      controller: 'ImatecMainCtrl',
      data: {
        authorization: true,
        redirectTo: 'login'
      }
    });
  }])

  .controller("ImatecMainCtrl", ["$scope", function($scope) {

  }]);
})();
