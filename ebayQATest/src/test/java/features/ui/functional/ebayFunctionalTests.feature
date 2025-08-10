Feature: Ebay Cart Feature Testing

  @Test
  Scenario: User Verifies the items can be added to the cart
    #Given the user verifies to the shopping cart
    Given the user search the "book" item
    #And the user select the 0 indexed item
    And the user select the first item
    And the user switch to the new window
    And the verify the "0" items are added to the cart
    When the user add the item to the cart
    Then the verify the "1" items are added to the cart


  # read url from config file
    # separate driver items
   # exception handle
   # seperate elements
  # seperate waits
  # add logs
  # Reporting
  # listeners
  # Hooks
  # maintain global variables
  # add custom annotations

