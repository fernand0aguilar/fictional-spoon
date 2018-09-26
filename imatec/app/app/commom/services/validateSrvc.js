(function() {
    "use strict";

    angular.module("imatec.validation", [])

    .factory("ValidateSrvc", [function() {
        var service = {};
        var EMAIL_REGEX = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

        service.email = function(email) {
            if (email) {
                if (email.match(EMAIL_REGEX)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return service;
    }]);
})();
