@US_014
Feature: US_014 Doctor should see all test results.

  Background: Medunna Sign In as physician
    Given user-physician is on "medunna_url" page
    When user-physician click on user icon
    And user-physician click on Sign In option
    And user-physician enter "DoctorTom" in username input
    And user-physician enter "33221Tt5%*" in password input
    And user-physician click on Remember Me check box
    And user-physician click on Sign In submit button
    And user-physician click on MyPages
    And user-physician click on My Appointments
    And user-physician click on Edit button

  @US_014_TC_001
  Scenario: US_014_TC_001 Physician should be able to see all test details
    Then verify Show Test Results button is displayed on the site
    Then close the application

  @US_014_TC_002
  Scenario: US_014_TC_001 Physician should be able to see all test details
    When user-physician click on Show Test Results button
    Then verify View Results button is displayed on the site
    And user-physician click on View Results button
    Then verify Test Results page is displayed
    And verify test id, name, result, default max value is visible, default min value is visible, test is visible, description is visible, date is visible
    Then close the application

  @US_014_TC_003
  Scenario: US_014_TC_002 Physician should be able to request inpatient
    Then verify Request Inpatient button is displayed on the site
    When user-physician click on Request Inpatient button
    Then verify Inpatient request success or already done failure message is displayed on the site
    Then close the application

