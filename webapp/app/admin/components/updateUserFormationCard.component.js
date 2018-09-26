(function() {
  'use strict';
  // self function is strict...
}());

angular
  .module("pinoquio.updateUser")
  .component('updateUserFormationCard', {
    templateUrl: 'app/admin/templates/updateUserFormationCard.tpl.html',
    bindings: {
      user: '<',
      edit: '<'
    },
    controller: ["$scope", "$anchorScroll", "EducationLevelSrvc", "EducationalBackgroundSrvc", "EmployeSrvc", "ErrorSrvc", "$rootScope", function($scope, $anchorScroll, EducationLevelSrvc, EducationalBackgroundSrvc, ErrorSrvc, $rootScope) {

      var self = this;
      self.listOfEducation = [];
      self.education = {
        educationLevel: {},
        begin: new Date(),
        conclusion: new Date()
      };

      self.getAllEducationalBackgroundSuccess = function(response) {
        self.listOfEducation = response.data;
      };

      self.getAllEducationalBackgroundError = function(error) {
        console.error(error);
      };
      this.$onChanges = function(changesObj) {
        if (typeof self.user.id !== 'undefined') {
          EducationalBackgroundSrvc.load(self.user.id).then(self.getAllEducationalBackgroundSuccess, self.getAllEducationalBackgroundError);
        }
      };

      self.getAllEducationLevelSuccess = function(response) {
        self.educationLevels = response.data;
      };

      self.getAllEducationLevelError = function(error) {
        console.error(error);
      };

      EducationLevelSrvc.getAll().then(self.getAllEducationLevelSuccess, self.getAllEducationLevelError);

      this.registerFormation = function() {
        EducationalBackgroundSrvc.save(self.education, self.user.id).then(self.registerFormationSuccess, self.registerFormationError);
      };

      self.registerFormationSuccess = function(response) {
        self.education = {
          educationLevel: {},
          begin: new Date(),
          conclusion: new Date()
        };
        if (typeof self.user.id !== 'undefined') {
          EducationalBackgroundSrvc.load(self.user.id).then(self.getAllEducationalBackgroundSuccess, self.getAllEducationalBackgroundError);
        }
      };

      self.registerFormationError = function(error) {
        console.error(error);
      };

      self.deleteFormation = function(education) {
        if (typeof self.user !== 'undefined') {
          EducationalBackgroundSrvc.delete(education, self.user.id).then(self.deleteFormationSuccess, self.deleteFormationError);
        }
      };

      self.deleteFormationSuccess = function(response) {
        if (typeof self.user.id !== 'undefined') {
          EducationalBackgroundSrvc.load(self.user.id).then(self.getAllEducationalBackgroundSuccess, self.getAllEducationalBackgroundError);
        }
      };

      self.deleteFormationError = function(error) {
        console.log(error);
      };

    }]
  });
