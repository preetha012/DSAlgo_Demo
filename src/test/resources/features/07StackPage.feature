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
@Stack
Feature: Stack Page
    Scenario: The user is logged in to DS Algo portal
    Given The user is on Signin page of DS Algo portal
    When The user enters a valid username "NumpyNinja@112" and  password "Project@123"
    Then The user is on the home page of DS Algo portal

   @Stack2
  Scenario: The user is directed to Stack Page
    Given The user is in the Home page after logged in
    When The user select stack item from the drop down menu
    Then The user should then be directed to "Stack" Page

 @Stack3
  Scenario: The user is able to navigate to Operations in Stack page
    Given The user is on the Stack page after logged in
    When The user clicks on the Operations in Stack link
    Then The user should then be directed to "Operations in Stack" Page
    
    @Stack4
  Scenario: The user is able to navigate to a page having an tryEditor
    Given The user is on the "Operations in Stack" after logged in for stack
    When The user clicks Try Here button in stack page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for stack
    
   @Stack5
  Scenario Outline: The user is able to run code in tryEditor
    Given The user is in the Stack page having an tryEditor with a Run button to test
    When The user gets input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering valid python code in stack tryEditor
    Then The user should be presented with Run output for stack

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

@Stack6
  Scenario Outline: The user is able to get the error message for invalid syntax
    Given The user is in the Stack page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering invalid python code in stack tryEditor
    Then The user should get the error message for stack

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @Stack7
  Scenario: The user is able to navigate to "Implementation" Page
    Given The user is on the Stack page after logged in
    When The user clicks on the Implementation button
    Then The user should then be directed to "Implementation" Page

  @Stack8
  Scenario: The user is able to navigate to Implementation page having an tryeditor
    Given The user is on the "Implementation" after logged in for stack
    When The user clicks Try Here button in stack page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for stack

  @Stack9
  Scenario Outline: The user is able to run code in tryEditor
    Given The user is in the Stack page having an tryEditor with a Run button to test
    When The user gets input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering valid python code in stack tryEditor
    Then The user should be presented with Run output for stack

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         10 |

  @Stack10
  Scenario Outline: The user is able to get the error message for invalid syntax
    Given The user is in the Stack page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering invalid python code in stack tryEditor
    Then The user should get the error message for stack

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         11 |

  @Stack11
  Scenario: The user is able to navigate to "Applications" in stack Page
    Given The user is on the Stack page after logged in
    When The user clicks on the Applications button
    Then The user should then be directed to "Applications" Page

  @Stack12
  Scenario: The user is able to navigate to Applications page having an tryEditor
    Given The user is on the "Applications" after logged in for stack
    When The user clicks Try Here button in stack page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for stack

  @Stack13
  Scenario Outline: The user is able to run code in tryEditor
    Given The user is in the Stack page having an tryEditor with a Run button to test
    When The user gets input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering valid python code in stack tryEditor
    Then The user should be presented with Run output for stack

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @Stack14
  Scenario Outline: The user is able to get the error message for invalid syntax
    Given The user is in the Stack page having an tryEditor with a Run button to test
    When The user gets invalid input from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on Run button after Entering invalid python code in stack tryEditor
    Then The user should get the error message for stack

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

