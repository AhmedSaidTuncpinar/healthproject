@US_031_Api
Feature: API_test


  Scenario: US_031 Validate all physicians using API and DB

    When user send post request "https://medunna.com/api/authenticate" for get token with username "AdminTeam01" and password "Team01+"
    And user sends GET request to "https://medunna.com/api/physicians" with token
    Then HTTP status code 200
    Then verify physicians ids in database