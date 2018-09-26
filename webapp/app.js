'use strict;'

angular.module('pinoquio', [
        'pinoquio-config',
        'ui.router',
        'aeb.http-conector',
        'aeb.filter',
        'ngMaterial',
        'LocalStorageModule',
        'angularMoment',
        'oitozero.ngSweetAlert',
        // 'ngMdIcons',
        // 'ngAnimate',
        // 'aeb.filter',
        // 'aeb.directive',
        'pinoquio.login',
        'pinoquio.leave',
        'pinoquio.authorization',
        'pinoquio.storage',
        'pinoquio.registerUser',
        'pinoquio.registerLocal',
        'pinoquio.listUser',
        'pinoquio.main',
        'pinoquio.maritalStatus',
        'pinoquio.skinColor',
        'pinoquio.uf',
        'pinoquio.phone',
        'pinoquio.city',
        'pinoquio.building',
        'pinoquio.directory',
        'pinoquio.coordination',
        'pinoquio.division',
        'pinoquio.category',
        'pinoquio.role',
        'pinoquio.educationLevel',
        'pinoquio.reports',
        'pinoquio.relative',
        'pinoquio.error',
        'pinoquio.company',
        'pinoquio.healthInsuranceCompany',
        'pinoquio.publicCompany',
        'pinoquio.updateUser',
        'pinoquio.home'
    ])

    // configuring local storage prefix
    .config(['localStorageServiceProvider', function(localStorageServiceProvider) {
        localStorageServiceProvider.setPrefix('pinoquio');
        localStorageServiceProvider.setStorageType('sessionStorage');
    }])

    .config(['$mdDateLocaleProvider', function($mdDateLocaleProvider) {
        $mdDateLocaleProvider.formatDate = function(date) {
            return moment(date).format('L');
        }
        $mdDateLocaleProvider.parseDate = function(dateString) {
            var m = moment(dateString, 'L', true);
            return m.isValid() ? m.toDate() : new Date(NaN);
        };
    }])

    .config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
        // if (localStorage['coolin.userLevel']) {
        //   $urlRouterProvider.otherwise("");
        // } else {
        $urlRouterProvider.otherwise("/login")
        // }
    }])

    .run(function(amMoment) {
        amMoment.changeLocale('pt-br');
    });
