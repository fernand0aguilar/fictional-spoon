"use strict";

angular.module("pinoquio.directory", [])

.constant("DIRECTORY_REST", {
  list: "directory"
})

.factory("DirectorySrvc", ["httpConnector", "DIRECTORY_REST", function(httpConnector, DIRECTORY_REST) {
  var service = {};

  service.getAll = function() {
    return httpConnector.get(DIRECTORY_REST.list);
  }

  return service;

}]);
