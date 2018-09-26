Feature: This is the remove employee feature
	In order to keep the system safe
  As a RH employee
  I wish to be able to deactivate an user

	Scenario: When the user is deactivated it should present the deactivation date
    Given I am logged in as thiago
    When I press the button with id edit_user_lnk
    When I press the button with id list_user_00000000000_remove_btn
    When I type on date field with id remove_user_date_field the date 16/12/2015
    When I press the button with id remove_user_confirm_btn
    Then I should see this text 16/12/2015

  Scenario: When I remove the current user, it should loggout and should not be able to loggin
    Given I am logged in as thiago
    When I press the button with id edit_user_lnk
    When I press the button with id list_user_11111111111_remove_btn
    When I type on date field with id remove_user_date_field the date 16/12/2015
    When I press the button with id remove_user_confirm_btn
    Then I should be in login page
		When I am logged in as thiago
		Then I should be in login page
