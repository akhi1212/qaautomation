Feature: Retrieve a vehicle by vin

  Scenario: Validate get vin operation return by vds
    Given Corey wants to retrieve vin information for '1G1PC5SB1E7428104'
    When he calls vds for vin
    Then he should see the vin information in the response