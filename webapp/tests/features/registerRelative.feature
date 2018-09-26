Feature: Register relatives
  In order to have the legal rights related
  As a employee
  I want to be able to register relatives on the system

  Scenario: Register successfull
    Given I am logged in as thiago
    When I type on field with id relative_name the word Arya Stark
    When I type on field with id relative_cpf the word 04640704143
    When I type on field with id relative_mother_name the word Catlyn Stark
    When I type on date field with id relative_date_of_birth the date 10/04/1994
    When I press the button with id register_relative_btn
    Then I should see this text Arya Stark
    Then I should see this text 046.407.041-43
    Then I should see this text 10/04/1994

  Scenario: Remove successfull
    Given I am logged in as thiago
    When I type on field with id relative_name the word Sansa Stark
    When I type on field with id relative_cpf the word 32649347104
    When I type on field with id relative_mother_name the word Catlyn Stark
    When I type on date field with id relative_date_of_birth the date 10/04/1994
    When I press the button with id register_relative_btn
    When I remove relative with cpf 32649347104
    Then I should not see Sansa Stark
