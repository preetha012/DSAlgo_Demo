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
@sign
Feature: Sign In Page


  @sign1
  Scenario: Verifying Register link
    Given The user is on signin page
    When The user clicks on register link on signin page
    Then The user redirected to Registration page from signin page

 @sign2
  Scenario: User on login page and login with invalid inputs
    Given The user is on signin page
    When The user enter invalid Username and Password
      | Username | Password |
      | user1    |          |
      |	         | passowrd1|
      |   		   |          |
    Then click login button to verify credentials



 @sign3
  Scenario Outline: User on login page and login with invalid and valid inputs from Excel
    Given The user is on signin page
    When The user enter sheet "<Sheetname>" and <RowNumber>
    Then click login button to verify exceldata 
		Examples:
		  | Sheetname | RowNumber |
      | Sheet1    |         0 |
      | Sheet1    |         1 |
      | Sheet1    |         2 |
      | Sheet1    |         3 |
  
  @sign4
  Scenario: Verifying signout link
    Given The user is in the Home page with valid  log in
    When The user clicks Sign out
    Then The user is in signin page
