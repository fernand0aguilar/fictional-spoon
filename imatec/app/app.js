(function() {
    'use strict;'

    angular.module('imatec', [
        // dependencies for the application to run
        'ui.router',
        'ngMaterial',
        'ngMdIcons',
        'ngAnimate',

        // dependencies for storage
        'LocalStorageModule',

        //internal dependencies
        'aeb.http-conector',
        'aeb.filter',
        'aeb.directive',

        // application dependencies
        'config',
        'imatec.crypto',
        'imatec.main',
        'imatec.login',
        'imatec.validation',
        'imatec.session',
        'imatec.register'
    ])

    // configuring local storage prefix
    .config(['localStorageServiceProvider', function(localStorageServiceProvider) {
        // set the prefix for the storage names
        localStorageServiceProvider.setPrefix('imatec');
        // set the type of the storage, default is local
        localStorageServiceProvider.setStorageType('sessionStorage');
    }])

    .config(['$mdDateLocaleProvider', function($mdDateLocaleProvider) {
        // Setting up de locale for date, making it to be formated as it should
        $mdDateLocaleProvider.formatDate = function(date) {
            return moment(date)
                .format('L');
        }
        $mdDateLocaleProvider.parseDate = function(dateString) {
            var m = moment(dateString, 'L', true);
            return m.isValid() ? m.toDate() : new Date(NaN);
        };
    }])

    // setting home page for the application
    .config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
      $urlRouterProvider.when('', '/home');
    }])

})();
