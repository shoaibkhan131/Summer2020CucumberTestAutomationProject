Feature: As a user, i want to be able to create calender events

  @calender_Event @smoke
  Scenario: create calender events with default time
    Given user is on the login page
    And user logs in as a "store manager"
    And user navigates to "Activities" and "Calendar Events"
    And user clicks on create calender event button
    When user adds new calender event information
    |Title|B20 Graduation Party|
    |Description|All B20 friends are invited for this party!|
    And user clicks on save and close button
    Then user verifies that new calender event is isplayed:
    |Title|B20 Graduation Party|
    |Description|All B20 friends are invited for this party!|

