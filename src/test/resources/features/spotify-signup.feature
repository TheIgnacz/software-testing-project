Feature: Vimeo sign up page

  Background:
    Given the home page is opened
      And the Join header button is clicked

  Scenario: Check required fields
    When the Join with email button is clicked
    Then the 'Please enter your name, email, and password' error message of the 'Enter your email.' field should be shown

  Scenario Outline: Check the fields with invalid parameters
    When the '<field>' is filled in with '<parameter>'
      And the Join with email button is clicked
    Then the '<errorMessage>' error message of the '<field>' field should be shown

    Examples:
      | field             | parameter | errorMessage                                |
      | Enter your name.  | asd       | Please enter your email and password        |
      | Enter your name.  | 567       | Please enter your email and password        |
      | Enter your email. | asd       | Please enter your name, email, and password |
      | Enter your email. | 123       | Please enter your name, email, and password |
      | Create password.  | aaa       | Please enter your name, email, and password |
      | Create password.  | 987       | Please enter your name, email, and password |

  Scenario: Fill name and email fields with valid parameters but with too short password
    When the 'Enter your name.' is filled in with 'Teszt Elek'
      And the 'Enter your email.' is filled in with 'teszt_elek@gmail.com'
      And the 'Create password.' is filled in with 'a'
      And the Join with email button is clicked
    Then the 'Password must be at least 8 characters long and must contain at least one number and at least one symbol' error message of the 'Create password.' field should be shown


  Scenario: Fill email fields with already registered email
    When the 'Enter your name.' is filled in with 'asd'
    And the 'Enter your email.' is filled in with 'tesztelek@gmail.com'
    And the 'Create password.' is filled in with 'asd'
    And the Join with email button is clicked
    Then the 'Hey, we recognize this email! ' error message of the 'Enter your email.' field should be shown


