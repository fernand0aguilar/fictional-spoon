"use strict";

angular.module("pinoquio.registerUser")

  .constant("REGISTER_REST", {
    validateEmployee: "employee/validateFields",
    validateLocal: "internalPlace/validateFields",
    registerEmployee: "employee/insertEmployee",
    updateEmployee: "employee/insertEmployee",
    registerLocal: "internalPlace/insertInternalPlace"
  })

  .factory("RegisterSrvc", ["httpConnector", "REGISTER_REST", function(httpConnector, REGISTER_REST) {
    var service = {};

    service.validateEmployee = function(employee) {
      return httpConnector.post(REGISTER_REST.validateEmployee, employee);
    }

    service.registerEmployee = function(employee) {
      return httpConnector.post(REGISTER_REST.registerEmployee, employee);
    }
    service.updateEmployee = function(employee) {
      return httpConnector.post(REGISTER_REST.updateEmployee, employee);
    }

    service.validateLocal = function(local) {
      return httpConnector.post(REGISTER_REST.validateLocal, local);
    }

    service.registerLocal = function(local) {
      return httpConnector.post(REGISTER_REST.registerLocal, local);
    }

    return service;
  }]);
