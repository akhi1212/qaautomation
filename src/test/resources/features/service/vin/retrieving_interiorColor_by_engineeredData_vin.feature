Feature: Retrieve a vehicle by vin and verify the interior color features are being populated. The specific feature will use a VIN for engineeredData.

  Scenario Outline: Validate get interior color genericDesc & description for engineered Data return by vds
    Given Ankur wants to retrieve vin information for '<vin>'
    When he calls vds for vin
    Then he should see the '<genericDesc>' and '<description>' in service response for '<styleId>'
    Examples:
      |testCase|vin|genericDesc|description|styleId|
      |1       |5TFUY5F18LX934832|Gray|Graphite|407475|