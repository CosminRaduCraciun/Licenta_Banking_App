#Feature: Create new account
#
#  Background:
#    Given The user accesses the main page
#    When The user clicks on the 'Bank Manager Login' button
#    And The user clicks on 'Open Account' button
#    And The user clicks on 'Customer Name' dropdown
#
#  Scenario Outline: The user adds a new  account for existing customer
#    And The user selects first customer in list
#    And The user clicks on 'Currency' dropdown
#    When The user selects the currency '<currency>'
#    And The user clicks on 'Process' button
#    When The user takes the account number from the pop-up banner
#    And The user clicks on the Ok button from the alert
#    And The user clicks on the 'Customers' button
#    When The user searches name "Hermoine"
#    Then The new account created is in Account Numbers
#    Examples:
#      | currency |
#      | Dollar   |
#      | Pound    |
#      | Rupee    |
#
#
#  Scenario Outline: The user adds a new account without selecting a customer name
#    And The user clicks on 'Currency' dropdown
#    When The user selects the currency '<currency>'
#    And The user clicks on 'Process' button
#    Then The user gets an alert on 'Customer Name' field "<alert>"
#    Examples:
#      | currency | alert                              |
#      | Dollar   | Please select an item in the list. |
#
#  Scenario Outline: The user adds a new account without selecting a currency
#    And The user clicks on 'Customer Name' dropdown
#    And The user selects first customer in list
#    And The user clicks on 'Process' button
#    Then The user gets an alert on 'Currency' field "<alert>"
#    Examples:
#      | alert                              |
#      | Please select an item in the list. |