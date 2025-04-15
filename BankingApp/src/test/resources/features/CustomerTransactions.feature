#Feature: This feature contains all CustomerLoginPage test
#
#  Background:
#    Given The user accesses the main page
#    And The user clicks on 'Customer Login' button
#    And The user clicks on 'Customer Name' dropdown
#
#  Scenario: The user can successfully make a deposit
#    And The user selects first customer in list
#    And The user clicks the Login button
#    And The user checks their current balance
#    And The user clicks on Deposit tab
#    And The user enters the amount of money for deposit "20"
#    And The user clicks on Deposit button
#    Then The deposit success message is displayed
#    And The user's balance after deposit is updated correctly
#
#  Scenario: The user can successfully make a withdraw
#    And The user selects first customer in list
#    And The user clicks the Login button
#    And The user checks their current balance
#    When The user clicks on Withdraw tab
#    And The user enters the amount of money for withdraw "15"
#    And The user clicks on Withdraw button
#    Then The withdraw success message is displayed
#    And The user's balance after withdraw is updated correctly
#
#  Scenario: The user tries to withdraw more than the balance
#    And The user selects first customer in list
#    And The user clicks the Login button
#    And The user checks their current balance
#    When The user clicks on Withdraw tab
#    And The user enters the amount of money for withdraw "6000"
#    And The user clicks on Withdraw button
#    Then Withdraw error message is displayed