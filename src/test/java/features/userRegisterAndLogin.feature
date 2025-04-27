Feature: User Registration and Login
  Scenario: User registers and then logs in successfully
    Given the user is on the Trendyol homepage
    When the user navigates to the registration page
    And the user registers with a unique email and password
    Then the registration should be successful
    When the user logs out
    And the user navigates to the login page
    And the user logs in with the registered email and password
    Then the user should be logged in successfully



