Feature: Etsy product search


  	
  Scenario: Etsy searh for an item
    And User in home page
    When User searches for "staff"
    Then Search result should be displayed
