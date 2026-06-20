Feature: Users table

  Scenario: Read first user
    Given user opens tables page lesson 02

  Scenario: Read login user page
    Given user opens login page lesson 02

  Scenario: Read table validation
    Given user opens tables page lesson 02
    Then table contains 4 rows lesson 03