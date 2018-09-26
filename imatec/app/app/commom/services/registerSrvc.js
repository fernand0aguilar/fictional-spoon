(function() {
    "use strict";

    angular.module("imatec.register")

    .constant("REGISTER_REST", {
        "register": "users/register"
    })

    .factory("RegisterSrvc", ["httpConnector", "REGISTER_REST", function(httpConnector, REGISTER_REST) {
        var service = {}

        service.register = function(user) {

            return httpConnector.post(REGISTER_REST.register, user);
        }
        
        return service;
    }]);
})();
