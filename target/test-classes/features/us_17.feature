@MedunnaRoom
Feature: US_17 Medunna Room Creation

  Background: Sign in Medunna
    Given user is on the home page :  "https://medunna.com"
    When user clicks on user icon
    Then user clicks on Sign In Button
    And user enters valid username "AdminTeam01" in username input
    And user enters valid password "Team01+" in password input
    And user clicks on Remember Me checkbox
    And user clicks on Sign In submit Button
    And user clicks on Items&Titles
    And user clicks on Room option

  @US017_TC01
  Scenario:TC_01 User (Admin) can create new rooms for impatients
    And user clicks on Create a new room button
    Then user verifies "Create or edit a Room" text is visible
    Then user closes the page


  @US017_TC02
  Scenario:TC_02 When creating a room, there should be room number (required field), room type as TWIN, DELUXE, PREMIUM_DELUXE, SUIT and DAYCARE
    And user clicks on Create a new room button
    And user does not enter room number
    And user selects Suit option from Room Type dropdown
    And user enters "500" in Price input
    And user clicks on Save button
    Then user verifies "This field is required." text is visible for "room number"
    And user enters a unique number "123456" in Room Number input
    And user clicks on Save button
    Then user verifies "Room" text is visible
    Then user closes the page


  @US017_TC03
  Scenario Outline:TC_03 When creating a room, there should be room number (required field), room type as TWIN, DELUXE, PREMIUM_DELUXE, SUIT and DAYCARE
    And user clicks on Create a new room button
    And user enters a unique number "123456" in Room Number input
    Then user verifies "<Room Type>" is selectable from Room Type options
    Then user closes the page

    Examples:
      | Room Type         |
      | TWIN              |
      | DELUXE            |
      | PREMIUM_DELUXE    |
      | SUITE             |
      | DAYCARE           |



  @US017_TC04
  Scenario:TC_04 Current status can be set for the room
    And user clicks on Create a new room button
    And user enters a unique number "123456" in Room Number input
    And user selects Suit option from Room Type dropdown
    And user clicks on status checkbox
    And user verifies status is selected
    Then user closes the page



  @US017_TC05
  Scenario:TC_05 Price can be added and cannot be blank
    And user clicks on Create a new room button
    And user enters a unique number "123456" in Room Number input
    And user selects Suit option from Room Type dropdown
    And user clicks on status checkbox
    And user clicks on Save button
    Then user verifies "This field is required." text is visible for "price"
    And user enters "500" in Price input
    And user clicks on Save button
    Then user verifies "Room" text is visible
    Then user closes the page


  @US017_TC06
  Scenario:TC_06 Description can be provided optionally
    And user clicks on Create a new room button
    And user enters a unique number "123456" in Room Number input
    And user selects Suit option from Room Type dropdown
    And user clicks on status checkbox
    And user enters "300" in Price input
    And user does not enter description in Description input
    And user clicks on Save button
    Then user verifies "Room" text is visible
    Then user closes the page




  @US017_TC07
  Scenario Outline:TC_07 Created date as MM/DAY/YEAR and cannot be typed earlier

    And user clicks on Create a new room button
    And user enters a unique number "123456" in Room Number input
    And user selects "<room type>" from Room Type dropdown
    And user clicks on status checkbox
    And user enters "<price>" in Price input
    And user enters "<description>" in Description input
    And user enters a passed date
    And user clicks on Save button
    Then user verifies "Room" text is visible
    Then user closes the page

    Examples:test_data
      | room type |price | description |
      | SUITE   |300 | With breakfast     |




  @US017_TC08
  Scenario Outline:TC_08 Created date as MM/DAY/YEAR and cannot be typed earlier

    And user clicks on Create a new room button
    And user enters a unique number "123456" in Room Number input
    And user selects "<room type>" from Room Type dropdown
    And user clicks on status checkbox
    And user enters "<price>" in Price input
    And user enters "<description>" in Description input
    And user enters current date or later date
    And user clicks on Save button
    Then user verifies "Room" text is visible
    Then user closes the page

    Examples:test_data
      | room type |price | description |
      |  SUITE   |300 | With breakfast     |



  @US017_TC09
  Scenario Outline:TC_09 Admin can view all rooms with same items
    And user clicks on Create a new room button
    And user enters "<room numbers>" in Room Number input
    And user selects "<room type>" from Room Type dropdown
    And user clicks on status checkbox
    And user enters "<price>" in Price input
    And user enters "<description>" in Description input
    And user enters current date or later date
    And user clicks on Save button
    And user clicks on Created Date
    Then user verifies all rooms are created with same room numbers "<room numbers>"
    Then user closes the page

    Examples:test_data
      | room numbers | room type |price | description |
      | 25121101 | SUITE   |300 | With breakfast      |
      | 25121102 | DELUXE  |500 | With terrace        |
      | 25121103 | DAYCARE | 440  | With extra bad    |
      | 25121104 | PREMIUM_DELUXE  |500 | With terrace  |
      | 25121105 | TWIN | 440  | With breakfast    |


  @US017_TC10
  Scenario Outline:TC_11 Admin can edit(update) existing rooms
    And user clicks on Created Date
    And user clicks on Edit button
    And user edits "<room type>" from Room Type dropdown
    And user clicks on status checkbox
    And user edits "<price>" in Price input
    And user edits "<description>" in Description input
    And user clicks on Save button
    And user clicks on Created Date
    Then user verifies the room is edited with new "<room type>", "<price>" and "<description>"
    Then user closes the page

    Examples:test_data
      | room type |price | description |
      | SUITE   | 490 | With breakfast and tea      |






#not: got to https://editor.swagger.io/ -->file-->omport file-->downloads  (son dosya)