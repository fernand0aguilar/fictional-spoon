"use strict";

angular.module('pinoquio.login')

.constant("LOGIN_REST", {
  "login": "security/login"
})

.factory("LoginSrvc", ["httpConnector", "LOGIN_REST", function(httpConnector, LOGIN_REST) {
  var service = {};

  service.login = function(login) {
    return httpConnector.post(LOGIN_REST.login, login);
  }

  return service;
}]);
