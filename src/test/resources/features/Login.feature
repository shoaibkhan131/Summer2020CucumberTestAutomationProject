@login
Feature: As user I want to be able to login under different roles
# this is a comment

  #this is a comment.
  #Scenario: #Background - test precondition
  #will be executed before every scenario in the particularfeature file
  Background: common steps
    Given user is on the login page

#  Scenario: Login as a sales manger
#    When user logs in
#    Then user should see dashboard page
#
#@parametrized_test @smoke_test
#    Scenario: Parametrized login
#      When user logs in as a "store manager"
#      Then user should see dashboard page
#  #"driver" - is a paramter. "" allows to do test parametrization which helps to re-use test steps
#
#  @parametrized_test @smoke_test
#  Scenario: Parametrized login
#    When user logs in as a "sales manager"
#    Then user should see dashboard page

@s_o @with_two_columns
    Scenario Outline: Parametrized login as <role>
    When user logs in as a "<role>"
    Then user should see "<page_title>" page

    Examples:
    |role         | page_title      |
    |sales manager|Dashboard        |
    |store manager|Dashboard|
    |driver       |Quick Launchpad|


  @negative_login @smoke
  Scenario: Invalid Password
    When user logs in as a "storemanager85" usernmae and "wrong" password
    Then user verifies that "Invalid user name or password." message is displayed


  @negative_scenario_outline
    Scenario Outline: invalid login "<username>" usernmae and "<password>"
      When user logs in as a "<username>" usernmae and "<password>" password
      Then user verifies that "<message>" message is displayed

      Examples: data set

      |username|password|message                       |
      |wrong   |bad     |Invalid user name or password.|
      |wrong213|bad     |Invalid user name or password.|
      |wrong32 |bad     |Invalid user name or password.|
      |wrong12 |bad     |Invalid user name or password.|

