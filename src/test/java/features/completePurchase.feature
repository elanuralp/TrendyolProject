#Feature: Complete Purchase
#
#  Scenario Outline: User completes a purchase
#    Given the user is logged in with email "<email>" and password "<password>"
#    And the user has "<product>" in the cart
#    When the user proceeds to checkout
#    And the user completes the payment
#    Then the user should see "Order Confirmation"
#
#    Examples:
#      | email            | password   | product    |
#      | valid@mail.com   | validpass  | laptop     |
#      | valid@mail.com   | validpass  | shoes      |
