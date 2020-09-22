Feature: Retrieve English features by vin for Build Data VIN

  Scenario Outline: Validate get English features for Build Data return by vds
    Given Actor wants to retrieve vin information for '<vin>'
    When he calls vds for vin
    Then he should see the English features contains <id>, <name> in service response for <description>
    Examples:
      | testCase | vin               | id    | description            | name                   |
      | 1        | 1G1PC5SB1E7428104 | 12175 | Number of doors         | 4 doors                |
      | 2        | 4S3BWAA60L3016959 | 12020 | Spoiler                | Rear lip spoiler       |
      | 3        | 4S3BWAB60L3016751 | 10080 | Cylinder head material | Aluminum cylinder head |
      | 4        | 4S4WMARDXL3448397 | 19420 | Roof rack              | Roof rails             |