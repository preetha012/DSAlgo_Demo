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
@Array
Feature: Array Page

	
  Scenario: The user is logged in to DS Algo portal
    Given The user is on Signin page of DS Algo portal
    When The user enters a valid username "NumpyNinja@112" and  password "Project@123"
    Then The user is on the home page of DS Algo portal

  @Array2 
  Scenario: The user is able to navigate to Array page
    Given The user is on the home page after logged in
    When The user clicks the Getting Started button in Array Page
    Then The user is on the Array Page

  @Array3 
  Scenario: The user is able to navigate to Arrays in Python page
    Given The user is on the Array page after logged in
    When The user clicks Arrays in Python button
    Then The user should be redirected to "Arrays in Python" page

  @Array4 
  Scenario: The user is able to navigate to a page having an tryEditor from Arrays in Python page
    Given The user is on the "Arrays in Python" after logged in
    When The user clicks Try Here button
    Then The user should be redirected to a page having an tryEditor with a Run button to test

  @Array5
  Scenario Outline: The user is able run code in tryEditor for Arrays in Python page
    Given The user is in a page having an tryEditor with a Run button to test
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber> for array
    And The user clicks on run button for array
    Then The user should be presented with Run result for array

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @Array6
  Scenario Outline: The user is presented with error message for code with invalid syntax in tryEditor for Arrays in Python page
    Given The user is in a page having an tryEditor with a Run button to test
    When The user enter python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber> for array
    And The user clicks on run button for array
    Then The user should be presented with error message for array

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @Array7
  Scenario: The user is able to navigate to Arrays Using List page
    Given The user is on the Array page after logged in
    When The user clicks Arrays Using List link
    Then The user should be redirected to "Arrays Using List" page

  @Array8
  Scenario: The user is able to navigate to a page having an tryEditor from Arrays Using List page
    Given The user is on the "Arrays Using List" after logged in
    When The user clicks Try Here button
    Then The user is in tryEditor page

  @Array9
  Scenario Outline: The user is able run code in tryEditor for Arrays Using List page
    Given The user is in a page having an tryEditor with a Run button to test
    When The user enter valid python code in tryEditor with valid credential from sheet "<Sheetname>" and <RowNumber>
    And The user clicks on run button for array
    Then The user should be presented with Run result for array

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @Array10
  Scenario Outline: The user is presented with error message for code with invalid syntax in tryEditor for Arrays Using List page
    Given The user is in a page having an tryEditor with a Run button to test
    When The user enter python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber> for array
    And The user clicks on run button for array
    Then The user should be presented with error message for array

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @Array11
  Scenario: The user is able to navigate to Basic Operations in Lists page
    Given The user is on the Array page after logged in
    When The user clicks Basic Operations in Lists link
    Then The user should be redirected to "Basic Operations in Lists" page

  @Array12
  Scenario: The user is able to navigate to a page having an tryEditor from Basic Operations in Lists page
    Given The user is on the "Basic Operations in Lists" after logged in
    When The user clicks Try Here button
    Then The user should be redirected to a page having an tryEditor with a Run button to test

  @Array13
  Scenario Outline: The user is able run code in tryEditor for Basic Operations in Lists page
    Given The user is in a page having an tryEditor with a Run button to test
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber> for array
    And The user clicks on run button for array
    Then The user should be presented with Run result for array

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @Array14
  Scenario Outline: The user is presented with error message for code with invalid syntax in tryEditor for Basic Operations in Lists page
    Given The user is in a page having an tryEditor with a Run button to test
    When The user enter python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber> for array
    And The user clicks on run button for array
    Then The user should be presented with error message for array

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @Array15
  Scenario: The user is able to navigate to Applications of Array page
    Given The user is on the Array page after logged in
    When The user clicks Applications of Array link
    Then The user should be redirected to "Applications of Array" page

  @Array16
  Scenario: The user is able to navigate to a page having an tryEditor from Applications of Array page
    Given The user is on the "Applications of Array" after logged in
    When The user clicks Try Here button
    Then The user should be redirected to a page having an tryEditor with a Run button to test

  @Array17
  Scenario Outline: The user is able run code in tryEditor for Applications of Array page
    Given The user is in a page having an tryEditor with a Run button to test
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber> for array
    And The user clicks on run button for array
    Then The user should be presented with Run result for array

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         0 |

  @Array18
  Scenario Outline: The user is presented with error message for code with invalid syntax in tryEditor for Applications of Array page
    Given The user is in a page having an tryEditor with a Run button to test
    When The user enter python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber> for array
    And The user clicks on run button for array
    Then The user should be presented with error message for array

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @Array19
  Scenario: The user is able to navigate to Practice page
    Given The user is on the Arrays in Python after logged in
    #Given The user is able to navigate back which has Practice page link
    When The user clicks Practice Questions link
    Then The user should be redirected to "Practice Questions" page

  @Array20
  Scenario: The user is able to navigate to Question page from Search the array link
    Given The user is on the "Practice Questions" after logged in
    When The user clicks the Search the array link
    Then The user should be redirected to question page contains an tryEditor with Run and Submit buttons

    @Array21
  Scenario Outline: The user is able to run code in tryEditor for Search the array link
    Given The user is on Question page of Search the array after logged in
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber> for the question
    And The user clicks on run button for array
    Then The user should be presented with Run result for array

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         2 |

  @Array22
  Scenario Outline: The user is able to submit code in tryEditor for Search the array link
    Given The user is on Question page of Search the array after logged in
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber> for the question
    And The user clicks on Submit button
    Then The user should be presented with successful submission message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         3 |

  @Array23
  Scenario Outline: The user is presented with error message for code with invalid syntax in tryEditor for Search the array link
    Given The user is on Question page of Search the array after logged in
    When The user enter python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber> for the question
    And The user clicks on run button for array
    Then The user should be presented with error message for array

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @Array24
  Scenario: The user is able to navigate to Question page from Max Consecutive Ones
    Given The user is on the Practice Question page after logged in
    When The user clicks the Max Consecutive Ones link
    Then The user should be redirected to question page contains an tryEditor with Run and Submit buttons

  @Array25
  Scenario Outline: The user is able to run code in tryEditor for Max Consecutive Ones
    Given The user is on Question page of Max Consecutive Ones after logged in
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber> for the question
    And The user clicks on run button for array
    Then The user should be presented with Run result for array

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         4 |

  @Array26
  Scenario Outline: The user is able to submit code in tryEditor for Max Consecutive Ones
    Given The user is on Question page of Max Consecutive Ones after logged in
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber> for the question
    And The user clicks on Submit button
    Then The user should be presented with successful submission message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         5 |

  @Array27
  Scenario Outline: The user is presented with error message for invalid code in tryEditor for Max Consecutive Ones
    Given The user is on Question page of Max Consecutive Ones after logged in
    When The user enter python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber> for the question
    And The user clicks on run button for array
    Then The user should be presented with error message for array

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @Array28
  Scenario: The user is able to navigate to Question page from Find Numbers with Even Number of Digits
    Given The user is on the Practice Question page after logged in
    When The user clicks the Find Numbers with Even Number of Digits link
    Then The user should be redirected to question page contains an tryEditor with Run and Submit buttons

  @Array29
  Scenario Outline: The user is able to run code in tryEditor for Find Numbers with Even Number of Digits
    Given The user is on Question page of Find Numbers with Even Number of Digits after logged in
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber> for the question
    And The user clicks on run button for array
    Then The user should be presented with Run result for array

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         4 |

  @Array30
  Scenario Outline: The user is able to submit code in tryEditor for Find Numbers with Even Number of Digits
    Given The user is on Question page of Find Numbers with Even Number of Digits after logged in
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber> for the question
    And The user clicks on Submit button
    Then The user should be presented with successful submission message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         7 |

  @Array31
  Scenario Outline: The user is presented with error message for code with invalid syntax in tryEditor for Find Numbers with Even Number of Digits
    Given The user is on Question page of Find Numbers with Even Number of Digits after logged in
    When The user enter python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber> for the question
    And The user clicks on run button for array
    Then The user should be presented with error message for array

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         1 |

  @Array32
  Scenario: The user is able to navigate to Question page from Squares of a Sorted Array
    Given The user is on the Practice Question page after logged in
    When The user clicks the Squares of a Sorted Array link
    Then The user should be redirected to question page contains an tryEditor with Run and Submit buttons

  @Array33
  Scenario Outline: The user is able to run code in tryEditor for Squares of a Sorted Array
    Given The user is on Question page of Squares of a Sorted Array after logged in
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber> for the question
    And The user clicks on run button for array
    Then The user should be presented with Run result for array

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         8 |

  @Array34
  Scenario Outline: The user is able to submit code in tryEditor for Squares of a Sorted Array
    Given The user is on Question page of Squares of a Sorted Array after logged in
    When The user enter valid python code in tryEditor from sheet "<Sheetname>" and <RowNumber> for the question
    And The user clicks on Submit button
    Then The user should be presented with successful submission message

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |         9 |

  @Array35
  Scenario Outline: The user is presented with error message for code with invalid syntax in tryEditor for Squares of a Sorted Array
    Given The user is on Question page of Squares of a Sorted Array after logged in
    When The user enter python code with invalid syntax in tryEditor from sheet "<Sheetname>" and <RowNumber> for the question
    And The user clicks on run button for array
    Then The user should be presented with error message for array

    Examples: 
      | Sheetname  | RowNumber |
      | pythonCode |      1    |
    
    
    
    
    
    
    
    
    
    
    
    