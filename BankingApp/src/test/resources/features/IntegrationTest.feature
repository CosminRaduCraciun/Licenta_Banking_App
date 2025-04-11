Feature: Create new customer and open new accounts

  Background:
    Given The user accesses the main page
    When The user clicks on the 'Bank Manager Login' button
    And The user clicks on the 'Add Customer' button

  Scenario Outline: The user can successfully create new customer
    And The user writes 'first name' "Cosmin"
    And The user writes 'last name' "Craciun"
    And The user writes 'post code' "E452346"
    And The user clicks on submit add customer button
    And The user gets the alert banner and clicks ok
    And The user clicks on 'Open Account' button
    And The user clicks on 'Customer Name' dropdown
    And The user clicks on name
    And The user clicks on 'Currency' dropdown
    And The user selects the currency "<currency>"
    And The user clicks on 'Process' button
    And The user clicks on the Ok button from the alert
    And The user clicks on the 'Customers' button
    And The user searches name "Cosmin"
    Then The user checks if customer in list
    And The user clicks on 'Home' button
    And The user clicks on 'Customer Login' button
    And The user selects the username
    And The user clicks the Login button
    Then The user gets the message Welcome <name>
    And The user checks their current balance
    And The user clicks on Deposit tab
    And The user enters the amount of money for deposit "15"
    And The user clicks on Deposit button
    Then The deposit success message is displayed
    And The user's balance after deposit is updated correctly
    When The user clicks on the Transactions tab
    And The user clicks on the Date-time sorting button
    Then The user checks if the first amount is the same as the one typed before "15"
    And The user checks if the Transaction type is correct "Credit"
    When The user clicks on the 'Back' button
    And The user checks their current balance
    When The user clicks on Withdraw tab
    And The user enters the amount of money for withdraw "4"
    And The user clicks on Withdraw button
    Then The withdraw success message is displayed
    And The user's balance after withdraw is updated correctly
    When The user clicks on the Transactions tab
    And The user clicks on the Date-time sorting button
    Then The user checks if the first amount is the same as the one typed before "4"
    And The user checks if the Transaction type is correct "Debit"
    Examples:
      | currency |
      | Dollar   |