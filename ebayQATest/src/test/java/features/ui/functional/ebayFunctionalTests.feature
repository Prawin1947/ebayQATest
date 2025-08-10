Feature: Ebay Cart Feature Testing

  #Due to technical glich TestNg was not supporting hence Couldn't able to Add Assertion
  Scenario: User Verifies the items can be added to the cart
    Given the user search the "book" item
    And the user select the first item
    And the user switch to the new window
    And the verify the "0" items are added to the cart
    When the user add the item to the cart
    Then the verify the "1" items are added to the cart



  Scenario: User Verifies the items can be added to the cart DUMMY TEST
    Given the user verifies to the shopping cart
