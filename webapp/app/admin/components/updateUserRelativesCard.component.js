(function() {
    'use strict';
    // this function is strict...
}());


angular.module('pinoquio.updateUser')

    .component('updateUserRelativesCard', {
        templateUrl: 'app/admin/templates/updateUserRelativesCard.tpl.html',
        bindings: {
            user: '<',
            edit: '<'
        },
        controller: ["RelativeSrvc", "$scope", function(RelativeSrvc, $scope) {
            var controllerData = this;

            controllerData.listAllRelatives = function() {
                RelativeSrvc.listAll().then(controllerData.listAllRelativesSuccess, controllerData.listAllRelativesError);
            };

            controllerData.listAllRelativesSuccess = function(response) {
                controllerData.relatives = response.data;
            };

            controllerData.listAllRelativesError = function(error) {
                console.error(error);
            };

            this.registerRelative = function() {
                if (controllerData.relative) {
                    if (controllerData.relative.birthDate) {
                        RelativeSrvc.save(controllerData.relative).then(controllerData.registerRelativeSuccess, controllerData.registerRelativeError);
                    }
                } else {
                    // nothing to do.
                }
            };

            controllerData.registerRelativeSuccess = function(response) {
                controllerData.relative = {
                    birthDate: new Date()
                };
                controllerData.listAllRelatives();
            };

            controllerData.deleteRelative = function(relative) {
                RelativeSrvc.delete(relative.id).then(controllerData.deleteRelativeSuccess, controllerData.deleteRelativeError);
            };

            controllerData.deleteRelativeSuccess = function(response) {
                controllerData.listAllRelatives();
            };

            controllerData.deleteRelativeError = function(error) {
                console.error(error);
            };

            controllerData.registerRelativeError = function(error) {
                console.error(error);
            };

            RelativeSrvc.listAll().then(controllerData.listAllRelativesSuccess, controllerData.listAllRelativesError);
        }]
    });
