"use strict";

angular.module("pinoquio.reports", [])

.config(['$stateProvider', function($stateProvider) {
    $stateProvider.state('main.reports', {
        url: '/reports',
        templateUrl: 'app/common/templates/reports.tpl.html',
        controller: 'ReportsCtrl'
    });
}])

.controller('ReportsCtrl', ['$scope', 'APPINFO', 'RoleSrvc', 'StorageSrvc', function($scope, APPINFO, RoleSrvc, StorageSrvc) {

    $scope.getUrlOfReport = function(type) {
        if (type == 'perVacations') {
            return APPINFO.host + APPINFO.context + type + "?userId=" + StorageSrvc.getUser().id;
        } else {
            return APPINFO.host + APPINFO.context + type;
        }
    }

    $scope.isUserBoss = function() {
        return RoleSrvc.isUserBoss(StorageSrvc.getUser());
    }

}]);
