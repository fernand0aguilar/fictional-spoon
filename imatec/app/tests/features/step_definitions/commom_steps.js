var expect = require('chai').expect;
var webdriver = require('selenium-webdriver')
var until = webdriver.until;

var logins = {
  thiago: {
    username: "testUser",
    password: 'testPassword'
  }
};

var commom_steps = function() {
  this.World = require('../support/world.js').World;

  /****************************************************************************
   ********************************* GIVEN *************************************
   ****************************************************************************/
  this.Given(/^I am logged in as (.+)$/, function(name) {
    var driver = this.driver;
    var click = this.click;
    var type = this.type;
    return this.driver.get('http://localhost:9000/#/login').then(function() {
      return type('login_username', logins[name].username, driver).then(function() {
        return type('login_password', logins[name].password, driver).then(function() {
          click('login_button', driver);
        })
      })
    });
  });

  /****************************************************************************
   ********************************* WHEN **************************************
   ****************************************************************************/
  this.Given(/^I am in (.+) page$/, function(route) {
    return this.driver.get('http://localhost:9000/#/' + route);
  });

  this.When(/I type on field with id (.+) the word (.+)$/, function(id, word) {
    return this.type(id, word, this.driver);
  });

  this.When(/I press the button with id (.+)$/, function(id) {
    return this.click(id, this.driver);
  });

  /****************************************************************************
   ********************************* THEN *************************************
   ****************************************************************************/
  this.Then(/I should see (.+) on id (.+)$/, function(text, id) {
    var driver = this.driver;
    return this.waitForId(id);
  });

  this.Then(/I should see this text (.+)$/, function(text) {
    var driver = this.driver;

    return driver.findElement(webdriver.By.tagName("body")).getAttribute("innerHTML").then(function(html) {
      if (html.lastIndexOf(text) > 0) {
        // nothing to do.
      } else {
        throw (new Error("Text " + text + " expected but not found"));
      }
    });
  });

  this.Then(/^I should see a button with (.+) text$/, function(text) {
    return this.waitForTagName("button").then(function(response) {
      response.getAttribute("innerHTML").then(function(response) {
        if (response.lastIndexOf(text) >= 0) {
          // nothing to do.
        } else {
          throw (new Error("Button with " + text + " expected but not found"));
        }
      })
    })
  });

  this.Then(/I should see a link with text (.+) pointing to (.+)$/, function(text, url) {
    return this.waitForCss("[ui-sref='" + url + "']").then(function(response) {
      response.getAttribute("innerHTML").then(function(response) {
        if (text != response) {
          throw (new Error("Linking with " + text + " linking to " + url + " expected but not found"));
        } else {
          // nothing to do.
        }
      })
    })
  });

  this.Then(/^a toast should be presented$/, function() {
    var driver = this.driver;
    return this.driver.wait(until.elementLocated(webdriver.By.tagName('md-toast')))
      .then(function() {
        return driver.findElements({
          tagName: 'md-toast'
        }).length > 0
      });
  });
};

module.exports = commom_steps;
