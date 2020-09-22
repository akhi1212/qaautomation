Feature: Retrieve a vehicle by vin and verify the exterior color features are being populated. The specific feature will use a VIN for engineeredData.


  Scenario Outline: Validate exterior colors returned by vds for a vin
    Given Actor wants to retrieve vin information for '<vin>'
    When user calls vds for vin
    Then user should see the '<genericDesc>' and '<description>' in service response for '<styleId>'
    Examples:
      | vin               | genericDesc | description             | styleId |
      | JTDKARFU9K3101964 | Silver      | Classic Silver Metallic | 404156  |
