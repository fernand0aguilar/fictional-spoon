"use strict";

angular.module("pinoquio.authorization", [])

.constant("USER_PROFILES", {
  root: 1,
  admin: 2,
  user: 3
})

.factory("AuthorizationSrvc", ["USER_PROFILES", function(USER_PROFILES) {
  var service = {};

  service.isRoot = function(userProfile) {
    return userProfile.id == USER_PROFILES.root;
  }

  service.isAdmin = function(userProfile) {
    return userProfile.id == USER_PROFILES.admin
  }

  service.isUser = function(userProfile) {
    return userProfile.id == USER_PROFILES.user;
  }

  return service;

}]);
