Feature: User Logout

  Scenario: User logs out
    Given the user is logged in
    When the user clicks the logout button
    Then the user should be logged out
