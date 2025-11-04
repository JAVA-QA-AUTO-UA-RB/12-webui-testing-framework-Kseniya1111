@ui @slider
Feature: Horizontal Slider

  Scenario: User moves slider to a non-zero position and checks updated value
    Given I open the Horizontal Slider page
    When I move the slider to a non-zero position
    Then I should see that the slider value is updated

