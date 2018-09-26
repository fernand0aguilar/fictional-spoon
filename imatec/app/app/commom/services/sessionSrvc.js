(function() {
    "use strict";

    angular.module("imatec.session", [])

    .constant("SESSION_NAMES", {
        "user": "__user__"
    })

    .factory("SessionSrvc", ["localStorageService", "CryptoSrvc", "SESSION_NAMES", function(localStorageService, CryptoSrvc, SESSION_NAMES) {
        var service = {};

        service.setUser = function(user) {
            var userString = CryptoSrvc.encrypt(JSON.stringify(user));
            localStorageService.set(SESSION_NAMES.user, userString);
        };

        service.getUser = function() {
            return JSON.parse(CryptoSrvc.decrypt(localStorageService.get(SESSION_NAMES)));
        }

        return service;
    }]);
})();
