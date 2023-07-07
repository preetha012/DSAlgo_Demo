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
@Graph
Feature: Graph Page

   Scenario: The user is logged in to DS Algo portal
    Given The user is on Signin page of DS Algo portal
    When The user enters a valid username "NumpyNinja@112" and  password "Project@123"
    Then The user is on the home page of DS Algo portal

   @Graph2
  Scenario: The user is directed to Graph Page
    Given The user is in the Home page after logged in
    When The user select Graph item from the drop down menu
    Then The user should then be directed to "Graph" Page

 @Graph3
  Scenario: The user is able to navigate to Implementation of Graph in Python page
    Given The user is on the Graph page after logged in
    When The user clicks on the "Graph" link for Graph
    Then The user should then be directed to "Graph" Page
    
    @Graph4
  Scenario: The user is able to navigate to a page having an tryEditor
    Given The user is on the "Graph" after logged in for Graph
    When The user clicks Try Here button in Graph page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for Graph
    
   @Graph5
  Scenario Outline: The user is able to run code in tryEditor
    Given The user is in the Graph page having an tryEditor with a Run button to test
    When The user gets input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering valid python code in Graph tryEditor
    Then The user should be presented with Run output for Graph

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

@Graph6
  Scenario Outline: The user is able to get the error message for invalid syntax
    Given The user is in the Graph page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering invalid python code in Graph tryEditor
    Then The user should get the error message for Graph

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @Graph7
  Scenario: The user is able to navigate to "Graph Representations" Page
    Given The user is on the Graph page after logged in
    When The user clicks on the "Graph Representations" link for Graph
    Then The user should then be directed to "Graph Representations" Page

  @Graph8
  Scenario: The user is able to navigate to Implementation using array page having an tryeditor
    Given The user is on the "Graph Representations" after logged in for Graph
    When The user clicks Try Here button in Graph page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for Graph

  @Graph9
  Scenario Outline: The user is able to run code in tryEditor
    Given The user is in the Graph page having an tryEditor with a Run button to test
    When The user gets input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering valid python code in Graph tryEditor
    Then The user should be presented with Run output for Graph

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @Graph10
  Scenario Outline: The user is able to get the error message for invalid syntax
    Given The user is in the Graph page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering invalid python code in Graph tryEditor
    Then The user should get the error message for Graph

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |