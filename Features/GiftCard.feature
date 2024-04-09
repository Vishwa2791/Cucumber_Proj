#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Validation of GiftCards Page

  Scenario Outline: Validation using Invalid details
    Given user navigated to MakeMyTrip page
    When user clicks on GiftCards button
    And user selects Occasions category
    And user clicks on StayCation Gift Card gift card
    Then validate page title
    #Given user navigated to StayCation GiftCard page
    When user fills in <amount>
    And user clicks Email
    And increases <quantity>
    And selects Send to different recipients slider button
    And fills in <invalidrecipient1> and <invalidrecipient2> details
    And fills in <invalidsendername> , <invalidsenderno> and <invalidsendermail>
    Then check whether the displayed details are same as input
    When user fills in <invalidcoupon>
    And user clicks the Buy Now button
    Then validate the error messages
    #And refresh the page

    Examples: 
      | amount | quantity | invalidrecipient1 | invalidrecipient2 | invalidsendername | invalidsenderno | invalidsendermail | invalidcoupon |
      |   3267 |        2 | "name1"           | "name2"           | "Vasco Da Gamer"  | "9876543210"    | "appleofeden"     | "FUHREEE"     |
      |  20000 |        2 | "987"             | "345"             | "PolkaMan"        | "3242"          | "123nji"          | "polkapolka"  |
      |   5520 |        2 | "guy1"            | "guy2"            | "Jack Sparrow"    | "9753186420"    | "iladamuerte"     | "KRAKEN"      |

  Scenario Outline: Validation using Valid details
    Given user navigated to MakeMyTrip page
    When user clicks on GiftCards button
    And user selects Occasions category
    And user clicks on StayCation Gift Card gift card
    Then validate page title
    When user fills in <amount>
    And user clicks Email
    And increases <quantity>
    And selects Send to different recipients slider button
    And fills in <validrecipient1> and <validrecipient2> details
    And fills in <validsendername> , <validsenderno> and <validsendermail>
    Then check whether the displayed details are same as input
    When user clicks the Buy Now button
    Then check if the Payment page is reached

    #And return to homepage
    Examples: 
      | amount | quantity | validrecipient1   | validrecipient2   | validsendername  | validsenderno | validsendermail         | validcoupon |
      |   2000 |        2 | "name1@gmail.com" | "name2@gmail.com" | "Vasco Da Gamer" | "9876543210"  | "appleofeden@gmail.com" |             |
