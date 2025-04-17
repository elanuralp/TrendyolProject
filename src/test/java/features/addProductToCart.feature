#Feature: Add Product to Cart
#
#  Scenario Outline: User adds a product to the cart
#    Given the user is on the Trendyol homepage
#    When the user searches for "<product>"
#    And the user selects the first product from the results
#    And the user adds the product to the cart
#    Then the product "<product>" should be visible in the cart
#
#    Examples:
#      | product      |
#      | laptop       |
#      | headphones   |
#      | shoes        |
