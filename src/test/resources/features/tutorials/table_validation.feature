@fake_table_validation
Feature: Table validation

  Scenario:  Validate user in table
    Given I open tables page "https://the-internet.herokuapp.com/tables"
    Then I check table contains:
      | Last Name | First Name | Email            | Web Site              |
      | Smith     | John       | jsmith@gmail.com | http://www.jsmith.com |
      | Bach      | Frank      | fbach@yahoo.com  | http://www.frank.com  |
#    And variable "active" should be boolean true
#    And variable "qty" should be int 12
#    And variable "bigNumber" should be long 5000000000
#    And variable "price" should be decimal "1299.99"
#    And variable "note" should be string "hello world"

