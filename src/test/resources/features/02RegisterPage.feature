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

@reg 
Feature: Registration Page

 
 @reg1
  Scenario: The user is presented with error message for empty fields below Username textbox

    Given The user opens Register Page
    When The user clicks Register button with all fields empty
    Then It should display an error Please fill out this field. below Username textbox
@reg2 
	Scenario Outline: The user is presented with error message for empty fields below Password textbox

    Given The user opens Register Page
    When The user clicks Register button after entering "<username>" with other fields empty
    Then It should display an error Please fill out this field. below Password textbox

    Examples: 
      | username     |
      | Numpy@sdet84_1 |

@reg3 
   Scenario Outline: The  user is presented with error message for empty fields below Password Confirmation textbox
    Given The user opens Register Page
    When The user clicks Register button after entering "<username>" and "<password>" with Password Confirmation field empty
    Then It should display an error Please fill out this field. below Password Confirmation textbox
 
    Examples: 
      |username     | password     |
      | Numpy@sdet84_1 | testpassword |
      |Numpy@sdet84_2|testpassword1|
      
@reg4
   Scenario: The user is presented with error message for invalid username
    Given The user opens Register Page
    When  The user enters a username with characters other than Letters, digits and symbols 
       | username | password     | password confirmation |
      | &**&**&  | testpassword | testpassword          |
    Then It should display an error message Please enter a valid username 

      
@reg5
   Scenario Outline: The user is presented with error message for username already exists
    Given The user opens Register Page
    When  The user enters a valid existing "<username>" with "<password>" and "<password confirmation>"
    Then It should display an error message Username already exists
Examples:
      | username     | password  | password confirmation |
      | Numpy@sdet84_1 | RT56YUabc | RT56YUabc  |

@reg6
   Scenario Outline: The user is presented with error message for password mismatch
    Given The user opens Register Page
    When  The user clicks Register button after entering valid "<username>" and different passwords in "<password>" and "<password confirmation>" fields
    Then It should display an error message password_mismatch:The two password fields didn’t match.
Examples:
      | username     | password     | password confirmation |
      | Numpy@sdet84_1 | testpassword | testpassword1   | 

 @reg7     
   Scenario Outline: The user is presented with error message for password with characters less than 8
    Given The user opens Register Page
    When   The user enters a valid "<username>" and "<password>" and "<password confirmation>" with characters less than 8
    Then It should display an error message Password should contain at least 8 characters

    Examples: 
         | username     | password     | password confirmation |
      | Numpy@sdet84_1 | test1 | test1   | 

@reg8
   Scenario Outline: The user is presented with error message for password with only numbers
    Given The user opens Register Page
    When   The user enters a valid "<username>" and "<password>" and "<password confirmation>" with only numbers
    Then It should display an error message Password can’t be entirely numeric.

    Examples: 
         | username     | password | password confirmation |
      | Numpy@sdet84_1 | 12345678 |              12345678 |

 @reg9   
   Scenario Outline: The user is presented with error message for password too similar to your other personal information
    Given The user opens Register Page
    When  The user enters a valid "<username>" and "<password>" and "<password confirmation>" similar to username
    Then 	It should display an error message password can’t be too similar to your other personal information.

    Examples: 
         | username     | password   | password confirmation |
      | Numpy@sdet84 | testsdet84 | testsdet84          |
@reg10
   Scenario Outline: The user is presented with error message for commonly used password
    Given The user opens Register Page
    When  The user enters a valid "<username>" and commonly used password "<password>" and "<password confirmation>"
    Then It should display an error message Password can’t be commonly used password

    Examples: 
          | username     | password | password confirmation |
      		| Numpy@sdet84_1 | Welcome1 | Welcome1          |
@reg11 
  Scenario Outline: The user is succesfully able to register 
    Given The user opens Register Page
    When  The user enters a valid "<username>" and "<password>" and "<password confirmation>"
    Then The user should be redirected to Homepage with the message New Account Created. You are logged in as "<username>"

    Examples: 
      | username     | password  | password confirmation |
      | NumpyNinja@915 | Project@123 | Project@123       |
      
@reg12 
   Scenario Outline: The user is able to signin with registered credential
    Given The user opens Signin Page
    When  The user enters a valid "<username>" and "<password>"
    Then click login button to verify

    Examples: 
          | username   | password  |
      | NumpyNinja@112 |Project@123|