"use strict";

angular.module('pinoquio.hobbie', [])

.constant("HOBBIE_REST", {
  save: "hobbie/save",
  list: "hobbie",
  delete: "hobbie/delete"
})

.factory('HobbieSrvc', ["httpConnector", "HOBBIE_REST", function(httpConnector, HOBBIE_REST) {
  var service = {};

  service.saveHobbie = function(hobbie) {
    return httpConnector.post(HOBBIE_REST.save, hobbie)
  };

  service.listHobbies = function() {
    return httpConnector.get(HOBBIE_REST.list);
  }

  service.deleteHobbie = function(hobbie) {
    return httpConnector.post(HOBBIE_REST.delete, hobbie)
  }

  return service;
}]);
