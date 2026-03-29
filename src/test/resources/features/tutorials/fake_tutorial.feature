@fake_typed_value
Feature: Typed values POC

  Scenario: Parse and store typed values
    Given I store variables:
      | key       | value       |
      | active    | true        |
      | qty       | 12          |
      | bigNumber | 5000000000  |
      | price     | 1299.99     |
      | note      | hello world |
    And variable "active" should be boolean true
    And variable "qty" should be int 12
    And variable "bigNumber" should be long 5000000000
    And variable "price" should be decimal "1299.99"
    And variable "note" should be string "hello world"

