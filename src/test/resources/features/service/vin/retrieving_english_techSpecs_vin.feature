Feature: Retrieve English TechSpecs for Build Data, Catalog & Engineered VINs in vds response.

  Scenario Outline: Validate get English techSpecs for Build Data return by vds
    Given Actor wants to retrieve vin information for '<vin>'
    When he calls vds for vin
    Then he should see the English techSpecs contains '<id>', '<key>', '<sectionId>', '<subSectionId>', '<name>', '<description>' in service response for '<styles>'
    Examples:
      | vin               | id    | key                      | sectionId | subSectionId | name                          | description                | styles |
      #The Curb weight values returned by VDS service are 6,092/6,121/6,955 lbs. which is mapped with CADA PROD (Rev Code 1040108) but latest CADA QA returns as below
            #which is different from the values in CADA Prod (Rev Code 1094527) as 6,105 lbs. Therefore, the install/uninstall logic will correct this
      | 1GC0WLE70LF212551 | 17560 | 17560-RBA01609200        | 9         | 19040        | 6,092 lbs.                    | Curb weight                | 405223 |
      | 1GC0WLE70LF212551 | 17570 | 17570-RBA02990000        | 9         | 19040        | 9,900 lbs.                    | GVWR                       | 405223 |
      | 4S3BWAA60L3016959 | 20450 | 20450-FAN031760004440000 | 5         | 15080        | 176 lb.-ft.@4400 RPM          | Torque                     | 409110 |
      | 4S4BTGPD4L3231404 | 11760 | 11760-FQA011849          | 5         | 15100        | Fuel tank capacity: 18.5 gal. | Fuel tank capacity         | 409287 |
      | 4S4BTGPD4L3231404 | 18020 | 18020-RCG0110560         | 8         | 18010        | 105.6 cu.ft.                  | Total passenger volume     | 409287 |
      | 4S4WMARDXL3448397 | 18220 | 18220-RDB043360          | 8         | 18010        | 33.6"                         | Interior cargo area height | 406690 |
      | 4S4WMARDXL3448397 | 18280 | 18280-REA0119680         | 9         | 19010        | 196.8"                        | Vehicle body length        | 406690 |


  Scenario Outline: Validate get English techSpecs for Catalog Data return by vds
    Given Actor wants to retrieve vin information for '<vin>'
    When he calls vds for vin
    Then he should see the English techSpecs contains '<id>', '<key>', '<sectionId>', '<subSectionId>', '<name>', '<description>' in service response for '<styles>'
    Examples:
      | vin               | id    | key                         | sectionId | subSectionId | name                                      | description             | styles |
      | 2C3CCAAG3JH151454 | 10260 | 10260-FBD0116000            | 5         | 15010        | 160A                                      | Alternator Amps         | 392909 |
      | 2C3CCAAG3JH151454 | 10010 | 10010-FAB07400              | 5         | 15060        | 4                                         | Valves per cylinder     | 392909 |
      | 1GNSCHKCXJR136338 | 19990 | 19990-RAA011600022300081900 | 11        | 111010       | Fuel economy: 16 city/23 hwy/19 comb  MPG | Fuel economy comb       | 392680 |
      | 1GC0KREG8KF231149 | 10230 | 10230-FAN0802               | 5         | 15080        | AUG2004 compliant                         | SAEJ1349                | 404174 |
      | 1GC0KREG8KF231149 | 17970 | 17970-RCF016603             | 8         | 18010        | 66"                                       | Shoulder room first-row | 404174 |
      | 1G1PC5SB1E7428104 | 18560 | 18560-REB041785             | 9         | 19010        | 17.85'                                    | Vehicle turning radius  | 357400 |


  Scenario Outline: Validate get English techSpecs for Engineered Data return by vds
    Given Actor wants to retrieve vin information for '<vin>'
    When he calls vds for vin
    Then he should see the English techSpecs contains '<id>', '<key>', '<sectionId>', '<subSectionId>', '<name>', '<description>' in service response for '<styles>'
    Examples:
      | vin               | id    | key                         | sectionId | subSectionId | name                       | description                     | styles                                                                              |
      | 4T1K61AK9LU900451 | 18290 | 18290-REA027240             | 9         | 19010        | 72.4"                      | Vehicle body width              | 408156                                                                              |
      | 1FTFW1E52LFB37638 | 18120 | 18120-RDA042140             | 9         | 19010        | 21.4"                      | Pickup box depth                | 409613,409614,409615,409616,409617,409624,409625,409626,409627,409628               |
      | 1FTFW1E52LFB37638 | 17340 | 17340-RAB011300021700081500 | 11        | 111020       | 13 city/17 hwy/15 comb MPG | Alternate fuel economy combined | 409613,409614                                                                       |
      | JTDKARFU9K3101964 | 18020 | 18020-RCG019310             | 8         | 18010        | 93.1 cu.ft.                | Total passenger volume          | 404147,404148,404149,404150,404151,404152,404153,404154,404155,404156,404157,404158 |
      | 5TFUY5F18LX934832 | 10810 | 10810-FEE01430              | 5         | 15040        | 4.3                        | Axle ratio                      | 407475                                                                              |
