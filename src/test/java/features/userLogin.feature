Feature: User Login

  Scenario Outline: User logs in with credentials
    Given the user is on the Trendyol homepage
    When the user navigates to the login page
    And the user enters email "<email>" and password "<password>"
    And the user submits the login form
    Then the user should see "<expectedResult>"

    Examples:
      | email                | password    | expectedResult         |
      | valid@mail.com       | validpass   | My Account             |
      | invalid@mail.com     | wrongpass   | Invalid credentials    |
