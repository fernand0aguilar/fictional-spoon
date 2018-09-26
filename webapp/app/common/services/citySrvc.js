"use strict";

angular.module("pinoquio.city", [])

.constant("CITY_REST", {
  getAll: "city/findByUf"
})

.factory("CitySrvc", ["httpConnector", "CITY_REST", function(httpConnector, CITY_REST) {
  var service = {};

  service.getAllFromUf = function(cityId) {
    return httpConnector.get(CITY_REST.getAll, {
      params: {
        id: cityId
      }
    });
  }

  return service;

}]);
