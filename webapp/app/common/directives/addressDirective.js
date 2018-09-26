"use strict";

angular.module("pinoquio.directives", [])

.directive("zipCode", ["$filter", function($filter) {
  var directive = {};

  directive.restrict = "A";

  directive.link = function(scope, element, attrs) {
    element.attr('maxlength', '9');

    scope.$watch(attrs.ngModel, function(newValue, oldValue) {
      var zipCode = newValue + "";

      if (zipCode) {
        zipCode = zipCode.replace(/\D/g, "");

        if (zipCode.length > 5 && zipCode.length <= 9) {
          zipCode = zipCode.replace(/([0-9]{5})([0-9]{0,3})/g, '$1-$2');
        }

        element.val(zipCode);
      }
    }, true);
  }

  return directive;

}])
