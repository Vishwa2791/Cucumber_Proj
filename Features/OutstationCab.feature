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
Feature: Book an outstation cab

  Scenario Outline: Capturing Lowest charge of SUV cab
    Given user on the homepage
    And user on the Cabs tab
    When user fill in <From> and <To> location
    And user fill in <Departure> and <Pickup-Time> details
    And user clicks Search button
    And user selects <Filter> option
    Then capture the top result

    Examples: 
      | From        | To                                | Departure | Pickup-Time | Filter  |
      | "Delhi"     | "Manali, Himachal Pradesh, India" |        23 | 06:30:"PM"  | "SUV"   |
      | "Hyderabad" | "Hosur, Tamil Nadu, India"        |        15 | 07:40:"AM"  | "SEDAN" |
