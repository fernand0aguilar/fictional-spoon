"use strict";

angular.module("pinoquio.home")

  .component('userDataCard', {
    templateUrl: 'app/admin/templates/userDataCard.tpl.html',
    bindings: {
      employee: '<'
    },
    controller: ["$scope", "MaritalStatusSrvc", "$anchorScroll", "EmployeSrvc", "UFSrvc", "CitySrvc", "ErrorSrvc", "RelativeSrvc", "HealthInsuranceCompanySrvc", "$rootScope", function($scope, MaritalStatusSrvc, $anchorScroll, EmployeSrvc, UFSrvc, CitySrvc, ErrorSrvc, RelativeSrvc, HealthInsuranceCompanySrvc, $rootScope) {

      var self = this;

      self.address = {
        selectedUf: {}
      };

      self.relative = {
        birthDate: new Date()
      };

      self.getAllUfSuccess = function(response) {
        self.allUf = response.data;
      };

      self.getAllUfError = function(error) {
        console.error(error);
      };

      self.getMaritalStatusesSuccess = function(response) {
        self.maritalStatuses = response.data;
      };

      self.getMaritalStatusesError = function(error) {
        console.error(error);
      };

      self.showCoordination = function() {
        if (self.$parent.employee.coordination) {
          return true;
        } else {
          return false;
        }
      };

      self.showDivision = function() {
        if (self.$parent.employee.division) {
          return true;
        } else {
          return false;
        }
      };

      self.isSelectedOption = function(maritalStatus) {
        if (maritalStatus) {
          return self.$parent.employee.maritalStatus.id == maritalStatus.id;
        } else {
          return false;
        }
      };

      self.isSelectedHealthInsuranceCompany = function(healthInsuranceCompany) {
        if (healthInsuranceCompany && self.$parent.employee.healthInsurance) {
          return self.$parent.employee.healthInsurance.healthInsuranceCompany.id == healthInsuranceCompany.id;
        } else {
          return false;
        }
      };

      self.isSelectedUf = function(uf) {
        if (uf) {
          return uf.id == self.$parent.employee.address.city.uf.id;
        }
      };

      self.isSelectedCity = function(city) {
        if (city) {
          return city.id == self.$parent.employee.address.city.id;
        }
      };

      self.getCities = function() {
        if (self.address && self.address.selectedUf) {
          CitySrvc.getAllFromUf(self.address.selectedUf.id).then(self.getCitiesSuccess, self.getCitiesError);
        }
      };

      self.getCitiesSuccess = function(response) {
        self.allCities = response.data;
      };

      self.getCitiesError = function(error) {
        console.error(error);
      };

      self.listHealthInsuranceCompanySuccess = function(response) {
        self.healthInsuranceCompanies = response.data;
      };

      self.listHealthInsuranceCompanyError = function(error) {
        console.error(error);
      };

      MaritalStatusSrvc.getMaritalStatuses().then(self.getMaritalStatusesSuccess, self.getMaritalStatusesError);
      UFSrvc.getAll().then(self.getAllUfSuccess, self.getAllUfError);
      HealthInsuranceCompanySrvc.list().then(self.listHealthInsuranceCompanySuccess, self.listHealthInsuranceCompanyError);
    }]
  });
