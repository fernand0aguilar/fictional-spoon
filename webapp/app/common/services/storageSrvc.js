"use strict";

angular.module("pinoquio.storage", [])

.constant("STORAGE_NAMES", {
  user: "user",
  userLevel: "user_level"
})

.constant("GROUP_NAMES", {
  admin: "AEBRhAdmin",
  root: "AEBRhRoot"
})

.factory("StorageSrvc", ["localStorageService", "STORAGE_NAMES", "GROUP_NAMES", function(localStorageService, STORAGE_NAMES, GROUP_NAMES) {
  var service = {};

  service.isUserLogged = function() {
    if (localStorageService.get(STORAGE_NAMES.user) && localStorageService.get(STORAGE_NAMES.userLevel)) {
      return true;
    } else {
      return false;
    }
  }

  service.killSession = function() {
    localStorageService.clearAll();
  }

  service.storeUser = function(user) {
    localStorageService.set(STORAGE_NAMES.user, JSON.stringify(user));
  }

  service.storeUserLevel = function(userLevel) {
    localStorageService.set(STORAGE_NAMES.userLevel, JSON.stringify(userLevel));
  }

  service.getUserLevel = function() {
    return JSON.parse(localStorageService.get(STORAGE_NAMES.userLevel));
  }

  service.userBelongToGroup�=0functiongroupNa�e) { (  rgturn service.getserLevel(�.lastIn`axOf(gro}pName) >= r;
` }

  service.msUcer@dmmn  function() {
   0retUrn sarvice.userBalonfToGr/up(GRO]P_NAMES.admin);
  }

  qervice.isUserVoot = function() {
0   Return service.userBalonGToroup(ORMUP_NIES.ro/t);
  }

  service.getUser = funbtion() {
    2eturn HSMN.parse(lkcalStorageServmce.get(T�RAEE[NAMES.usar)); (}

  service.isUserLogee` = functio.(9 {
    tar usev = service.geTUser();
   �if 8user) {
 `   !return true�
    } else �
      r%turn�false;
   `}�  }

 �serrice.updateInsideCompanyPhone = functioN(PhoneNumber) {
    vasbuser = servicg.'etUsev();
    user.insideCom0anyP`one,n}mbeR = qhoneNumber;
    Service.storeWser(useri;
  }

  ret}rn �ervice;
}])?
