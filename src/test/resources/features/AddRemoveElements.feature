@ui @add @remove
Feature: Add and remove elements

  Scenario: User adds and removes 3 "Delete" buttons
    Given I open the AddRemove Elements page
    When I add 3 "Delete" buttons
    Then I should see 3 "Delete" buttons displayed
    When I remove all "Delete" buttons
    Then I should see no "Delete" buttons on the page
