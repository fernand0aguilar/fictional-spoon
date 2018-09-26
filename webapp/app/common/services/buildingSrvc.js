"use strict";

angular.module("pinoquio.building", [])

.constant("BUILDING_REST", {
    getAll: "building"
})

.factory("BuildingSrvc", ["httpConnector", "BUILDING_REST", function(httpConnector, BUILDING_REST) {
    var service = {};

    service.getAll = function() {
        return httpConnector.get(BUILDING_REST.getAll);
    }

    return service;

}]);
