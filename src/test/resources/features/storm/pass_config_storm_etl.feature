Feature: Process a gvuid with storm ETL

  Scenario Outline: Pass a new configuration files to storm
    Given Actor spins up the etl
    When Actor is setup with topic 'configData.gvuid' and gvuid as '<GVUID>'
    When he sets up the producer
    When he sets up consumer to get topic
    Then he should see the gvuid in the consumer response
    Examples:
      | testCase | GVUID                                |
      | 1        | 0000128e-ccae-457f-ae55-6763026c6ef0 |
      | 2        | 0000b568-bce7-46a7-903a-e5929fbb223e |


  Scenario Outline: Establish a db connection and then get vehicle summary response
    Given Actor wants to get a valid connection to the database
    When Actor wants to retrieve vehicle information from the DB after starting ETL for '<ListOfStyleIds>'
    Then he should see the styleid in the summary response
    Examples:
      | ListOfStyleIds |
      | 379446, 392487|