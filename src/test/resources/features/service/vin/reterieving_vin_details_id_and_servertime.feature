Feature: Retrieve a vehicle by VIN and verify id and server time are not populated in the service response.


  Scenario: Validate id and server time are removed in service response
    Given User wants to retrieve vin information for '1GC0KREG8KF231149'
    When User calls vds for vin
    Then User should not see the id and server time in the service response.
