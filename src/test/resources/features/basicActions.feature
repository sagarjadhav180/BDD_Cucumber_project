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

  @Smoke
  Scenario: Javascript click
    When I open practise page
    Then Practise page should be displayed
    When I scroll down to Mouse Hover
    Then Mouse Hover button should be displayed on screen
    When I click on "Mouse Hover" button with javascriptexecutor

