"use strict";

angular.module("pinoquio.publicCompany", [])

.constant("PUBLIC_COMPANY_REST", {
  listAll: "publicCompany"
})

.factory("PublicCompanySrvc", ["httpConnector", "PUBLIC_COMPANY_REST", function(httpConnector, PUBLIC_COMPANY_REST) {
  var service = {};

  service.listAll = function() {
    return httpConnector.get(PUBLIC_COMPANY_REST.listAll);
  }

  return service;
}]);
