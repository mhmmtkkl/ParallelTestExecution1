Feature: Etsy product search

  Scenario: Etsy searh for an item
    Given User in home page
    When User searches for "phone"
    Then Search result should be displayed
