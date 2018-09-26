"use strict";

angular.module("pinoquio.educationalBackground", [])

  .constant("EDUCATIONAL_BACKGROUND_REST", {
    save: "educationalBackground/insert",
    load: "educationalBackground",
    edit: "educationalBackground/edit",
    delete: "educationalBackground/delete"
  })

  .factory("EducationalBackgroundSrvc", ["httpConnector", "EDUCATIONAL_BACKGROUND_REST", function(httpConnector, EDUCATIONAL_BACKGROUND_REST) {
    var service = {};

    service.save = function(educationalBackground, userId) {
      return httpConnector.post(EDUCATIONAL_BACKGROUND_REST.save + "/" + userId, educationalBackground);
    }

    service.load = function(userId) {
      return httpConnector.get(EDUCATIONAL_BACKGROUND_REST.load + "/" + userId);
    }

    service.edit = function(educationalBackground, userId) {
      return httpConnector.post(EDUCATIONAL_BACKGROUND_REST.edit + "/" + userId, educationalBackground);
    }

    service.delete = function(educationalBackground, userId) {
      return httpConnector.post(EDUCATIONAL_BACKGROUND_REST.delete + "/" + userId, educationalBackground);
    }

    return service;
  }]);
