@ui @checkbox
Feature: Checkbox

  Scenario: Select all checkboxes and check that they are choosen
    Given I open the Checkboxes page
    When I select all checkboxes
    Then I should see all checkboxes selected
