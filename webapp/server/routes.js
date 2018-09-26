/**
 * Main application routes
 */

'use strict';

var path = require('path');
var errors = require('./components/errors');

module.exports = function (app) {

  app.use(function(req, res, next) {
    //Please verify soluction
    //TODO -> verify proper soluction
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    next();
  });
  // All undefined asset routes should return a 404
  app.route('/:url(app|bower_components)/*')
   .get(errors[404]);

  app.route('/*')
    .get(function (req, res) {

      res.sendFile(path.join(app.get('appPath'), 'index.html'));
    });
};
