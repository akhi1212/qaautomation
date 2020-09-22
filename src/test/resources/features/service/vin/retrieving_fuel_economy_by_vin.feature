Feature: retrieving_fuel_economy_by_vin
  #Validate EPA fuel economy TechSpecs for VINs with a variety of fuel types in vds response.

  Scenario Outline: Validate retrieved fuel economy techSpecs for VIN return by vds
    Given Actor wants to retrieve vin information for '<vin>'
    When Actor calls vds for vin
    Then he should see the English techSpecs contains '<id>', '<key>', '<sectionId>', '<subSectionId>', '<name>', '<description>' in service response for '<styles>'
    Examples:
      | vin               | id    | key                                             | sectionId | subSectionId | name                                         | description                     | styles         |
#diesel
      | SAJAJ4BN6HA953627 | 17270 | 17270-RAA013000                                 | 11        | 111010       | 30 mpg                                       | Fuel economy city               | 381510         |
      | SAJAJ4BN6HA953627 | 17310 | 17310-RAA083400                                 | 11        | 111010       | 34 mpg                                       | Combined fuel economy           | 381510         |
      | SAJAJ4BN6HA953627 | 20000 | 20000-RAA024000                                 | 11        | 111010       | 40 mpg                                       | Fuel economy highway            | 381510         |
      | SAJAJ4BN6HA953627 | 19990 | 19990-RAA013000024000083400                     | 11        | 111010       | Fuel economy: 30 city/40 hwy/34 comb  MPG    | Fuel economy comb               | 381510         |
#gasoline
      | 1FTPW04V79KB06630 | 17270 | 17270-RAA011400                                 | 11        | 111010       | 14 mpg                                       | Fuel economy city               | 305777, 305778 |
      | 1FTPW04V79KB06630 | 20000 | 20000-RAA021900                                 | 11        | 111010       | 19 mpg                                       | Fuel economy highway            | 305777, 305778 |
      | 1FTPW04V79KB06630 | 19990 | 19990-RAA01140002190008100                      | 11        | 111010       | Fuel economy: 14 city/19 hwy MPG             | Fuel economy comb               | 305777, 305778 |
#electric
      | 5YJ3E1EB9KF418639 | 11100 | 11100-FFI0106RAA0112001021120105020811598RAB051 | 11        | 111010       | 120 city/112 hwy/116 comb MPG                | Fuel economy                    | 404854, 404855 |
      | 5YJ3E1EB9KF418639 | 17270 | 17270-RAA0112001                                | 11        | 111010       | 120 mpg                                      | Fuel economy city               | 404854, 404855 |
      | 5YJ3E1EB9KF418639 | 17310 | 17310-RAA0811598                                | 11        | 111010       | 116 mpg                                      | Combined fuel economy           | 404854, 404855 |
      | 5YJ3E1EB9KF418639 | 17320 | 17320-RAA092900                                 | 11        | 111010       | 29                                           | Combined electric fuel economy  | 404854, 404855 |
      | 5YJ3E1EB9KF418639 | 20000 | 20000-RAA0211201                                | 11        | 111010       | 112 mpg                                      | Fuel economy highway            | 404854, 404855 |
      | 5YJ3E1EB9KF418639 | 19990 | 19990-RAA011200102112010811598                  | 11        | 111010       | Fuel economy: 120 city/112 hwy/116 comb  MPG | Fuel economy comb               | 404854, 404855 |
#hydrogen
      | JTDBVRBD6HA002078 | 17270 | 17270-RAA016600                                 | 11        | 111010       | 66 mpg                                       | Fuel economy city               | 389647         |
      | JTDBVRBD6HA002078 | 17310 | 17310-RAA086600                                 | 11        | 111010       | 66 mpg                                       | Combined fuel economy           | 389647         |
      | JTDBVRBD6HA002078 | 20000 | 20000-RAA026600                                 | 11        | 111010       | 66 mpg                                       | Fuel economy highway            | 389647         |
      | JTDBVRBD6HA002078 | 19990 | 19990-RAA016600026600086600                     | 11        | 111010       | Fuel economy: 66 city/66 hwy/66 comb  MPG    | Fuel economy comb               | 389647         |
#alternate fuel
      | 1C6RR6KG2HS695759 | 17270 | 17270-RAA011700                                 | 11        | 111010       | 17 mpg                                       | Fuel economy city               | 386859         |
      | 1C6RR6KG2HS695759 | 17310 | 17310-RAA082000                                 | 11        | 111010       | 20 mpg                                       | Combined fuel economy           | 386859         |
      | 1C6RR6KG2HS695759 | 20000 | 20000-RAA022500                                 | 11        | 111010       | 25 mpg                                       | Fuel economy highway            | 386859         |
      | 1C6RR6KG2HS695759 | 19990 | 19990-RAA011700022500082000                     | 11        | 111010       | Fuel economy: 17 city/25 hwy/20 comb  MPG    | Fuel economy comb               | 386859         |
      | 1C6RR6KG2HS695759 | 17330 | 17330-RAB011200                                 | 11        | 111020       | 12 mpg                                       | Alternate fuel economy city     | 386859         |
      | 1C6RR6KG2HS695759 | 17340 | 17340-RAB011200021700081400                     | 11        | 111020       | 12 city/17 hwy/14 comb MPG                   | Alternate fuel economy combined | 386859         |
      | 1C6RR6KG2HS695759 | 17350 | 17350-RAB021700                                 | 11        | 111020       | 17 mpg                                       | Alternate fuel economy highway  | 386859         |
      | 1C6RR6KG2HS695759 | 17390 | 17390-RAB081400                                 | 11        | 111020       | 14 mpg                                       | Alternate combined fuel econ    | 386859         |