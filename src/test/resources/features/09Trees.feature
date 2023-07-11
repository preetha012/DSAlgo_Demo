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
@Tree
Feature: Title of your feature

   Scenario: The user is logged in to DS Algo portal
    Given The user is on Signin page of DS Algo portal
    When The user enters a valid username "NumpyNinja@112" and  password "Project@123"
    Then The user is on the home page of DS Algo portal

   @Tree2
  Scenario: The user is directed to Tree Page
    Given The user is in the Home page after logged in
    When The user select Tree item from the drop down menu
    Then The user should then be directed to "Tree" Page

 @Tree3
  Scenario: The user is able to navigate to Implementation of Tree in Python page
    Given The user is on the Tree page after logged in
    When The user clicks on the "Overview of Trees" link for Tree
    Then The user should then be directed to "Overview of Trees" Page
    
    @Tree4
  Scenario: The user is able to navigate to a page having an tryEditor
    Given The user is on the "Overview of Trees" after logged in for Tree
    When The user clicks Try Here button in Tree page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for Tree
    
   @Tree5
  Scenario Outline: The user is able to run code in tryEditor
    Given The user is in the Tree page having an tryEditor with a Run button to test
    When The user gets input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering valid python code in Tree tryEditor
    Then The user should be presented with Run output for Tree

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         10 |

@Tree6
  Scenario Outline: The user is able to get the error message for invalid syntax
    Given The user is in the Tree page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering invalid python code in Tree tryEditor
    Then The user should get the error message for Tree

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         11 |

  @Tree7
  Scenario: The user is able to navigate to "Terminologies" Page
    Given The user is on the Tree page after logged in
    When The user clicks on the "Terminologies" link for Tree
    Then The user should then be directed to "Terminologies" Page

  @Tree8
  Scenario: The user is able to navigate to Implementation using array page having an tryeditor
    Given The user is on the "Terminologies" after logged in for Tree
    When The user clicks Try Here button in Tree page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for Tree

  @Tree9
  Scenario Outline: The user is able to run code in tryEditor
    Given The user is in the Tree page having an tryEditor with a Run button to test
    When The user gets input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering valid python code in Tree tryEditor
    Then The user should be presented with Run output for Tree

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @Tree10
  Scenario Outline: The user is able to get the error message for invalid syntax
    Given The user is in the Tree page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering invalid python code in Tree tryEditor
    Then The user should get the error message for Tree

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @Tree11
  Scenario: The user is able to navigate to "Types of Trees" in Tree Page
    Given The user is on the Tree page after logged in
    When The user clicks on the "Types of Trees" link for Tree
    Then The user should then be directed to "Types of Trees" Page

  @Tree12
  Scenario: The user is able to navigate to Tree Operations page having an tryEditor
    Given The user is on the "Types of Trees" after logged in for Tree
    When The user clicks Try Here button in Tree page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for Tree

  @Tree13
  Scenario Outline: The user is able to run code in tryEditor
    Given The user is in the Tree page having an tryEditor with a Run button to test
    When The user gets input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering valid python code in Tree tryEditor
    Then The user should be presented with Run output for Tree

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         10 |

  @Tree14
  Scenario Outline: The user is able to get the error message for invalid syntax
    Given The user is in the Tree page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering invalid python code in Tree tryEditor
    Then The user should get the error message for Tree

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         11 |

