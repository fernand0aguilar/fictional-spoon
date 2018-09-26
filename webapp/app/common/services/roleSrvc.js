"use strict";

angular.module("pinoquio.role", [])

.constant("ROLE_REST", {
  getAll: "employeeRole"
})

.constant("ROLE_BOSS",{
  diretoria: "Diretor",
  divisao: "Chefe de Divisão",
  coordenacao: "Coordenador",
  gabinete: "Chefe de Gabinete"
})

.factory("RoleSrvc", ["httpConnector", "ROLE_REST", "ROLE_BOSS", function(httpConnector, ROLE_REST, ROLE_BOSS) {
  var service = {};

  service.getAll = function() {
    return httpConnector.get(ROLE_REST.getAll);
  }

  service.getUserRole = function(user){
    return user.employeeRole;
  }

  service.isUserBoss = function(user){
      if (user.employeeRole.description == ROLE_BOSS.diretoria) return true;
      if (user.employeeRole.description == ROLE_BOSS.divisao) return true;
      if (user.employeeRole.description == ROLE_BOSS.coordenacao) return true;
      if (user.employeeRole.description == ROLE_BOSS.gabinete) return true;
      return false;
  }

  return service;
}]);
