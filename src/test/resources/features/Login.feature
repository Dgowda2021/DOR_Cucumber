
@Login @regression
Feature: DoR Login page

  As a user, I want to log in to the DoR application
  so that I can access my account and perform necessary actions.

  Scenario: Successful login with valid credentials
    Given I am on the DoR login page
    When I enter valid "dgowda@aziro.com" and "Amazon@12345"
    And I click on the login button
    Then I should be redirected to the dashboard page

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the DoR login page
    When I enter invalid username or password
    And I click on the login button
    Then I should see an error message indicating invalid credentials
