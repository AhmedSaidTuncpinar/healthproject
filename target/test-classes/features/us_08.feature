@US_008
Feature:US_008 Patients should make appointment after logged in

  @US_008_TC_001
  Scenario Outline: US_008_TC_001 When user click on Make an Appointment section First Name, Last Name, SSN, Email boxes should have been filled automatically.
    Given user is on "medunna_url" page
    When click on user icon
    And click on Sign In option
    And enter "PatientJohn" in username input
    And enter "12345Pp9$*" in password input
    And click on Remember Me check box
    And click on Sign In submit button
    When click on MyPages
    And click on Make an Appointment
    Then verify that "<First Name>", "<Last Name>", "<SSN>" , "<Email>" boxes are filled automatically
    Then close the application
    Examples:
      | First Name | Last Name |     SSN      | Email |
      | Patient    | John      | 456-58-9637  | patientjohn@gmail.com |


  @US_008_TC_002
  Scenario: US_008_TC_002 Appointment registration should be done successfully with the Default date in Appointment DateTime box.
    Given user is on "medunna_url" page
    When click on user icon
    And click on Sign In option
    And enter "PatientJohn" in username input
    And enter "12345Pp9$*" in password input
    And click on Remember Me check box
    And click on Sign In submit button
    When click on MyPages
    And click on Make an Appointment
    And enter a valid "444-444-4444" number in Phone box
    Then verify given default date in Appointment DateTime box is next day from the current date
    And click on Send an Appointment Request button
    Then verify appointment registration saved successfully
    Then close the application


  @US_008_TC_003
  Scenario: US_008_TC_003 User should be able to create an appointment successfully when provides a valid future date.
    Given user is on "medunna_url" page
    When click on user icon
    And click on Sign In option
    And enter "PatientJohn" in username input
    And enter "12345Pp9$*" in password input
    And click on Remember Me check box
    And click on Sign In submit button
    When click on MyPages
    And click on Make an Appointment
    And enter a valid "444-444-4444" number in Phone box
    And enter a random future date in Appointment DateTime box
    And click on Send an Appointment Request button
    Then verify appointment registration saved successfully
    Then close the application


  @US_008_TC_004
  Scenario: US_008_TC_004 User should not be able to create an appointment when provides current date.
    Given user is on "medunna_url" page
    When click on user icon
    And click on Sign In option
    And enter "PatientJohn" in username input
    And enter "12345Pp9$*" in password input
    And click on Remember Me check box
    And click on Sign In submit button
    When click on MyPages
    And click on Make an Appointment
    And enter a valid "444-444-4444" number in Phone box
    And enter current date in Appointment DateTime box
    And click on Send an Appointment Request button
    Then verify appointment registration is not saved successfully
    Then close the application


  @US_008_TC_005
  Scenario: US_008_TC_005 User should not be able to create an appointment when provides a past date.
    Given user is on "medunna_url" page
    When click on user icon
    And click on Sign In option
    And enter "PatientJohn" in username input
    And enter "12345Pp9$*" in password input
    And click on Remember Me check box
    And click on Sign In submit button
    When click on MyPages
    And click on Make an Appointment
    And enter a valid "444-444-4444" number in Phone box
    And enter a random past date in Appointment DateTime box
    And click on Send an Appointment Request button
    Then verify appointment registration is not saved successfully
    Then close the application


  @US_008_TC_006
  Scenario Outline: US_008_TC_006 Appointment DateTime box should not accept a non-numeric character.
    Given user is on "medunna_url" page
    When click on user icon
    And click on Sign In option
    And enter "PatientJohn" in username input
    And enter "12345Pp9$*" in password input
    And click on Remember Me check box
    And click on Sign In submit button
    When click on MyPages
    And click on Make an Appointment
    And enter a valid "<Phone>" number in Phone box
    And enter an "<Invalid Date>" in Appointment DateTime box
    Then verify providing "<Invalid Date>" cannot be entered in Appointment DateTime box
    Then close the application
    Examples:
      | Phone        |  Invalid Date |
      | 444-444-4444 |  hhhhAAbb     |
      | 444-444-4444 |  ****##&&     |


  @US_008_TC_007
  Scenario: US_008_TC_007 Phone number text box cannot be left blank.
    Given user is on "medunna_url" page
    When click on user icon
    And click on Sign In option
    And enter "PatientJohn" in username input
    And enter "12345Pp9$*" in password input
    And click on Remember Me check box
    And click on Sign In submit button
    When click on MyPages
    And click on Make an Appointment
    And enter a random future date in Appointment DateTime box
    And click on Send an Appointment Request button
    Then verify appointment cannot be saved successfully without providing a valid phone number.
    Then close the application


  @US_008_TC_008
  Scenario Outline: US_008_TC_008 The order of date should be in format yyyyMMdd.
    Given user is on "medunna_url" page
    When click on user icon
    And click on Sign In option
    And enter "PatientJohn" in username input
    And enter "12345Pp9$*" in password input
    And click on Remember Me check box
    And click on Sign In submit button
    When click on MyPages
    And click on Make an Appointment
    And enter a valid "<Phone>" number in Phone box
    And enter a "<Valid Date>" in Appointment DateTime box
    Then verify providing "<Valid Date>" format is in yearMMdd
    Then close the application
    Examples:
      | Phone        |  Valid Date |
      | 444-444-4444 |  2030/02/27 |


  @US_008_TC_009_API
  Scenario: US_008_TC_009_API Appointment Post Request and Get Request
    Given user sets the necessary path params to create an appointment
    And sets the expected data with valid "Patient", "John", "456-58-9637", "patientjohn@gmail.com", "444-444-4444", "2024-02-21T00:00:00Z", "string", "2023-02-21T16:34:31.108Z", "male", "string"
    And sends POST request and get the response to make an appointment
    Then verify HTTP status code is 201 of appointment post request
    And verify api records
    Given user sends the get request for created appointment data to the url
    And user deserializes data to Java for appointment
    Then verify HTTP status code is 200 of appointment get request
    Then user validate appointment records of registered appointment


  @US_008_TC_010_DB
  Scenario Outline: US_008_TC_010_DB Validate Appointment by id column
    Given user connects to the Medunna application database to read appointment
    And user gets the column "id" from "public.appointment" table
    Then verify table "<table>" and column "<column>" contains expected data "<data>"
    And close the Medunna database connection
    Examples:
      | table              |    column      |         data              |
      | public.appointment |       id       |         1256              |
      | public.appointment |       id       |         1287              |
      | public.appointment |       id       |         1288              |


  @US_008_TC_011_DB
  Scenario:US_008_TC_011_DB Validate Appointment by created_by column
    Given user connects to the Medunna application database to read appointment
    When user sends the query to get the values of "created_by" column from "public.appointment" table
    Then assert there are some appointments created by "patientjohn"
    And close the Medunna database connection




