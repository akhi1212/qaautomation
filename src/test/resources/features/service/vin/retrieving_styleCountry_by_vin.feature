Feature: Retrieve a vehicle by VIN and verify country value for the style is being populated in the service response.

  Scenario Outline: Validate style's country is returned by vds for a vin
    Given Actor wants to retrieve vin information for '<vin>'
    When Actor calls vds for vin
    Then user should see the country '<country>' in service response for '<styleId>'
    Examples:
      | vin                 | country |styleId|
      | 1FTFW1RG1KFC59255   | US      |403577 |
      | 3GCUKREC9HG270676   | US      |383681 |
      | 1FT7W2BT0HEB36644   | US      |385442 |
      | 1C4BJWCG8FL548661   | US      |372512 |
      | 1N6BF0LY1JN803961   | US      |394219 |
      | WBY1Z8C35HV893813   | US      |388263 |
      | 1C6RR6FG7KS555532   | US      |400872 |
