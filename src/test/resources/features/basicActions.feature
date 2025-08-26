Feature: Basic Actions

  Background:
    Given I open practise page

  @radioButtons
  Scenario: Radio Buttons
#    Given I open practise page
    Then Practise page should be displayed
    When I click on "radio1" Radio button
    Then "radio1" button should be checked

  @ScrollFunction
  Scenario: Scroll Function
    Given I open practise page
    Then Practise page should be displayed
    When I scroll down to Mouse Hover
    Then Mouse Hover button should be displayed on screen


  Scenario: Javascript click
    Given I open practise page
    Then Practise page should be displayed
    When I scroll down to Mouse Hover
    Then Mouse Hover button should be displayed on screen
    When I click on "Mouse Hover" button with javascriptexecutor


  Scenario: Fluent Wait
    Given I open practise page
    Then Login button should be displayed


  Scenario: Autosuggestion handling
    Given I open practise page
    When I Enter "India" in suggestion class example box
    Then "India" should be displayed in the list
    When I click on "India" option
#    Then Country "India" should be selected in listbox


  Scenario: Dropdown handling
    Given I open practise page
    When I select "Option1" from dropdown
    Then Selected option "Option1" should be displayed


  Scenario: Checkbox handling
    Given I open practise page
    When I select checkbox "Option1"
    Then Selected checkbox option "Option1" should be checked

  Scenario: Window Handling
    Given I open practise page
    When I click on Open Window button
    Then New window should be opened with title "QAClick Academy"
    When I switch back to Parent window

  Scenario: Switch Tab handling
    Given I open practise page
    When I click on Open Tab
    Then Verify if new tab is opened


  Scenario: Alert handling
    Given I open practise page
    When I enter alert name "Sagar"
    And Click on Alert button
    Then alert pop should be displayed with message "Hello Sagar, share this practice page and share your knowledge"

  @webTableHandling
  Scenario Outline: Web Table handling
    When I scroll down to the course "<course>"
    Then I should be able to see the "<course>" of the "<price>"
    Examples:
      | course                                     | price |
      | WebServices / REST API Testing with SoapUI | 35    |


  @dynamicHeaderWebTableHandling
  Scenario Outline: Dynamic header web table handling
    When I scroll down to the "<footballer>"
    Then I should be able to see the "<footballer>" "<amount>"
    Examples:
      | footballer | amount |
      | Ronaldo    | 31     |


  @iframeHandling
  Scenario: iframeHandling
    When I switch to iframe
    When I scroll down to "mentorship" tile in courses section
    And I Click on mentorship tile
    Then I should be able to see mentorship title



