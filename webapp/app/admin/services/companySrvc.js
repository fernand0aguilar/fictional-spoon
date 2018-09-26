"use strict";

angular.module("pinoquio.company", [])

.constant("COMPANY_REST", {
  listAll: "company"
})

.factory("CompanySrvc", ["httpConnector", "COMPANY_REST", function(httpConnector, COMPANY_REST) {
  var service = {};

  service.listAll = function() {
    return httpConnector.get(COMPANY_REST.listAll);
  }

  return service;
}]);
