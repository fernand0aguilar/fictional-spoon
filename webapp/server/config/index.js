/*
 * Config
 */

'use strict';

var path = require('path');

var env = {
  // Environment
  env: process.env.NODE_ENV,
  // Root path
  root: path.normalize(path.join(__dirname, './')),
  // Server port
  port: 9000
};

console.log(process.env.NODE_ENV);

if (process.env.NODE_ENV === 'development') {
  env.root = path.normalize(path.join(__dirname, '../..'));
} else if (process.env.NODE_ENV === 'production') {
  env.root = path.normalize(path.join(__dirname, '../../resources/dist'));
}

module.exports = env;
