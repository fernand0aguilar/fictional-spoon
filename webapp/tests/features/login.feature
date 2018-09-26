Feature: This is the login feature
	In order to acess the system
	As a employee
	I want be asked my username and password

	Scenario: Login successfull
		Given I am in login page
    When I type on field with id login_username the word thiago.kairala
    When I type on field with id login_password the word Hnh375ij
		When I press the button with id login_button
		Then I should see THIAGO KAIRALA on id home_name_user

	Scenario: Login with error
		Given I am in login page
		When I type on field with id login_username the word thiago.kairala
		When I type on field with id login_password the word wrong_pass
		When I press the button with id login_button
		Then a toast should be presented
