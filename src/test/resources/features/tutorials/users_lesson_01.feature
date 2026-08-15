Feature: Users table

  Scenario: Read first user - lesson 01
   # Given user opens tables page lesson 01

#  Scenario: User opens tables - lesson 02
#    Given user opens tables page lesson 02
#
#  Scenario: User opens logins - lesson 02
#    Given user opens logins page lesson 02
#
#  Scenario: User opens tables - lesson 03
#    Given user opens tables page lesson 02
#    Then table contains 4 rows
#
#  Scenario: User opens challenging dom - lesson 04
#    Given user opens challenging dom lesson 04
#    Then table should contain rows
#
#  Scenario: User opens dynamic loading - lesson 05
#    Given user opens dynamic loading page - lesson 05
#    When user starts loading
#    Then Then hello world message is displayed
#
#  Scenario: User exists in table - lesson 06
#    Given user opens challenging dom lesson 04
#    Then table should contain rows
#    Then table contains user "Iuvaret"
#
  Scenario: User opens logins - lesson 08
    Given user opens tables page lesson 02
    And table contains 4 rows
    And email of "Doe" should be "jdoe@hotmail.com"
    And user "Smith" exists in table

  Scenario: Get texts from rows containing Smith
    Given user opens tables page lesson 07
    Then rows containing "Smith" should be returned
    Then rows containing "http://www.timconway.com" should be returned

  Scenario: Get rows matching multiple conditions
    Given user opens tables page lesson 07
    Then rows matching conditions should be returned
      | Smith          |
      | jsmith@gmail.com  |