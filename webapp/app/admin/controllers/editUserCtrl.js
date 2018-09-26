// "use strict";
//
// angular.module("pinoquio.editUser", [])
//
// .config(['$stateProvider', function($stateProvider) {
//     $stateProvider.state('main.editUser', {
//         url: '/editUser/:userId',
//         templateUrl: 'app/admin/templates/registerUser.tpl.html',
//         controller: 'RegisterUserCtrl'
//     });
// }])
//
// .controller("RegisterUserCtrl", ["$scope", "$state", "MaritalStatusSrvc", "SkinColorSrvc", "UFSrvc", "CitySrvc", "DirectorySrvc", "CoordinationSrvc", "DivisionSrvc", "RegisterSrvc", "$mdDialog", "CategorySrvc", "RoleSrvc", "$stateParams", "EmployeSrvc", "ErrorSrvc", "$anchorScroll", "CompanySrvc", "PublicCompanySrvc", "HealthInsuranceCompanySrvc", function($scope, $state, MaritalStatusSrvc, SkinColorSrvc, UFSrvc, CitySrvc, DirectorySrvc, CoordinationSrvc, DivisionSrvc, RegisterSrvc, $mdDialog, CategorySrvc, RoleSrvc, $stateParams, EmployeSrvc, ErrorSrvc, $anchorScroll, CompanySrvc, PublicCompanySrvc, HealthInsuranceCompanySrvc) {
//
//     $scope.isPublicServer = false;
//     $scope.isOutsourced = false;
//
//     var AGE_18_MILLI = 19 * 12 * 30 * 24 * 60 * 60 * 1000;
//
//     $scope.user = {
//         filiation: {},
//         rg: {
//             expeditionDate: new Date()
//         },
//         entryDate: new Date(),
//         insideCompanyPhone: {
//             phoneCategory: {
//                 id: 4
//             }
//         }
//     };
//
//     $scope.calculateNetworkName = function() {
//         EmployeSrvc.calculateNetworkName($scope.user.name)
//             .then($scope.calculateNetworkNameSuccess, $scope.calculateNetworkNameError);
//
//     }
//
//     $scope.calculateNetworkNameSuccess = function(response) {
//         $scope.user.networkLogin = response.data;
//     }
//
//     $scope.calculateNetworkNameError = function(error) {
//         console.error(error);
//     }
//
//     angular.element(document)
//         .ready(function() {
//             if ($stateParams.userId == 0) {
//                 // nothing to do
//             } else {
//                 EmployeSrvc.findEmployee($stateParams.userId)
//                     .then($scope.findEmployeeSuccess, $scope.findEmployeeError);
//             }
//             HealthInsuranceCompanySrvc.list()
//                 .then($scope.listHealthInsuranceCompanySuccess, $scope.listHealthInsuranceCompanyError);
//             MaritalStatusSrvc.getMaritalStatuses()
//                 .then($scope.getMaritalStatusesSuccess, $scope.getMaritalStatusesError);
//             SkinColorSrvc.getAll()
//                 .then($scope.getSkinColorsSuccess, $scope.getSkinColorsError);
//             UFSrvc.getAll()
//                 .then($scope.getUfsSuccess, $scope.getUfsError);
//             DirectorySrvc.getAll()
//                 .then($scope.getDirectoriesSuccess, $scope.getDirectoriesError);
//             CategorySrvc.getAllCategory()
//                 .then($scope.getCategorySuccess, $scope.getCategoryError);
//             RoleSrvc.getAll()
//                 .then($scope.getRolesSuccess, $scope.getRolesError);
//         });
//
//     $scope.getRolesSuccess = function(response) {
//         $scope.roles = response.data;
//     }
//
//     $scope.getRolesError = function(error) {
//         console.error(error);
//     }
//
//     $scope.listHealthInsuranceCompanySuccess = function(response) {
//         $scope.healthInsuranceCompanies = response.data;
//     }
//
//     $scope.listHealthInsuranceCompanyError = function(error) {
//         console.error(error);
//     }
//
//     $scope.getCategorySuccess = function(response) {
//         $scope.categories = response.data;
//     }
//
//     $scope.categoryChanged = function() {
//         $scope.isPublicServer = false;
//         $scope.isOutsourced = false;
//         switch ($scope.user.employeeCategory.id) {
//             case 4:
//                 $scope.isOutsourced = true;
//                 CompanySrvc.listAll()
//                     .then($scope.listAllCompaniesSuccess, $scope.listAllCompaniesError);
//                 break;
//             case 5:
//                 $scope.isPublicServer = true;
//                 PublicCompanySrvc.listAll()
//                     .then($scope.listAllPublicCompaniesSuccess, $scope.listAllPublicCompaniesError);
//                 break;
//             default:
//                 // nothing to do.
//                 break;
//         }
//     }
//
//     $scope.listAllPublicCompaniesSuccess = function(response) {
//         $scope.publicCompanies = response.data;
//     }
//
//     $scope.listAllPublicCompaniesError = function(error) {
//         console.error(error);
//     }
//
//     $scope.directoryFromChanged = function() {
//         CoordinationSrvc.getAllFromDirectory($scope.user.publicEmployee.directoryFrom.id)
//             .then($scope.getAllFromDirectorySuccess, $scope.getAllFromDirectoryError);
//     }
//
//     $scope.coordinationFromChanged = function() {
//         DivisionSrvc.getAllFromCoordination($scope.user.publicEmployee.coordinationFrom.id)
//             .then($scope.getAllFromCoordinationSuccess, $scope.getAllFromCoordinationError);
//     }
//
//     $scope.listAllCompaniesSuccess = function(response) {
//         $scope.companies = response.data;
//     }
//
//     $scope.listAllCompaniesError = function(error) {
//         console.error(error);
//     }
//
//     $scope.getCategoryError = function(error) {
//         console.error(error);
//     }
//
//     $scope.getDirectoriesSuccess = function(response) {
//         $scope.directories = response.data;
//     }
//     $scope.getDirectoriesError = function(error) {
//         console.error(error);
//     }
//
//     $scope.addressUfChanged = function() {
//         CitySrvc.getAllFromUf($scope.addressUf.id)
//             .then($scope.getAllFromUfSuccess, $scope.getAllFromUfError);
//     }
//
//     $scope.getAllFromUfSuccess = function(response) {
//         $scope.cities = response.data;
//     }
//
//     $scope.getUfsSuccess = function(response) {
//         $scope.ufs = response.data;
//     }
//
//     $scope.showMilitaryDocument = function() {
//         if ($scope.user.sex == true) {
//             if ($scope.user.birthDate) {
//                 var today = new Date();
//                 var age = today.getTime() - $scope.user.birthDate.getTime();
//
//                 if (age > AGE_18_MILLI) {
//                     return true;
//                 }
//             }
//         }
//
//         return false;
//     }
//
//     $scope.getUfsError = function(error) {}
//
//     $scope.getSkinColorsSuccess = function(response) {
//         $scope.skinColors = response.data;
//     }
//
//     $scope.getSkinColorsError = function(error) {
//         console.error(error);
//     }
//
//     $scope.getMaritalStatusesSuccess = function(response) {
//         $scope.maritalStatuses = response.data;
//     }
//     $scope.getMaritalStatusesError = function(error) {
//         console.error(error);
//     }
//
//     $scope.directoryChanged = function() {
//         CoordinationSrvc.getAllFromDirectory($scope.user.directory.id)
//             .then($scope.getAllFromDirectorySuccess, $scope.getAllFromDirectoryError);
//     }
//
//     $scope.coordinationChanged = function() {
//         DivisionSrvc.getAllFromCoordination($scope.user.coordination.id)
//             .then($scope.getAllFromCoordinationSuccess, $scope.getAllFromCoordinationError);
//     }
//
//     $scope.getAllFromCoordinationSuccess = function(response) {
//         $scope.divisions = response.data;
//     }
//
//     $scope.getAllFromCoordinationError = function(error) {
//         console.error(error);
//     }
//
//     $scope.getAllFromDirectorySuccess = function(response) {
//         $scope.coordinations = response.data;
//     }
//
//     $scope.getAllFromDirectoryError = function(error) {
//         console.error(error);
//     }
//
//
//     $scope.registerUser = function() {
//         $anchorScroll();
//
//         if ($scope.user.spouse && !$scope.user.spouse.birthDate) {
//             $scope.user.spouse = null;
//         }
//         if ($scope.user.laborData && !$scope.user.laborData.firstJob) {
//             $scope.user.laborData = null;
//         }
//         RegisterSrvc.validateEmployee($scope.user)
//             .then($scope.validateEmployeeSuccess, $scope.validateEmployeeError);
//     }
//
//     $scope.findEmployeeSuccess = function(response) {
//         $scope.user = response.data;
//
//         if ($scope.user.entryDate) {
//             $scope.user.entryDate = new Date($scope.user.entryDate);
//         }
//         if ($scope.user.registryDate) {
//             $scope.user.registryDate = new Date($scope.user.registryDate);
//         }
//         if ($scope.user.birthDate) {
//             $scope.user.birthDate = new Date($scope.user.birthDate);
//         }
//         if ($scope.user.rg.expeditionDate) {
//             $scope.user.rg.expeditionDate = new Date($scope.user.rg.expeditionDate);
//         }
//         if ($scope.user.laborData.firstJob) {
//             $scope.user.laborData.firstJob = new Date($scope.user.firstJob.laborData);
//         }
//
//         $scope.directoryChanged();
//         $scope.addressUf = $scope.user.address.city.uf;
//         $scope.addressUfChanged();
//         $scope.categoryChanged();
//     }
//
//     $scope.findEmployeeError = function(error) {
//         console.error(error);
//     }
//
//     $scope.validateEmployeeSuccess = function(response) {
//         if (response.data.length > 0) {
//             var parent = angular.element(document.getElementById("main_div"));
//
//             $mdDialog.show({
//                 templateUrl: 'app/admin/templates/toast/invalidField.toast.tpl.html',
//                 parent: parent,
//                 locals: {
//                     messages: response.data
//                 },
//                 controller: "InvalidFieldsCtrl",
//                 clickOutsideToClose: true,
//                 scope: $scope,
//                 preserveScope: true,
//             });
//         } else {
//             RegisterSrvc.registerEmployee($scope.user)
//                 .then($scope.registerEmployeeSuccess, $scope.registerEmployeeError);
//         }
//     };
//
//     $scope.registerEmployeeSuccess = function(response) {
//         if ($state.params.userId == 0) {
//             $state.go("main.home", {}, {
//                 reload: true
//             });
//             ErrorSrvc.showError("Funcionário cadastrado com sucesso");
//         } else {
//             $state.go("main.listUsers");
//             ErrorSrvc.showError("Funcionário cadastrado com sucesso");
//         }
//     };
//
//     $scope.registerEmployeeError = function(error) {
//         $anchorScroll();
//         ErrorSrvc.showError("Erro, Algum campo não está preenchido corretamente", "Algum campo não está preenchido corretamente");
//     }
//
//     $scope.validateEmployeeError = function(error) {
//         ErrorSrvc.showError("Erro, Algum campo não está preenchido corretamente", "Algum campo não está preenchido corretamente");
//     }
//
//     $scope.isSelectedHealthInsuranceCompany = function(healthInsuranceCompany) {
//         if (healthInsuranceCompany && $scope.$parent.employee.healthInsurance) {
//             return $scope.$parent.employee.healthInsurance.healthInsuranceCompany.id == healthInsuranceCompany.id;
//         } else {
//             return false;
//         }
//     }
//
// }])
