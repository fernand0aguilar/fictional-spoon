"use strict";

angular.module("pinoquio.maritalStatus", [])

.constant("MARITAL_SATUS_REST", {
  getAll: "maritalStatus"
})

.factory("MaritalStatusSrvc", ["httpConnector", "MARITAL_SATUS_REST", function(httpConnector, MARITAL_SATUS_REST) {
  var service = {};

  service.getMaritalStatuses = function() {
    return httpConnector.get(MARITAL_SATUS_REST.getAll);
  }

  return service;
}]);
