Feature: Users table

  Scenario: Read first user

    Given user opens tables page
    When user reads first row
    Then user should be valid