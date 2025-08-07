Feature: Google


  Scenario: Launch browser and open google
    Given I open Google page
    When I search for "Selenium"
    Then I Select "selenium download" option from the displayed options