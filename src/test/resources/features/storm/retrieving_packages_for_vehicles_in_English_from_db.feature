#Query the DB directly by styleID and verify the packages contain id, key, sectionId, subSectionId, name, and description.
Feature: retrieving_packages_for_vehicles_in_English_from_db


  Scenario Outline: Validate RVE scripts's package values by DB query
    Given Actor wants to get a valid connection to the database
    When Actor wants to retrieve vehicle information from the DB for '<styleId>'
    Then user should see packages value '<featureId>', '<featureKey>', '<featureCode>', '<subSectionId>', '<subSectionName>', '<featureIdName>', '<featureName>' in the query response
    Examples:
      | styleId | featureId | featureKey     | featureCode | subSectionId | subSectionName   | featureIdName               | featureName                 |
        #Build Data
      | 399751  | 103660    | 103660-BES2402 | Package     | 111250       | Packages S       | Safety Package              | Safety Package              |
      | 401675  | 102840    | 102840-BEP1802 | Package     | 111230       | Packages P       | Popular Package             | Popular Package             |
      | 404798  | 104550    | 104550-BET3402 | Package     | 111260       | Packages T       | Track Handling Package      | Track Handling Package      |
      | 398535  | 101040    | 101040-BED1002 | Package     | 111110       | Packages D       | Driver Confidence Package   | Driver Confidence Package   |
      | 397607  | 105210    | 105210-BE30502 | Package     | 111330       | Packages Numeric | 3ZR                         | 3ZR                         |
      | 401584  | 103890    | 103890-BES4702 | Package     | 111250       | Packages S       | Sun and Sound               | Sun and Sound               |
      | 398858  | 104210    | 104210-BCA2502 | Package     | 111250       | Packages S       | Sport Package               | Sport Package               |
        #Catalog Data
      | 403013  | 100920    | 100920-BCA0902 | Package     | 111100       | Packages C       | Convenience Package         | Convenience Package         |
      | 402223  | 100690    | 100690-BEC0702 | Package     | 111100       | Packages C       | Cold Climate/Cold Weather   | Cold Climate/Cold Weather   |
      # The commented out test case passes until JIRA issue VDS-731 is resolved.
      | 407338  | 100980    | 100980-BED0402 | Package     | 111110       | Packages D       | Driver Assist Package       | Driver Assist Package       |
      | 397712  | 104750    | 104750-BEV0502 | Package     | 111280       | Packages V       | Vision Assist Package       | Vision Assist Package       |
      | 410728  | 104790    | 104790-BCA3202 | Package     | 111280       | Packages V       | Value Package               | Value Package               |
        #Engineered Data
      | 404156  | 102010    | 102010-BEL0302 | Package     | 111190       | Packages L       | Limited                     | Limited                     |
      | 408153  | 101520    | 101520-BEF0702 | Package     | 111130       | Packages F       | Fleet Driver Assist Package | Fleet Driver Assist Package |
      | 407000  | 100980    | 100980-BED0402 | Package     | 111110       | Packages D       | Driver Assist Package       | Driver Assist Package       |
      | 404624  | 100920    | 100920-BCA0902 | Package     | 111100       | Packages C       | Convenience Package         | Convenience Package         |
      | 399980  | 103730    | 103730-BES3102 | Package     | 111250       | Packages S       | Safe and Smart              | Safe and Smart              |
      | 409843  | 103750    | 103750-BES3302 | Package     | 111250       | Packages S       | STX Appearance              | STX Appearance              |
      | 408400  | 104380    | 104380-BET1702 | Package     | 111260       | Packages T       | TRD Off-Road                | TRD Off-Road                |
