Feature: Borrow Calculator Test
  Verify borrowing estimate, start over functinality and error message

  @tag1
  Scenario: Borrow Calculator Test1
    Given I open calculator
    When I enter following details
      | Application Type   | Single          |
      | No. of Dependents  |               0 |
      | Property Type      | Home to live in |
      | Income Before Tax  |           80000 |
      | Other Income       |           10000 |
      | Living Expenses    |             500 |
      | Current Home Loan  |               0 |
      | Other Loan         |             100 |
      | Other Commitments  |               0 |
      | Credit Card Limits |           10000 |
    And I click on Work out how much I could borrow button
    Then borrowing estimate should be "$467,000"
    When I click on start over
    Then all the fileds in the forms get cleared
    When I enter Living expenses as "1"
    And I click on Work out how much I could borrow button
    Then an error message "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100 641." is displayed
