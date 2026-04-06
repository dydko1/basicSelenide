Feature: Simple validation with DataTable

  Scenario: Verify one user row in UI table
    Given I open tables page "https://the-internet.herokuapp.com/tables"
    Then I validate table contains:
      | Last Name | First Name | Email            | Due   | Web Site              | Action      |
      | Smith     | John       | jsmith@gmail.com | $50.00 | http://www.jsmith.com | edit delete |