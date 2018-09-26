"use strict";

angular.module("pinoquio.uf", [])

.constant("UF_REST", {
  getAll: "uf"
})

.factory("UFSrvc", ["httpConnector", "UF_REST", function(httpConnector, UF_REST) {
  var service = {};

  service.getAll = function() {
    return httpConnector.get(UF_REST.getAll);
  }

  return service;

}]);
