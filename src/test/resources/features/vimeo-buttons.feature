Feature: Vimeo buttons check

  Background:
    Given the home page is opened

  Scenario: Check Watch button
    When the Watch button is clicked
    Then the 'https://vimeo.com/watch' page is opened

  Scenario: Check Pricing button
    When the Pricing button is clicked
    Then the 'https://vimeo.com/upgrade' page is opened