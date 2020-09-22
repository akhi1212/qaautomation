Feature: Retrieve a vehicle by vin and verify the number of doors  is being populated in the response.

  Scenario Outline: Validate RVE response populated number of doors
    Given user wants to retrieve vin information for '<vin>'
    When user calls vds for vin
    Then user should see the '<number of doors>' in the response

#This is a mix of vin call for 2,  4 doors in a variety of body styles;
  # Cargo van, Chassis, Electric, Hybrid, Performance Car.
    Examples:
     |  vin               | number of doors |
     | 1G4PW5SK4G4129396  |       4         |
     | ZFBHRFAB8K6M18448  |       4         |
     | 1GB3GSCG4K1157321  |       2         |
     | 5YJRE1A32A1000878  |       2         |
     | JH4KC2F91JC800029  |       4         |
     | WP0AA2A87EK172460  |       2         |