"use strict";

angular.module("pinoquio.category", [])

.constant("CATEGORY_REST", {
  getAll: "category"
})

.factory("CategorySrvc", ["httpConnector", "CATEGORY_REST", function(httpConnector, CATEGORY_REST) {
  var service = {};

  service.getAllCategory = function(cityId) {
    return httpConnector.get(CATEGORY_REST.getAll);
  }

  return service;

}]);
