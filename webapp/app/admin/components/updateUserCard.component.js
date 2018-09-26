angular.module('pinoquio.updateUser')

  .component('updateUserCard', {
    templateUrl: 'app/admin/templates/updateUserCard.tpl.html',
    bindings: {
      user: '='
    },
    controller: ["$state", "MaritalStatusSrvc", "SkinColorSrvc", "UFSrvc", "CitySrvc", "DirectorySrvc", "CoordinationSrvc", "DivisionSrvc", "RegisterSrvc", "CategorySrvc", "RoleSrvc", "$stateParams", "EmployeSrvc", "ErrorSrvc", "$anchorScroll", "CompanySrvc", "PublicCompanySrvc", "EducationLevelSrvc", "HobbieSrvc", "HealthInsuranceCompanySrvc", "RelativeSrvc",
      function($state, MaritalStatusSrvc, SkinColorSrvc, UFSrvc, CitySrvc, DirectorySrvc, CoordinationSrvc, DivisionSrvc, RegisterSrvc, CategorySrvc, RoleSrvc, $stateParams, EmployeSrvc, ErrorSrvc, $anchorScroll, CompanySrvc, PublicCompanySrvc, EducationLevelSrvc, HobbieSrvc, HealthInsuranceCompanySrvc, RelativeSrvc) {

        var self = this;

        var AGE_18_MILLI = 19 * 12 * 30 * 24 * 60 * 60 * 1000;

        self.isPublicServer = false;
        self.isOutsourced = false;
        self.editing = false;
        self.listOfEducation = [];

        self.calculateNetworkName = function() {
          EmployeSrvc.calculateNetworkName(self.user.name)
            .then(self.calculateNetworkNameSuccess, self.calculateNetworkNameError);

        };

        self.calculateNetworkNameSuccess = function(response) {
          self.user.networkLogin = response.data;
          self.user.aebMail = response.data + "@aeb.gov.br";
        };

        self.calculateNetworkNameError = function(error) {
          console.error(error);
        };
        if ($stateParams.userId === 0) {
          // nothing to do
          self.editing = false;
        } else {
          self.editing = true;

          EmployeSrvc.findEmployee($stateParams.userId)
            .then(self.findEmployeeSuccess, self.findEmployeeError);
        }

        self.getRolesSuccess = function(response) {
          self.roles = response.data;
        };

        self.getRolesError = function(error) {
          console.error(error);
        };

        self.listHealthInsuranceCompanySuccess = function(response) {
          self.healthInsuranceCompanies = response.data;
        };

        self.listHealthInsuranceCompanyError = function(error) {
          console.error(error);
        };

        self.getCategorySuccess = function(response) {
          self.categories = response.data;
        };

        self.categoryChanged = function() {
          self.isPublicServer = false;
          self.isOutsourced = false;
          switch (self.user.employeeCategory.id) {
            case 4:
              self.isOutsourced = true;
              CompanySrvc.listAll()
                .then(self.listAllCompaniesSuccess, self.listAllCompaniesError);
              break;
            case 5:
              self.isPublicServer = true;
              PublicCompanySrvc.listAll()
                .then(self.listAllPublicCompaniesSuccess, self.listAllPublicCompaniesError);
              break;
            default:
              // nothing to do.
              break;
          }
        };

        self.listAllPublicCompaniesSuccess = function(response) {
          self.publicCompanies = response.data;
        };

        self.listAllPublicCompaniesError = function(error) {
          console.error(error);
        };

        self.directoryFromChanged = function() {
          CoordinationSrvc.getAllFromDirectory(self.user.publicEmployee.directoryFrom.id)
            .then(self.getAllFromDirectorySuccess, self.getAllFromDirectoryError);
        };

        self.coordinationFromChanged = function() {
          DivisionSrvc.getAllFromCoordination(self.user.publicEmployee.coordinationFrom.id)
            .then(self.getAllFromCoordinationSuccess, self.getAllFromCoordinationError);
        };

        self.listAllCompaniesSuccess = function(response) {
          self.companies = response.data;
        };

        self.listAllCompaniesError = function(error) {
          console.error(error);
        };

        self.getCategoryError = function(error) {
          console.error(error);
        };

        self.getDirectoriesSuccess = function(response) {
          self.directories = response.data;
        };

        self.getDirectoriesError = function(error) {
          console.error(error);
        };

        self.addressUfChanged = function() {
          CitySrvc.getAllFromUf(self.addressUf.id)
            .then(self.getAllFromUfSuccess, self.getAllFromUfError);
        };

        self.getAllFromUfSuccess = function(response) {
          self.cities = response.data;
        };

        self.getUfsSuccess = function(response) {
          self.ufs = response.data;
        };

        self.showMilitaryDocument = function() {
          if (self.user.sex == 1) {
            if (self.user.birthDate) {
              var today = new Date();
              var age = today.getTime() - self.user.birthDate.getTime();

              if (age > AGE_18_MILLI) {
                return true;
              }
            }
          }

          return false;
        };

        self.getUfsError = function(error) {};

        self.getSkinColorsSuccess = function(response) {
          self.skinColors = response.data;
        };

        self.getSkinColorsError = function(error) {
          console.error(error);
        };

        self.getMaritalStatusesSuccess = function(response) {
          self.maritalStatuses = response.data;
        };
        self.getMaritalStatusesError = function(error) {
          console.error(error);
        };

        self.directoryChanged = function() {
          CoordinationSrvc.getAllFromDirectory(self.user.directory.id)
            .then(self.getAllFromDirectorySuccess, self.getAllFromDirectoryError);
        };

        self.coordinationChanged = function() {
          DivisionSrvc.getAllFromCoordination(self.user.coordination.id)
            .then(self.getAllFromCoordinationSuccess, self.getAllFromCoordinationError);
        };

        self.getAllFromCoordinationSuccess = function(response) {
          self.divisions = response.data;
        };

        self.getAllFromCoordinationError = function(error) {
          console.error(error);
        };

        self.getAllFromDirectorySuccess = function(response) {
          self.coordinations = response.data;
        };

        self.getAllFromDirectoryError = function(error) {
          console.error(error);
        };

        self.updateUser = function() {
          $anchorScroll();

          if (self.user.spouse && !self.user.spouse.birthDate) {
            self.user.spouse = null;
          }
          if (self.user.laborData && !self.user.laborData.firstJob) {
            self.user.laborData = null;
          }
          RegisterSrvc.validateEmployee(self.user)
            .then(self.validateEmployeeSuccess, self.validateEmployeeError);
        };

        self.findEmployeeSuccess = function(response) {
          self.user = response.data;

          if (self.user.entryDate) {
            self.user.entryDate = new Date(self.user.entryDate);
          }
          if (self.user.registryDate) {
            self.user.registryDate = new Date(self.user.registryDate);
          }
          if (self.user.birthDate) {
            self.user.birthDate = new Date(self.user.birthDate);
          }
          if (self.user.rg.expeditionDate) {
            self.user.rg.expeditionDate = new Date(self.user.rg.expeditionDate);
          }
          if (self.user.healthInsurance.expirationDate) {
            self.user.healthInsurance.expirationDate = new Date(self.user.healthInsurance.expirationDate);
          }

          if (self.user.laborData) {
            if (self.user.laborData.firstJob) {
              self.user.laborData.firstJob = new Date(self.user.laborData.firstJob);
            }
          }

          self.directoryChanged();
          self.addressUf = self.user.address.city.uf;
          self.addressUfChanged();
          self.categoryChanged();
        };

        self.findEmployeeError = function(error) {
          console.error(error);
        };

        self.validateEmployeeSuccess = function(response) {
          if (response.data.length > 0) {
            var camposInvalidos = "";
            funConcat = function errorMsg(msg) {
              camposInvalidos += msg;
            }
            response.data.forEach(funConcat);

            swal({
              title: "Erro no preenchimento",
              text: camposInvalidos,
              type: "warning",
            });
          } else {
            RegisterSrvc.updateEmployee(self.user)
              .then(self.updateEmployeeSuccess, self.updateEmployeeError);
          }
        };

        self.updateEmployeeSuccess = function(response) {
          if ($state.params.userId === 0) {
            swal("Funcionário Atualizado com sucesso", "", "success");
          } else {
            swal("Funcionário Atualizado com sucesso", "", "success");
          }
        };

        self.updateEmployeeError = function(error) {
          $anchorScroll();
          swal("Erro", "Verifique o preenchimento dos campos", "error");
          console.log(error);
          // ErrorSrvc.showError("Erro", "Algum campo não está preenchido corretamente");
        };

        self.validateEmployeeError = function(error) {
          swal("Erro", "Verifique o preenchimento dos campos", "error");
          console.log(error);
          // ErrorSrvc.showError("Erro", "Algum campo não está preenchido corretamente");
        };

        self.isSelectedHealthInsuranceCompany = function(healthInsuranceCompany) {
          if (healthInsuranceCompany && self.user.healthInsurance && self.user.healthInsurance.healthInsuranceCompany) {
            return self.user.healthInsurance.healthInsuranceCompany.id == healthInsuranceCompany.id;
          } else {
            return false;
          }
        };

        HealthInsuranceCompanySrvc.list()
          .then(self.listHealthInsuranceCompanySuccess, self.listHealthInsuranceCompanyError);
        MaritalStatusSrvc.getMaritalStatuses()
          .then(self.getMaritalStatusesSuccess, self.getMaritalStatusesError);
        SkinColorSrvc.getAll()
          .then(self.getSkinColorsSuccess, self.getSkinColorsError);
        UFSrvc.getAll()
          .then(self.getUfsSuccess, self.getUfsError);
        DirectorySrvc.getAll()
          .then(self.getDirectoriesSuccess, self.getDirectoriesError);
        CategorySrvc.getAllCategory()
          .then(self.getCategorySuccess, self.getCategoryError);
        RoleSrvc.getAll()
          .then(self.getRolesSuccess, self.getRolesError);

      }
    ]
  });
