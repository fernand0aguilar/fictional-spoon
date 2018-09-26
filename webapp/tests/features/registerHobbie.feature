Feature: Register Hobbies
  In order to have hobbies declarated
  As a employee
  I want to be able to register my hobbies on the system

  Scenario: Register hobbies successfully
    Given I am logged in as thiago
    When I type on field with id home_input_hobbie_name the word Desenvolvimento de Sistemas
    When I press the button with id home_input_hobbie_btn
    Then I should see this text Desenvolvimento de Sistemas

  Scenario: Remove hobbies successfully
    Given I am logged in as thiago
    When I remove hobbie in line 1
    Then I should not see Desenvolvimento de Sistemas
