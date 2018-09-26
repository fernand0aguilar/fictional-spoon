'use strict';

var fs = require('fs');
var webdriver = require('selenium-webdriver');
var platform = process.env.PLATFORM || "CHROME";
var until = webdriver.until;

var buildChromeDriver = function() {
  return new webdriver.Builder().
  withCapabilities(webdriver.Capabilities.chrome()).
  build();
};

var buildFirefoxDriver = function() {
  return new webdriver.Builder().
  withCapabilities(webdriver.Capabilities.firefox()).
  build();
};

switch (platform) {
  case 'FIREFOX':
    var driver = buildFirefoxDriver();
    break;
  default:
    var driver = buildChromeDriver();
}

var getDriver = function() {
  return driver;
};

var World = function World() {

  var defaultTimeout = 5000;
  var screenshotPath = "screenshots";

  this.webdriver = webdriver;
  this.driver = driver;

  if (!fs.existsSync(screenshotPath)) {
    fs.mkdirSync(screenshotPath);
  }

  this.waitForCss = function(cssLocator, timeout) {
    var waitTimeout = timeout || defaultTimeout;
    return driver.wait(until.elementLocated({
      css: cssLocator
    }), waitTimeout);
  };

  this.waitForXpath = function(xpath, timeout) {
    var waitTimeout = timeout || defaultTimeout;

    return driver.wait(
      until.elementLocated(
        webdriver.By.xpath(xpath)), waitTimeout
    );
  }

  this.waitForTagName = function(tagName, timeout) {
    var waitTimeout = timeout || defaultTimeout;

    return driver.wait(
      until.elementLocated(
        webdriver.By.tagName(tagName)), waitTimeout
    );
  };

  this.waitForTagNames = function(tagName, timeout) {
    var waitTimeout = timeout || defaultTimeout;

    return driver.wait(
      driver.findElements(webdriver.By.tagName(tagName), waitTimeout)
    );
  }

  this.waitForId = function(idLocator, timeout) {
    var waitTimeout = timeout || defaultTimeout;
    return driver.wait(until.elementLocated({
      id: idLocator
    }), waitTimeout);
  };

  this.type = function(id, word) {
    return driver.findElement({
        id: id
      })
      .sendKeys(word);
  }

  this.click = function(id) {
    return driver.wait(until.elementLocated({
      id: id
    }), defaultTimeout).then(function(response) {
      return response.click();
    })
  }

  this.waitForUrl = function(url) {
    return driver.wait(function() {
      return driver.getCurrentUrl().then(function(response) {
        response = response.match(/http:\/\/localhost:9000\/#\/(.+)/)[1];
        return response == url;
      })
    }, 2000);
  }
};

module.exports.World = World;
module.exports.getDriver = getDriver;
