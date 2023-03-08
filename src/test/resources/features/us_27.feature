@US_027
Feature: US_027 User can use Contact Portal.

  @US_027_TC_001
  Scenario: US_027_TC_001 Non-existing user can use Contact Portal without log in
    Given user goes to the "medunna_url" page
    When user click on Contact icon
    Then verifies that user is on Contact page
    And user enters "Lindsay Green" in name text box
    And user enters "lgre@gmail.com" in email text box
    And user enters "Billing" in subject text box
    And user enters "Billing request" in message text box
    And user clicks on Send button
    Then verify that message has been received successfully
    Then close the application


  @US_027_TC_002
  Scenario: US_027_TC_002 Name, Email, Subject cannot be left blank while sending message.
    Given user goes to the "medunna_url" page
    When user click on Contact icon
    Then verifies that user is on Contact page
    And user enters "Billing request" in message text box
    And user clicks on Send button
    Then verify Name, Email, and Subject fields are required to send a message successfully.
    Then close the application


  @US_027_TC_003
  Scenario: US_027_TC_003 Any existing user can use Contact Portal without log in
    Given user goes to the "medunna_url" page
    When user click on user icon
    And user click on Sign In option
    And user enter "PatientJohn" in username input
    And user enter "12345Pp9$*" in password input
    And user click on Remember Me check box
    And user click on Sign In submit button
    When user click on Contact icon
    Then verifies that user is on Contact page
    And user enters "Patient John" in name text box
    And user enters "patientjohn@gmail.com" in email text box
    And user enters "Billing" in subject text box
    And user enters "Billing request" in message text box
    And user clicks on Send button
    Then verify that message has been received successfully
    Then close the application


  @US_027_TC_004
  Scenario: US_027_TC_004 Name, Email, Subject cannot be left blank while sending message as registered user.
    Given user goes to the "medunna_url" page
    When user click on user icon
    And user click on Sign In option
    And user enter "PatientJohn" in username input
    And user enter "12345Pp9$*" in password input
    And user click on Remember Me check box
    And user click on Sign In submit button
    When user click on Contact icon
    Then verifies that user is on Contact page
    And user enters "Billing request" in message text box
    And user clicks on Send button
    Then verify Name, Email, and Subject fields are required to send a message successfully.
    Then close the application


  @US_027_TC_005
  Scenario: US_027_TC_005 Message box can be left blank.
    Given user goes to the "medunna_url" page
    When user click on user icon
    And user click on Sign In option
    And user enter "PatientJohn" in username input
    And user enter "12345Pp9$*" in password input
    And user click on Remember Me check box
    And user click on Sign In submit button
    When user click on Contact icon
    Then verifies that user is on Contact page
    And user enters "Patient John" in name text box
    And user enters "patientjohn@gmail.com" in email text box
    And user enters "Billing" in subject text box
    And user clicks on Send button
    Then verify Message field is not required to send a message successfully.
    Then close the application


  @US_027_TC_006
  Scenario Outline: US_027_TC_006 Any type of user (patient, personal, doctor) can use Contact Portal after logged in
    Given user goes to the "medunna_url" page
    When user click on user icon
    And user click on Sign In option
    And user enter "<Username>" in username input
    And user enter "<Password>" in password input
    And user click on Remember Me check box
    And user click on Sign In submit button
    And user click on Contact icon
    Then verifies that user is on Contact page
    And user enters registered "<Name>" username  in name text box
    And user enters registered "<Email>" in email text box
    And user enters a "<Subject>" in subject text box
    And user enters a "<Message>" in message text box
    And user clicks on Send button
    Then verify that message has been received successfully
    Then close the application

    Examples: Test Data
      |    Username    |   Password      |   Name    |    Email              |    Subject    |   Message       |
      |   PatientJohn  |  12345Pp9$*     |  Patient  | patientjohn@gmail.com |    Billing    | Billing request |
      |   PersonelMary |  98765Mm3#*     |  Personel | personelmary@gmail.com|    Billing    | Billing response|
      |   DoctorTom    |  33221Tt5%*     |  Doctor   | doctortom@gmail.com   |    Billing    | Billing info    |


  @US_027_TC_007
  Scenario: US_027_TC_007 There should be a valid email to send a message successfully.
    Given user goes to the "medunna_url" page
    When user click on user icon
    And user click on Sign In option
    And user enter "PatientJohn" in username input
    And user enter "12345Pp9$*" in password input
    And user click on Remember Me check box
    And user click on Sign In submit button
    When user click on Contact icon
    Then verifies that user is on Contact page
    And user enters "Patient John" in name text box
    And user enters "patientjohn@gmailcom" in email text box
    And user enters "Billing" in subject text box
    And user clicks on Send button
    Then verify that invalid email error message is displayed on the page
    Then close the application


  @US_027_TC_008
  Scenario: US_027_TC_008 Admin can use Contact Portal after logged in
    Given user goes to the "medunna_url" page
    When user click on user icon
    And user click on Sign In option
    And user enter "AdminTeam01" in username input
    And user enter "Team01+" in password input
    And user click on Remember Me check box
    And user click on Sign In submit button
    When user click on Contact icon
    Then verifies that admin is on Contact page
    And admin enters registered "AdminTeam01" username  in name text box
    And admin enters registered "adminteam01@gmail.com" in email text box
    And admin enters a "Billing" in subject text box
    And admin enters a "Billing info" in message text box
    And admin clicks on Send button
    Then verify that message has been received successfully
    Then close the application


  @US_027_TC_009
  Scenario: US_027_TC_009 User should be able to send the same message more than once.
    Given user goes to the "medunna_url" page
    When user click on user icon
    And user click on Sign In option
    And user enter "PatientJohn" in username input
    And user enter "12345Pp9$*" in password input
    And user click on Remember Me check box
    And user click on Sign In submit button
    When user click on Contact icon
    Then verifies that user is on Contact page
    And user enters "Patient John" in name text box
    And user enters "patientjohn@gmail.com" in email text box
    And user enters "Billing" in subject text box
    And user enters "Billing request" in message text box
    And user clicks on Send button
    Then verify that message has been received successfully
    And user clicks on Send button again
    Then verify success message is displayed again
    Then close the application


  @US_027_TC_010
  Scenario: US_027_TC_010 Message box should accept any type of characters (letters, digits, and special characters)
    Given user goes to the "medunna_url" page
    When user click on Contact icon
    Then verifies that user is on Contact page
    And user enters "Lindsay Green" in name text box
    And user enters "lgre@gmail.com" in email text box
    And user enters "Billing" in subject text box
    And user enters "2. 250$ Billing request!" in message text box
    And user clicks on Send button
    Then verify that message has been received successfully
    And verify the message in the message box
    Then close the application


















