"use strict";

angular.module("pinoquio.phone")

    .constant("PHONE_REST", {
        getAllRamal: "phone/getAllRamal"
    })

    .factory("PhoneSrvc", ["httpConnector", "PHONE_REST", function(httpConnector, PHONE_REST) {
        var service = {};

        service.getAllRamal = function() {
            return httpConnector.get(PHONE_REST.getAllRamal);
        }

        return service;

    }]);
