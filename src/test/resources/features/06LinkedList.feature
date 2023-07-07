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
@Link
Feature: Linked List

  Scenario: The user is logged in to DS Algo portal
    Given The user is on Signin page of DS Algo portal
    When The user enters a valid username "NumpyNinja@112" and  password "Project@123"
    Then The user is on the home page of DS Algo portal

  @Link1
  Scenario: User navigated to "linked list" page
    Given The user is in the Home page after logged in
    When The user selecting linkedlist item from the drop down menu
    Then The user should be directed to "Linked List" Page

  @Link2
  Scenario: User navigated to "Introduction" page
    Given The user is in the Linked List  page after logged in
    When The user clicks the "Introduction" button
    Then The user should be directed to "Introduction" of Linked List Page

  @Link3
  Scenario: User navigated to tryEditor page with Run button from Introduction page
    Given The user is on the "Introduction" after logged in for LinkedList
    When The user clicks Try Here button in the "introduction" page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for LinkedList

  @Link4
  Scenario Outline: The user run the code in tryEditor with valid input for Introduction page
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user should be presented with the Run output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @Link5
  Scenario Outline: The user getting error message with invalid python code for Introduction page
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user should be presented with the invalid Run output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @Link6
  Scenario: User navigated to "Creating Linked LIst" page
    Given The user is in the Linked List  page after logged in
    When The user clicks the "Creating Linked LIst" button
    Then The user should be directed to "Creating Linked LIst" Page

  @Link7
  Scenario: User navigated to tryEditor page with Run button from Creating a Linked List page
    Given The user is on the "Creating Linked LIst" after logged in for LinkedList
    When The user clicks Try Here button in the "Creating Linked LIst" page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for LinkedList

  @Link8
  Scenario Outline: The user run the code in tryEditor with valid input for Creating a Linked List page
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user should be presented with the Run output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @Link9
  Scenario Outline: The user getting error message with invalid python code for Creating a Linked List page
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user should be presented with the invalid Run output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @Link10
  Scenario: User navigated to "Types of Linked List" page
    Given The user is in the Linked List  page after logged in
    When The user clicks the "Types of Linked List" button
    Then The user should be directed to "Types of Linked List" Page

  @Link11
  Scenario: User navigated to tryEditor page with Run button from Types of Linked List
    Given The user is on the "Types of Linked List" after logged in for LinkedList
    When The user clicks Try Here button in the "Types of Linked List" page
    Then The user should be redirected to a page having an tryEditor with a Run button to test for LinkedList

  @Link12
  Scenario Outline: The user run the code in tryEditor with valid input for Types of Linked List
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user should be presented with the Run output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @Link13
  Scenario Outline: The user getting error message with invalid python code for Types of Linked List
    Given The user is in a try here page having  tryEditor with a Run button to test
    When The user Enter invalid python code in tryEditor from sheet "<Sheetname>" and <RowNumber>
    And user click on Run button
    Then The user should be presented with the invalid Run output

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |
