Feature: Retrieve a vehicle by vin and verify the interior color features are being populated. The specific feature will use a VIN for buildData.

  Scenario Outline: Validate get interior color genericDesc & description for build Data return by vds
    Given Ankur wants to retrieve vin information for '<vin>'
    When he calls vds for vin
    Then he should see the '<genericDesc>' and '<description>' in service response for '<styleId>'
    Examples:
      |testCase|vin|genericDesc|description|styleId|
      |1       |1GC0KREG8KF231149|Gray|Dark Ash/Jet Black|404174|