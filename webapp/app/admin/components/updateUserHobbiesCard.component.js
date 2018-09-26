(function() {
  'use strict';
  // this function is strict...
}());

angular.module('pinoquio.updateUser')

  .component('updateUserHobbiesCard', {
    templateUrl: 'app/admin/templates/updateUserHobbiesCard.tpl.html',
    bindings: {
      user: '<',
      edit: '<'
    },
    controller: ['HobbieSrvc', '$scope', function UpdateUserHobbiesCardController(HobbieSrvc, $scope) {
      var self = this;
      self.listOfHobbies = [];
      self.registerHobbie = function() {
        self.hobbie.employee = self.user;
        console.log(self.hobbie);
        if (self.user) {
          HobbieSrvc.saveHobbie(self.hobbie).then(self.saveHobbieSuccess, self.saveHobbieError);
        }
      };

      self.saveHobbieSuccess = function(response) {
        HobbieSrvc.listHobbies().then(self.listHobbiesSuccess, self.listHobbiesError);
      };

      self.saveHobbieError = function(error) {
        console.error(error);
      };

      self.listHobbiesSuccess = function(response) {
        self.listOfHobbies = response.data;
        // return response.data;
      };

      self.listHobbiesError = function(error) {
        console.error(error);
      };

      self.deleteHobbie = function(hobbieId) {
        HobbieSrvc.deleteHobbie({
          id: hobbieId
        }).then(self.deleteHobbieSuccess, self.deleteHobbieError);
      };

      self.deleteHobbieSuccess = function(response) {
        HobbieSrvc.listHobbies().then(self.listHobbiesSuccess, self.listHobbiesError);
      };

      self.deleteHobbieError = function(error) {
        console.log(error);
      };

      HobbieSrvc.listHobbies().then(self.listHobbiesSuccess, self.listHobbiesError);

    }]
  });
