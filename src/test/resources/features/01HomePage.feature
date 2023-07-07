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
@Home
Feature: DS Algo Home Page

  Scenario: User launch home page of an dsalgo project
    Given The user opens DS Algo portal link
    When The user clicks the Get Started button
    Then The user should be redirected to homepage

  Scenario Outline: User is on Home page and clicks  dropdown on  home page without sign in
    Given The user is on Home page
    When The user clicks on dropdown "<option>" without login
    Then The user get warning message "You are not logged in"

    Examples: 
      | option     |
      | Arrays     |
      | Linkedlist |
      | Stack      |
      | Queue      |
      | Tree       |
      | Graph      |

  Scenario Outline: User is on Home page and click getstarted link on  home page without sign in
    Given The user is on Home page
    When The user clicks on Get Started link on homepage "<option>" without login
    Then The user get warning message "You are not logged in"

    Examples: 
      | option         |
      | Datastructures |
      | Arrays         |
      | Linkedlist     |
      | Stack          |
      | Queue          |
      | Tree           |
      | Graph          |

  Scenario: User is on Home page and click on sign in
    Given The user is on Home page
    When The user clicks the Sign in button
    Then The user should be redirected to Sign in page

  Scenario: User is on Home page and click on Register
    Given The user is on Home page
    When The user clicks the Register button
    Then The user should be redirected to Register form
