(function() {
  "use strict";

  angular.module("imatec.toast", [])

  .factory("ToastSrvc", ["$mdToast", function($mdToast) {
    var service = {};

    service.showToast = function(title, hideDelay) {
      if (hideDelay) {
        // nothing to do.
      } else {
        hideDelay = 3000;
      }

      $mdToast.show({
        templateUrl: 'app/commom/templates/toast/toast.tpl.html',
        hideDelay: hideDelay,
        locals: {
          title: title
        },
        controller: "toastCtrl"
      });
    };

    return service;
  }])

  .controller("toastCtrl", ["$scope", "title", function($scope, title) {
    $scope.title = title
  }]);
})();
