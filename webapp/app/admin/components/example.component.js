angular.module('pinoquio')

    .component('greetUser', {
        templateUrl: 'app/admin/templates/example.tpl.html',
    })

    .controller("GreetUserController", [function() {
        this.user = "mundo!";
    }]);
