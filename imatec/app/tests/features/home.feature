Feature: home page of system
  In order to use the system
  As a user
  I want to see the main page

  Scenario: On home page the word AEB should be written
    Given I am in main/home page
    Then I should see AEB on id aeb

  Scenario: On home page the word MOSTRAR TOAST should be a button
    Given I am in main/home page
    Then I should see this text Mostrar toast

  Scenario: On home page the button Mostrar toast should present a toast
    Given I am in main/home page
    When I press the button with id show_toast
    Then a toast should be presented
    Then I should see a link with text Teste pointing to main.home
