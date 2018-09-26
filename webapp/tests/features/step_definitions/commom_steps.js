var expect = require('chai').expect;
var webdriver = require('selenium-webdriver')
var until = webdriver.until;

var logins = {
  thiago: {
    username: "thiago.kairala",
    password: 'Hnh375ij'
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
    var type = this.type;
    return this.waitForId(id).then(function(response) {
      type(id, word);
    })
  });

  this.When(/^I type on date field with id (.+) the date (.+)$/, function(id, date) {
    var waitForCss = this.waitForCss;
    var driver = this.driver;

    return this.waitForId(id).then(function(response) {
      return response.findElement(webdriver.By.tagName('input')).then(function(response) {
        return response.clear().then(function() {
          return response.sendKeys(date).then(function() {
            return driver.sleep(1000);
          });
        });
      });
    });
  });

  this.When(/^I leave the field$/, function() {
    return this.waitForTagName('body').click();
  })

  this.When(/I press the button with id (.+)$/, function(id) {
    return this.waitForId(id).click();
  });

  this.When(/I remove relative with cpf (.+)/, function(id) {
    return this.click(id);
  });

  this.When(/I remove hobbie in line (.+)$/, function(id) {
    return this.click(id);
  });

  this.When(/I remove education in line (.+)$/, function(id) {
    return this.click(id);
  });

  this.When(/^I pick (.+) on the select with id (.+)$/, function(field, id) {
    var waitForXpath = this.waitForXpath;
    var driver = this.driver;
    return this.waitForId(id).click().then(function() {
      return driver.sleep(200).then(function() {
        return waitForXpath("//md-content//div[text() = '" + field + "']", 1000).click();
      });
    });
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

    return driver.sleep(1000).then(function() {
      return driver.findElement(webdriver.By.tagName("body")).getAttribute("innerHTML").then(function(html) {
        if (html.lastIndexOf(text) > 0) {
          // nothing to do.
        } else {
          throw (new Error("Texto " + text + " esperado porém não encontrado"));
        }
      })
    });
  });

  this.Then(/^I should not see (.+)$/, function(text) {
    var driver = this.driver;

    return driver.sleep(2000).then(function() {
      return driver.findElement(webdriver.By.tagName("body")).getAttribute("innerHTML").then(function(html) {
        if (html.lastIndexOf(text) > 0) {
          throw (new Error("Texto " + text + " não esperado porém encontrado"));
        } else {
          // nothing to do.
        }
      })
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
    return this.waitForTagName('md-toast');
  });

  this.Then(/^I wait (.+) secconds$/, function(time) {
    return this.driver.sleep(Number(time) * 1000);
  })

  this.Then(/^the input (.+) should have (.+)$/, function(id, text) {
    var waitForId = this.waitForId;
    return this.driver.sleep(1000).then(function() {
      return waitForId(id).getAttribute("value").then(function(response) {
        if (response == text) {
          // nothing to do.
        } else {
          throw (new Error("Input should have the value " + text + " but has " + response));
        }
      })
    })
  });

  this.Then(/^the field (.+) should be visible$/, function(id) {
    return this.waitForId(id);
  })

  this.Then(/^I should be in (.+) page$/, function(url) {
    return this.waitForUrl(url);
  });

  this.Then(/^I should close the dialog$/, function() {
    return this.driver.ActionSequence.prototype.click(0, 0);
  })
};

module.exports = commom_steps;
