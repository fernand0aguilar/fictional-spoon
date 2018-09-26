(function() {
    "use strict";

    angular.module("imatec.crypto", [])

    .factory("CryptoSrvc", [function() {

        var service = {};

        service.criptPhrase = "IMATEC";

        service.encrypt = function(obj) {
            var stringObj = JSON.stringify(obj);

            var encryptedObj = CryptoJS.AES.encrypt(stringObj, service.criptPhrase);

            return encryptedObj.toString();
        }

        service.decrypt = function(string) {
            var decryptObj = CryptoJS.AES.decrypt(string, service.criptPhrase);

            return decryptObj.toString(CryptoJS.enc.Utf8);
        };

        service.sha256Encrypt = function(string) {
            return CryptoJS.SHA256(string)
                .toString(CryptoJS.enc.Hex);
        };

        return service;
    }])

})();
