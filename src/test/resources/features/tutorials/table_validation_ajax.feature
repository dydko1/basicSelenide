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

  Scenario: Population  validation
    Given I open tables population page "https://www.worldometers.info/world-population/population-by-country"
    When I read all countries
    Then I should see following countries:
      | name    | population | yearlyChange | density |
      | Poland  | 37,843,188 | -0.78%       | 124     |
      | Germany | 83,644,258 | -0.51%       | 240     |

  Scenario: ISO country page
    Given I open tables population page "https://www.iban.com/country-codes"
    When I read all ISO countries
    Then I should see following ISO countries:
      | country | alpha2 | alpha3 | numeric |
      | Poland  | PL     | POL    | 616     |
      | Germany | DE     | DEU    | 276     |
      | France  | FR     | FRA    | 250     |

  Scenario: ISO country page - repeated
    Given I open tables population page "https://www.iban.com/country-codes"
    When I read all ISO countries2
    Then I should see following ISO countries2:
      | country | alpha2 | alpha3 | numeric |
      | Poland  | PL     | POL    | 616     |
      | Germany | DE     | DEU    | 276     |
      | France  | FR     | FRA    | 250     |