Feature: Add a new customer

  Background:
    Given The user accesses the main page
    When The user clicks on the 'Bank Manager Login' button
    And The user clicks on the 'Add Customer' button

  Scenario Outline: The user adds a new customer without filling First Name field
    And The user writes 'first name' "<fistname>"
    And The user writes 'last name' "<lastname>"
    And The user writes 'post code' "<postcode>"
    And The user clicks on submit add customer button
    Then The user gets the alert banner in field First Name "<alert>"
    Examples:
      | fistname | lastname | postcode | alert                       |
      |          | Craciun  | E23564   | Please fill out this field. |

  Scenario Outline: The user adds a new customer without filling Last Name field
    And The user writes 'first name' "<fistname>"
    And The user writes 'last name' "<lastname>"
    And The user writes 'post code' "<postcode>"
    And The user clicks on submit add customer button
    Then The user gets the alert banner in field Last Name "<alert>"
    Examples:
      | fistname | lastname | postcode | alert                       |
      | Cosmin   |          | E23564   | Please fill out this field. |

#  Scenario Outline: The user adds a new customer without filling Post Code field
#    And The user writes 'first name' "<fistname>"
#    And The user writes 'last name' "<lastname>"
#    And The user writes 'post code' "<postcode>"
#    And The user clicks on submit add customer button
#    Then The user gets the alert banner in field Post Code "<alert>"
#    Examples:
#      | fistname | lastname | postcode | alert                       |
#      | Cosmin   | Craciun  |          | Please fill out this field. |
#
#  Scenario Outline: The user enters invalid name made by numbers
#    And The user writes 'first name' "<fistname>"
#    And The user writes 'last name' "<lastname>"
#    And The user writes 'post code' "<postcode>"
#    And The user clicks on submit add customer button
#    Then The user gets a pop-up error message "<alert>"
#    Examples:
#      | fistname | lastname | postcode | alert                                        |
#      | 123      | 456      | E4567    | Customer added successfully with customer id |