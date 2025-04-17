Feature: Remove Item from Cart

  Scenario Outline: User removes a product from the cart
    Given the user has "<product>" in the cart
    When the user removes "<product>" from the cart
    Then the cart should not contain "<product>"

    Examples:
      | product      |
      | laptop       |
      | headphones   |
