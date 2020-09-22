Feature: Request a replay of Acodes for re-publishing

  Background: Storm ETL is running
    Given User spins up the etl for acode replay

  Scenario: Validate happy path single full acode
    Given user wants to publish acode 'USC90CRC131B0'
    When user publish acodes in etl automation
    Then user should see the updated time in the vindescriptiondetails with style id '401255'

  Scenario Outline: Validate Acode replay  with the multiple full acode
    Given user wants to publish acode '<acode>'
    When user publish acodes in etl automation
    Then user should see the updated time in the vindescriptiondetails with style id '<styleid>'
    Examples:
      |testCase  | acode                                       | styleid               |
      |1         | USC80BUC181A0, USC80BUC181B0, USC90CHC401A0 | 391684,391685,399469  |
      |2         | USD00BEC111A0, CAD00CAC232A0, CAD00CAC232B0 | 411701,407259,407260  |
 
    
#  acode variation  'USC90CAC20' >>  USC90CAC203 and USC90CAC204
#  acode variation  'USD00BMC10' >>   USD00BMC101 and USD00BMC102
  Scenario: Validate Acode replay  variation in the acode
    Given user wants to publish acode 'USC90CAC20,USD00BMC10'
    When user publish acodes in etl automation
    Then user should see the updated time in the vindescriptiondetails with style id '400447,400448,400449,400450,400451,400452,400453,408854,408855'

 # validate acode  model variation
  Scenario: Validate Acode replay model variation
    Given user wants to publish acode 'CAD00CAC23,USC90CHC311,USC90CHC40'
    When user publish acodes in etl automation
    Then user should see the updated time in the vindescriptiondetails with style id '407259,407260,407261,401852,401853,399469,399470'

#  TBD As there are 3k+ styleid in the dev or qa env,This will take 2-3 hours to execute
  @Pending
  Scenario: Validate Acode replay division variation
    Given user wants to publish acode 'USC90SM,USC90CA,CAC90CA,CAC80BU'
    When user publish acodes in etl automation
    Then user should see the updated time in the vindescriptiondetails with style id 'TBD'

#  TBD As there are 3k+ styleid in the dev or qa env,This will take 4-5 hours to execute
  @Pending
  Scenario: Validate Acode replay country variation
    Given user wants to publish acode 'USD00'
    When user publish acodes in etl automation
    Then user should see the updated time in the vindescriptiondetails with style id 'TBD'

#  TBD exception verification
  @Pending
  Scenario: Validate invalid Acode replay to verify exceptions
    Given user wants to publish acode 'ASD00,USDA001'
    When user publish acodes in etl automation
    Then user should see the exception for the invalid acode 'TBD'