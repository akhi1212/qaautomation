Feature: Retrieve a vehicle by vin and verify the Feature, Tech Specs, and Packages categories are being populated by the correct featureCode values.

  Scenario Outline: Validate vin return's category values by vds
    Given Logan wants to retrieve vin information for '<VIN>'
    When he calls vds for vin
    Then he should see a successful response, and the json '<jsonNotation>' response should be '<currentSetting>'
    Examples:
      | VIN               | jsonNotation                 | currentSetting |
      | 1G1PC5SB1E7428104 | error                        | false          |
      | 1G1PC5SB1E7428104 | result.features.featureCode  | Feature        |
      | 1G1PC5SB1E7428104 | result.techSpecs.featureCode | TechSpec       |
      | 1G1PC5SB1E7428104 | result.packages.featureCode  | Package        |