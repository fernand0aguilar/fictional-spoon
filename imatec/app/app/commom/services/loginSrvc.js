(function() {
    "use strict";

    angular.module("imatec.login")

    .constant("LOGIN_REST", {
        "login": "users/login"
    })

    .factory("LoginSrvc", ["httpConnector", "LOGIN_REST", function(httpConnector, LOGIN_REST) {
        var service = {}

        service.login = function(user) {
            return httpConnector.post(LOGIN_REST.login, user);
        }

        return service;
    }]);
})();
