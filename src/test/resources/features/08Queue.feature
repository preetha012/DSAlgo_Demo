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
@Queue
Feature: Title of your feature

   Scenario: The user is logged in to DS Algo portal
    Given The user is on Signin page of DS Algo portal
    When The user enters a valid username "NumpyNinja@112" and  password "Project@123"
    Then The user is on the home page of DS Algo portal

   @Queue2
  Scenario: The user is directed to Queue Page
    Given The user is in the Home page after logged in
    When The user select Queue item from the drop down menu
    Then The user should then be directed to "Queue" Page

 @Queue3
  Scenario: The user is able to navigate to Implementation of Queue in Python page
    Given The user is on the Queue page after logged in
    When The user clicks on the "Implementation of Queue in Python" link for Queue
    Then The user should then be directed to "Implementation of Queue in Python" Page
    
    @Queue4
  Scenario: The user is able to navigate to a page having an tryEditor
    Given The user is on the "Implementation of Queue in Python" after logged in for Queue
    When The user clicks Try Here button in Queue page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for Queue
    
   @Queue5
  Scenario Outline: The user is able to run code in tryEditor
    Given The user is in the Queue page having an tryEditor with a Run button to test
    When The user gets input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering valid python code in Queue tryEditor
    Then The user should be presented with Run output for Queue

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

@Queue6
  Scenario Outline: The user is able to get the error message for invalid syntax
    Given The user is in the Queue page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering invalid python code in Queue tryEditor
    Then The user should get the error message for Queue

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @Queue7
  Scenario: The user is able to navigate to "Implementation using array" Page
    Given The user is on the Queue page after logged in
    When The user clicks on the "Implementation using array" link for Queue
    Then The user should then be directed to "Implementation using array" Page

  @Queue8
  Scenario: The user is able to navigate to Implementation using array page having an tryeditor
    Given The user is on the "Implementation using array" after logged in for Queue
    When The user clicks Try Here button in Queue page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for Queue

  @Queue9
  Scenario Outline: The user is able to run code in tryEditor
    Given The user is in the Queue page having an tryEditor with a Run button to test
    When The user gets input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering valid python code in Queue tryEditor
    Then The user should be presented with Run output for Queue

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @Queue10
  Scenario Outline: The user is able to get the error message for invalid syntax
    Given The user is in the Queue page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering invalid python code in Queue tryEditor
    Then The user should get the error message for Queue

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @Queue11
  Scenario: The user is able to navigate to "Queue Operations" in Queue Page
    Given The user is on the Queue page after logged in
    When The user clicks on the "Queue Operations" link for Queue
    Then The user should then be directed to "Queue Operations" Page

  @Queue12
  Scenario: The user is able to navigate to Queue Operations page having an tryEditor
    Given The user is on the "Queue Operations" after logged in for Queue
    When The user clicks Try Here button in Queue page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for Queue

  @Queue13
  Scenario Outline: The user is able to run code in tryEditor
    Given The user is in the Queue page having an tryEditor with a Run button to test
    When The user gets input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering valid python code in Queue tryEditor
    Then The user should be presented with Run output for Queue

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @Queue14
  Scenario Outline: The user is able to get the error message for invalid syntax
    Given The user is in the Queue page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering invalid python code in Queue tryEditor
    Then The user should get the error message for Queue

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

