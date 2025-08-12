Feature: Verify the details of BitCoin

  Scenario: Verify currency details for bitCoin
    Given the initiates the request
    When the user makes the get call
    Then the get call is success
    And the verify the marketCap and total volume
    And the user verifies the price change percentage in 24hr
    And the user verifies Home page link is not empty


