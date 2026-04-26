Feature: PDF validation

  Scenario: Validate insurance document content
    Then PDF "sample_test_pdf.pdf" should contain:
      | imie  | Jan Kowalski |
      | numer | 1234567890   |
      | kwota | 100 PLN     |