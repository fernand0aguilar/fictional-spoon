"use strict";

angular.module("pinoquio.httpconnector", ['pinoquio-config'])

  .config(['$httpProvider', function($httpProvider) {

    $httpProvider.defaults.headers.common = {
      "Content-Type": "application/json",
      "Accept": "application/json"
    };
    $httpProvider.defaults.withCredentials = true;
  }])

  .factory("httpConnector", ["$http", "APPINFO", function($http, APPINFO) {
    var service = {};

    var baseURL = APPINFO.host + APPINFO.context;

    service.post = function(url, data, config) {
      if (!config) {
        config = {};
      }

      return $http.post(baseURL + url, data, config);
    }

    service.get = function(url, config) {
      if (!config) {
        config = {};
      }

      return $http.get(baseURL + url, config);
    }

    service.put = function(url, data, config) {
      if (!config) {
        config = {};
      }

      return $http.put(baseURL + url, data, config);
    }

    service.delete = function(url, config) {
      if (!config) {
        config = {};
      }
      return $http.delete(baseURL + url, config);
    }

    return service;
  }]);
