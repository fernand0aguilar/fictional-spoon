"use strict";

angular.module("pinoquio.coordination", [])

.constant("COORDINATION_REST", {
  listFromDirectory: "coordination/fromDirectory"
})

.factory("CoordinationSrvc", ["httpConnector", "COORDINATION_REST", function(httpConnector, COORDINATION_REST) {
  var service = {};

  service.getAllFromDirectory = function(id) {
    return httpConnector.get(COORDINATION_REST.listFromDirectory, {
      params: {
        id: id
      }
    });
  }

  return service;

}]);
