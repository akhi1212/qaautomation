Feature: Retrieve a vehicle by VIN and verify correct source values are being populated in the service response.


  Scenario Outline: Validate source information data returned by vds for a vin
    Given User wants to retrieve vin information for '<vin>'
    When User calls vds for vin
    Then User should see the '<source>' service response the vin.
    # B for build
    #E for engineered
    #C for catalog
    #S for Sparse
    Examples:
      | vin                | source  |
      | 1GC0KREG8KF231149  |   B     |
      | WMWXP5C53K2H97916  |   B     |
      | 1G1PC5SB1E7428104  |   C     |
      | 5TFCZ5AN5LX215802  |   C     |
      | JTDKARFU9K3101964  |   E     |
      | 5TFUY5F18LX934832  |   E     |
      | 2GCDC14K0J1101880  |   S     |
      | 1FACP41E0LF154760  |   S     |