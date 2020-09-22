Feature: Retrieve a vehicle by vin and verify the exterior color features are being populated. The specific feature will use a VIN for catalogData.

  Scenario Outline: Validate exterior colors returned by vds for a vin
    Given Actor wants to retrieve vin information for '<vin>'
    When user calls vds for vin
    Then user should see the '<genericDesc>' and '<description>' in service response for '<styleId>'
    Examples:
      | vin               | genericDesc        | description               | styleId  |
      | 1G1PC5SB1E7428104 | Red, Green, Silver, Black, White, Red, Beige, Blue, Gray, Blue | Red Hot, Rainforest Green Metallic, Silver Ice Metallic, Black Granite Metallic, Summit White, Crystal Red Tintcoat, Champagne Silver Metallic, Atlantis Blue Metallic, Tungsten Metallic, Blue Ray Metallic | 357400         |