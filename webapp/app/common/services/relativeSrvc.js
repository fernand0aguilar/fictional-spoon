"use strict";

angular.module("pinoquio.relative", [])

.constant("RELATIVE_REST", {
  save: "relative/save",
  listAll: "relative",
  delete: "relative/delete"
})

.factory("RelativeSrvc", ["httpConnector", "RELATIVE_REST", function(httpConnector, RELATIVE_REST) {
  var service = {};

  service.save = function(relative) {
    return httpConnector.post(RELATIVE_REST.save, relative);
  }

  service.listAll = function() {
    return httpConnector.get(RELATIVE_REST.listAll);
  }

  service.delete = function(id) {
    return httpConnector.delete(RELATIVE_REST.delete, {
      params: {
        id: id
      }
    });
  }

  return service;
}]);
