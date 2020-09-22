Feature: Retrieve a vehicle by VIN and verify YMM are being populated in the service response.

  Scenario Outline: Validate YMM returned by vds for a vin
    Given Actor wants to retrieve vin information for '<vin>'
    When Actor calls vds for vin
    Then user should see the '<year>','<make>' and '<model>' in service response
    #The first 10 VINs are for US vehicles; the next 10 VINs are for CA vehicles.
    Examples:
      | vin                 | year | make       | model             |
      | 1G4ZN5SZXKU108960   | 2019 | Buick      | Lacrosse          |
      | 1GC4YPEY8LF130420   | 2020 | Chevrolet  | Silverado 2500HD  |
      | 3C6UR5CL9JG160358   | 2018 | RAM        | 2500              |
      | 1FTFW1RG1KFC59255   | 2019 | Ford       | F-150             |
      | 3MZBN1W34JM172271   | 2018 | Mazda      | Mazda3 4-Door     |
      | 4S3BNEN66H3044759   | 2017 | Subaru     | Legacy            |
      | WAUW2AFC2GN171175   | 2016 | Audi       | S7                |
      | JTHKD5BH3F2214618   | 2015 | Lexus      | CT 200h           |
      | 3C4PDCBB3ET237451   | 2014 | Dodge      | Journey           |
      | 1C4BJWDG5DL514303   | 2013 | Jeep       | Wrangler Unlimited|
      | KL4MMGSL8LB060620   | 2020 | Buick      | Encore GX         |
      | 5FNYF6H16KB009498   | 2019 | Honda      | Pilot             |
      | JN1BJ1CR6JW262614   | 2018 | Nissan     | Rogue Sport       |
      | WBY1Z8C35HV893813   | 2017 | BMW        | I3                |
      | 1C4BJWCG8FL548661   | 2015 | Jeep       | Wrangler          |
      | WP0AA2A87EK172460   | 2014 | Porsche    | Cayman            |
      | JTHKD5BH3F2214618   | 2015 | Lexus      | CT 200h           |
      | 2FMPK4K92JBB08207   | 2018 | Ford       | Edge              |





