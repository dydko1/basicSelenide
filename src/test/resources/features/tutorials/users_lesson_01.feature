Feature: Users table

  Scenario: Read first user - lesson 01
    Given user opens tables page lesson 01

  Scenario: User opens tables - lesson 02
    Given user opens tables page lesson 02

  Scenario: User opens logins - lesson 02
    Given user opens logins page lesson 02

  Scenario: User opens tables - lesson 03
    Given user opens tables page lesson 02
    Then table contains 4 rows

  Scenario: User opens challenging dom - lesson 04
    Given user opens challenging dom lesson 04
    Then table should contain rows

  Scenario: User opens dynamic loading - lesson 05
    Given user opens dynamic loading page - lesson 05
    When user starts loading
    Then Then hello world message is displayed

  Scenario: User exists in table - lesson 06
    Given user opens challenging dom lesson 04
    Then table should contain rows
    Then table contains user "Iuvaret"

  Scenario: User opens logins - lesson 08
    Given user opens tables page lesson 02
    Then email of "Doe" should be "jdoe@hotmail.com"

  Scenario: User opens logins - lesson 09
    Given user opens tables page lesson 02
    Then user "Smith" should have first name "John"


  Scenario: Verify multiple users
    Given user opens tables page lesson 02
    Then users should match:
      | lastName | firstName | email            | due    | webSite               | action      |
      | Smith    | John      | jsmith@gmail.com | $50.00 | http://www.jsmith.com | edit delete |
      | Bach     | Frank     | fbach@yahoo.com  | $51.00 | http://www.frank.com  | edit delete |

  Scenario: Share user between steps
    Given user opens tables page lesson 02
    And user "Smith" is loaded
    Then loaded user should have first name "John"

  Scenario: Validate complete user
    Given user opens tables page lesson 02
    And user "Smith" is loaded
    And expected user is:
      | lastName | firstName | email            | due    | webSite               | action      |
      | Smith    | John      | jsmith@gmail.com | $50.00 | http://www.jsmith.com | edit delete |
    Then loaded user should match expected user

