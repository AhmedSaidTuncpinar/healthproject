@US_021
Feature: US_021 Admin can edit existing user.

  Background: Medunna Sign In to create and activate user
    Given user navigate "medunna_url" page
    When clicks on user icon
    And clicks on Register option
    And enters valid ssn in ssn input
    And enters valid first name in first name input
    And enters valid last name in last name input
    And enters valid username in username input
    And enters valid email in email input
    And enters new password in new password input
    And enters password again in new password confirmation
    And clicks register button
    Then verify new user registered successfully
    And clicks user icon and Sign in option to login as admin
    And enters "medunna_username_1" in username input
    And enters "medunna_password_1" in password input
    And clicks on Remember Me check box
    And clicks on Sign In submit button

  @US_21_TC_01
  Scenario: US_21_TC_01 Admin can view registered people info as firstname, lastname, email.
    When admin clicks on Administration option
    And clicks on User management option
    Then verify users heading is visible on the page
    And clicks on Created date column to sort users
    And clicks on View button of created user
    Then verify first name, last name, email credentials
    Then close the application

  @US_21_TC_02
  Scenario: US_21_TC_02 Edit option should be visible for existing user.
    When admin clicks on Administration option
    And clicks on User management option
    And clicks on Created date column to sort users
    Then verify Edit button is visible for created user
    Then close the application

  @US_21_TC_03
  Scenario: US_21_TC_03 Admin can activate existing user.
    When admin clicks on Administration option
    And clicks on User management option
    And clicks on Created date column to sort users
    And clicks on Edit button of created user
    Then verify user is on Edit page
    When clicks on activate check box
    And clicks on save button
    Then verify user has been activated
    Then close the application


  @US_21_TC_04
  Scenario Outline: US_21_TC_04 Admin can assign roles to existing user.
    When admin clicks on Administration option
    And clicks on User management option
    And clicks on Created date column to sort users
    And clicks on Edit button of created user
    Then verify admin can assign "<role>" "<index>" to user
    And close the application

    Examples:
      |    role          |  index |
      |  ROLE_ADMIN      | 0      |
      |  ROLE_USER       | 1      |
      |  ROLE_PATIENT    | 2      |
      |  ROLE_STAFF      | 3      |
      |  ROLE_PHYSICIAN  | 4      |

  @US_21_TC_05
  Scenario: US_21_TC_05 Admin can delete existing user.
    When admin clicks on Administration option
    And clicks on User management option
    And admin clicks on Created date column to sort users
    Then verify Delete button is visible
    And clicks on Delete button
    And confirm Delete operation in confirmation message
    Then verify user is deleted
    And close the application



















