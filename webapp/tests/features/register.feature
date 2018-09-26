Feature: Register user
  In order to include a user on the systema
  As a employee of the RH
  I want to be able to register a new user on the system

  Scenario: Selecting public server as a category should enable fields relative to the public server register
    Given I am logged in as thiago
    When I press the button with id register_user_lnk
    When I pick Servidor on the select with id register_user_input_category
    Then the field register_user_input_public_company should be visible
    Then the field register_user_input_retired should be visible
    Then the field register_user_input_income_date should be visible
    Then the field register_user_input_entry_date should be visible
    Then the field register_user_input_nomination_date should be visible
    Then the field register_user_input_publication_date should be visible

  Scenario: Selecting outsources as a category should enable fields relative to the outsourced employee
    Given I am logged in as thiago
    When I press the button with id register_user_lnk
    When I pick Terceirizado on the select with id register_user_input_category
    Then the field register_user_input_clt should be visible
    Then the field register_user_input_clt_expedition_date should be visible
    Then the field register_user_input_clt_company should be visible
    Then the field register_user_input_outsorced_entry_date should be visible
    Then the field register_user_input_outsourced_uf should be visible
    Then the field register_user_input_outsourced_company should be visible

  Scenario: Filling the name should give me the network name
    Given I am logged in as thiago
    When I press the button with id register_user_lnk
    When I type on field with id register_user_input_name the word João Marcos Oliveira Junior Pedrosa
    When I leave the field
    Then the input register_user_input_network_login should have joao.pedrosa

  Scenario: Filling the name that colides with another existent should generate another name
    Given I am logged in as thiago
    When I press the button with id register_user_lnk
    When I type on field with id register_user_input_name the word thiago ramires kairala
    When I leave the field
    Then the input register_user_input_network_login should have thiago.ramires

  Scenario: Register user successfull
    Given I am logged in as thiago
    When I press the button with id register_user_lnk
    When I type on field with id register_user_input_name the word João Marcos Oliveira Junior Pedrosa
    When I type on field with id register_user_input_registry the word 00000
    When I pick Bolsista on the select with id register_user_input_category
    When I pick Administrador do Sistema on the select with id register_user_input_role
    When I pick DPOA on the select with id register_user_input_directory
    When I pick CPM on the select with id register_user_input_coordination
    When I pick DINF on the select with id register_user_input_divison
    When I type on field with id register_user_input_rg the word 1234567
    When I type on field with id register_user_input_rg_issuing_company the word SSP
    When I type on date field with id register_user_input_rg_issuing_date the date 10/04/1994
    When I pick DF on the select with id register_user_input_rg_issuing_uf
    When I type on field with id register_user_input_rg_issuing_cpf the word 04640704143
    When I pick Masculino on the select with id register_user_input_sex
    When I pick O+ on the select with id register_user_input_blood_type
    When I type on field with id register_user_input_military_document the word 123456
    When I type on field with id register_user_input_military_series the word 213
    When I type on field with id register_user_input_military_category the word 123
    When I pick DF on the select with id register_user_input_military_uf
    When I type on field with id register_user_input_election_document the word 123123
    When I type on field with id register_user_input_election_document_zone the word 123
    When I type on field with id register_user_input_election_document_section the word 123
    When I pick DF on the select with id register_user_input_military_document_uf
    When I type on field with id register_user_input_pis the word 132456
    When I type on date field with id register_user_input_first_job_date the date 10/04/1994
    When I type on field with id register_user_input_mother_name the word Nome Mãe
    When I pick BRANCO on the select with id register_user_input_color
    When I type on field with id register_user_input_place_of_birth the word Brasileiro
    When I pick DF on the select with id register_user_input_birth_district
    When I type on date field with id register_user_input_birth_date the date 27/02/1982
    When I type on field with id register_user_input_address the word SMPW quadra 16 conjunto 3
    When I type on field with id register_user_input_zip_code the word 71741603
    When I type on field with id register_user_input_complement the word Lote 8
    When I type on field with id register_user_input_number the word Casa F
    When I type on field with id register_user_input_neighborhood the word Park Way
    When I pick DF on the select with id register_user_input_address_uf
    When I pick Brasília on the select with id register_user_input_address_city
    When I pick Casado on the select with id register_user_input_civil_status
    When I type on field with id regsiter_user_input_spouse_name the word conjuge de teste
    When I type on date field with id register_user_input_spouse_birth_date the date 10/04/1994
    When I press the button with id register_user_send_btn
    Then a toast should be presented
    Then I should see this text Funcionário cadastrado com sucesso
    Then I wait 3 secconds
