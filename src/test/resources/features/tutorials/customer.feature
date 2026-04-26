Feature: Customer creation

  Scenario: Build customer with DSL
    When I build customer request
      | pesel         | firstName | surname | city  |
      | $pesel.@pesel | Jan       | Pop     | ddddd |