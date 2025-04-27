Feature: Product Search

  Scenario Outline: User searches for a product
    Given the user is on the Trendyol homepage for search
    When the user searches for "<searchTerm>"
    Then search results for "<searchTerm>" are displayed

    Examples:
      | searchTerm   |
      | laptop       |
      #| headphones   |
      #| shoes        |
     # | smartphone   |


