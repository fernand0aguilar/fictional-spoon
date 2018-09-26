"use strict";

angular.module("pinoquio.updateUser")

  .constant("UPDATE_REST", {
    validateEmployee: "employee/validateFields",
    validateLocal: "internalPlace/validateFields",
    updateEmployee: "employee/insertEmployee",
    updateLocal: "internalPlace/insertInternalPlace"
  })

  .factory("updateSrvc", ["httpConnector", "UPDATE_REST", function(httpConnector, UPDATE_REST) {
    var service = {};

    service.validateEmployee = function(employee) {
      return httpConnector.post(UPDATE_REST.validateEmployee, employee);
    }

    service.updateEmployee = function(employee) {
      return httpConnector.post(UPDATE_REST.updateEmployee, employee);
    }

    service.validateLocal = function(local) {
      return httpConnector.post(UPDATE_REST.validateLocal, local);
    }

    service.updateLocal = function(local) {
      return httpConnector.post(UPDATE_REST.updateLocal, local);
    }

    return service;
  }]);
