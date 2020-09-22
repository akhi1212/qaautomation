Feature: Retrieve English features by vin for Catalog Data VIN

  Scenario Outline: Validate get English features for Catalog Data return by vds
    Given Actor wants to retrieve vin information for '<vin>'
    When he calls vds for vin
    Then he should see the English features contains <id>, <name> in service response for <description>
    Examples:
      | testCase | vin               | id    | description                        | name                                            |
      | 1        | 2C3CCAAG3JH151454 | 21690 | Engine                             | Pentastar V6                                    |
      | 2        | 1GNSCHKCXJR136338 | 12810 | Front side impact airbag passenger | Seat mounted side impact front passenger airbag |
      #|3       |JYARJ28Y6JA001431|10030|Fuel Type|Gaseous|

