@ui @elements
Feature: Drag and drops elements

  Scenario: User drags element A to place B and checks that they have swapped places
    Given I open the Drag and Drop page
    When I drag element A to element B
    Then I should see that elements A and B have swapped places
