Feature: Lessons - workshop tutorial

  Scenario: Lesson 01
    Given I open tables page "https://datatables.net/examples/data_sources/ajax.html"
    Then I expected users
      | Name            | Position         | Office    | Start date |
      | Tiger Nixon     | System Architect | Edinburgh | 2011-04-25 |
      | Garrett Winters | Accountant       | Tokyo     | 2011-07-25 |
