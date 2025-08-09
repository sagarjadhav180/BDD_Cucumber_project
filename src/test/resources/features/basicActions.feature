Feature: Basic Actions

  Scenario: Radio Buttons
    When I open practise page
    Then Practise page should be displayed
    When I click on "radio1" Radio button
    Then "radio1" button should be checked


  Scenario: Scroll Function
    When I open practise page
    Then Practise page should be displayed
    When I scroll down to Mouse Hover
    Then Mouse Hover button should be displayed on screen


  Scenario: Javascript click
    When I open practise page
    Then Practise page should be displayed
    When I scroll down to Mouse Hover
    Then Mouse Hover button should be displayed on screen
    When I click on "Mouse Hover" button with javascriptexecutor

  @Smoke
  Scenario: Fluent Wait
    When I open practise page
    Then Login button should be displayed

