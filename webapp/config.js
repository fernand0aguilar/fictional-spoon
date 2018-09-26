// Shared env vars in all environments
var shared = {
    expressUrl: process.env.expressUrl || "http://localhost:9000/",
    host: process.env.host || 'http://localhost:8080',
    context: process.env.context || '/',
    enableDebug: process.env.enableDebug || true
};

//
var environments = {
    development: {
        APPINFO: shared
    },
    staging: {
        APPINFO: shared
    },
    production: {
        APPINFO: shared
    }
};
environments.production.buildpack  = process.env.BUILDPACK_URL;

module.exports = environments;