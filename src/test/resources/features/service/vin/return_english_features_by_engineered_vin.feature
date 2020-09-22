Feature: Retrieve English features by vin for Engineered Data VIN

  Scenario Outline: Validate get English features for Engineered Data return by vds
    Given Actor wants to retrieve vin information for '<vin>'
    When he calls vds for vin
    Then he should see the English features contains <id>, <name> in service response for <description>
    Examples:
      |testCase|vin|id|description|name|
      |1       |3TYSX5EN6LT000919|15280|Steering mounted audio control|Steering wheel mounted audio controls|
      |2       |4T1K61AK9LU900451|12370|Bumpers rear|Body-colored rear bumper|
      |3       |1FTFW1E52LFB37638|19530|Child door locks|Manual rear child safety door locks|
      |4       |1FMCU9H66LUB54753|14480|Floor console storage|Covered floor console storage|