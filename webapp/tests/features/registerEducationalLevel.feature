Feature: Register Educational Level
  In order to have educational level related
  As a employee
  I want to be able to register my educational level on the system

  Scenario: Register successfull
    Given I am logged in as thiago
    When I pick Ensino fundamental on the select with id educationLevel
    When I type on field with id educationInstitution the word Escola Arco Iris
    When I type on date field with id educationStart the date 01/01/2000
    When I type on date field with id educationEnd the date 31/12/2008
    When I type on field with id educationCourse the word Fundamental
    When I type on field with id educationObservation the word Nothing
    When I press the button with id educationRegister
    Then I should see this text Ensino fundamental
    Then I should see this text Fundamental
    Then I should see this text 01/2000
    Then I should see this text 12/2008

    Scenario: Remove successfull
      Given I am logged in as thiago
      When I remove education in line 1
      Then I should not see Ensino fundamental
      
