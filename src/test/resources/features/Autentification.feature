@ui @auth
Feature: Authentication
  Scenario: User can login and logout
    Given I open the login page
    When I login with username "tomsmith" and password "SuperSecretPassword!"
    Then I should see login message "You logged into a secure area!"
    When I logout
    Then I should see logout message "You logged out of the secure area!"