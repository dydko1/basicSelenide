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

  ### tu zacząć
  Scenario: User opens challenging dom - lesson 04
    Given user opens challenging dom lesson 04
    Then table should contain rows