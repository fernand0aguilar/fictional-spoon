Feature: This is the register leave feature
	In order be able to keep track of the employees abscenses
  As a HR employee
  I want to be able to register leaves on the system

	Scenario: The vacation is calculate as it should
    Given I am logged in as thiago
    When I press the button with id edit_user_lnk
    When I press the button with id list_user_00000000000_register_leave_btn
    When I type on date field with id register_leave_begin_input the date 17/10/2025
    When I type on field with id register_leave_number_of_days_input the word 10
    When I press the button with id register_leave_calculate_btn
    Then I should see this text A saída será de 17/10/2025 á 26/10/2025
    Then I should close the dialog

  Scenario: The justification type should have auto complete field
    Given I am logged in as thiago
    When I press the button with id edit_user_lnk
    When I press the button with id list_user_00000000000_register_leave_btn
    When I type on the field with id register_leave_input_justify the word 00
    Then I should see this text 00.00 - Falta não justificada
