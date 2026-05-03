Feature: DataTables - subset validation

  Scenario: Check selected users exist in table
    Given I open tables page "https://datatables.net/examples/data_sources/ajax.html"
    Then I expected users
      | Name            | Position         | Office    | Start date |
      | Tiger Nixon     | System Architect | Edinburgh | 2011-04-25 |
      | Garrett Winters | Accountant       | Tokyo     | 2011-07-25 |

  Scenario: GDP validation

    Given I open tables page "https://en.wikipedia.org/wiki/List_of_countries_by_GDP_(nominal)"
    Then GDP table contains countries
      | Country | IMF       | World Bank | UN      |
      | Poland  | 1,134,248 | 917,767    | 914,696 |
      | Rwanda  | 17,336    | 14,252     | 15,111  |