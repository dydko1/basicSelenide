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
#    Then table contains user "Iuvaret"