"use strict";

angular.module("pinoquio.employee", [])

.constant("EMPLOYEE_REST", {
  createInsideCompanyPhone: "employee/createInsideCompanyPhone",
  load: "educationalBackground",
  removeUser: "employee/removeUser",
  find: "employee/findById",
  update: "employee/updateEmployee",
  calculateNetworkName: "employee/calculateNetworkName"
})

.factory("EmployeSrvc", ["httpConnector", "EMPLOYEE_REST", function(httpConnector, EMPLOYEE_REST) {
  var service = {};

  service.updateUser = function(employee) {
    return httpConnector.post(EMPLOYEE_REST.update, employee);
  }

  service.createInsideCompanyPhone = function(userId, phone) {
    return httpConnector.post(EMPLOYEE_REST.createInsideCompanyPhone, {
      employee: {
        id: userId
      },
      phone: phone
    });
  }

  service.calculateNetworkName = function(name) {
    return httpConnector.get(EMPLOYEE_REST.calculateNetworkName, {params:{name:name}});
  }

  service.removeUser = function(userId, date) {
    return httpConnector.delete(EMPLOYEE_REST.removeUser, {
      params: {
        userId: userId,
        disableDateLong: date.getTime()
      }
    });
  }

  service.findEmployee = function(userId) {
    return httpConnector.get(EMPLOYEE_REST.find, {
      params: {
        userId: userId
      }
    });
  }

  return service;
}]);
