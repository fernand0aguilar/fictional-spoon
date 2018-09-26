"use strict";

angular.module("pinoquio.healthInsuranceCompany", [])

.constant("HEALTH_INSURANCE_COMPANY_REST", {
  list: "healthInsuranceCompany"
})

.factory("HealthInsuranceCompanySrvc", ["httpConnector", "HEALTH_INSURANCE_COMPANY_REST", function(httpConnector, HEALTH_INSURANCE_COMPANY_REST) {
  var service = {};

  service.list = function() {
    return httpConnector.get(HEALTH_INSURANCE_COMPANY_REST.list);
  }

  return service;
}]);
