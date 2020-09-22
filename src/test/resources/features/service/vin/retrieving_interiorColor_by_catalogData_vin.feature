Feature: Feature: Retrieve a vehicle by vin and verify the interior color features are being populated. The specific feature will use a VIN for Catalog Data.
 
  Scenario Outline: Validate get interior color genericDesc & description for Catalog Data return by vds
    Given Ankur wants to retrieve vin information for '<vin>'
    When he calls vds for vin
    Then he should see the '<genericDesc>' and '<description>' in service response for '<styleId>'
    Examples:
      | vin               | genericDesc        | description               | styleId  |                    
      | 1GC0KREG8KF231149 | Gray               | Dark Ash/Jet Black        | 404174   |
      | 1GC0KREG8KF231149 | Black              | Jet Black                 | 404174   |