#Feature: User Registration
#
#  Scenario Outline: User registers with new credentials
#    Given the user is on the Trendyol homepage
#    When the user navigates to the registration page
#    And the user enters name "<name>", email "<email>", and password "<password>"
#    And the user submits the registration form
#    Then the user should see "<expectedResult>"
#
#    Examples:
#      | name    | email              | password   | expectedResult         |
#      | Test1   | test1@mail.com     | pass1234   | Registration Success   |
#      | Test2   | test2@mail.com     | pass5678   | Registration Success   |
