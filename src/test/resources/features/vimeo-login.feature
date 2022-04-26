Feature: Vimeo login page

  Background:
    Given the home page is opened
      And the Log in header button is clicked

  Scenario: Log in with valid parameters
    When the 'Enter your email.' is filled in with 'godayib932@idurse.com'
      And the 'Enter your password.' is filled in with 'KalaPal_11'
      And the Log in with email button is clicked
    Then home page should be displayed
