Feature: Retrieve a vehicle by VIN and verify multiple styleIds are being populated in the service response.

  Scenario Outline: Validate multiple styleIds returned by vds in vehicles.
    Given Actor wants to retrieve vin information for '<vin>'
    When Actor calls vds for vin
    Then user should see the '<styleId>' in vehicles array in service response.
    Examples:
      | testCase | vin               | styleId                                                                                                                       |
      | 1        | 1FTFX1E54KFA26018 | 403545,403546,403547,403551,403552,403553                                                                                     |
      | 2        | 5TFUY5F19KX801348 | 401271,401272,401273,401280,401281,401282,401283,401284,401285                                                                |
      | 3        | 1C4HJWEG1FL697338 | 370184,373991,374502                                                                                                          |
      | 4        | 1GTU9DED8LZ322525 | 406640,406645                                                                                                                 |
      | 5        | JTEBU5JR4J5492846 | 394513,394514,394515,394516,394517,394518,394519,394520,394521,394522,394523,394524,394525,394526,394527,394528,394529,394530 |


  Scenario Outline: Validate multiple styleIds returned by vds in features.
    Given Actor wants to retrieve vin information for '<vin>'
    When Actor calls vds for vin
    Then user should see '<styleIds>' with '<key>' in features array in service response.
    Examples:
      | testCase | vin               | key                | styleIds                                  |
      | 1        | 1FTFX1E54KFA26018 | 12175-HAC04400     | 403545,403546,403547,403551,403552,403553 |
      | 2        | 1FTFX1E54KFA26018 | 12480-HIB0502      | 403545,403551,403546,403552               |
      | 3        | 1FTFX1E54KFA26018 | 16840-OOA0302      | 403545,403546,403547,403551,403552,403553 |
      | 4        | 1FTFX1E54KFA26018 | 10500-FCB016000202 | 403545,403546                             |
      | 5        | 1FTFX1E54KFA26018 | 12440-HIA0504      | 403546,403547,403553                      |
      | 6        | 1FTFX1E54KFA26018 | 15040-OCA0106      | 403545,403546,403547,403551,403552,403553 |


  Scenario Outline: Validate multiple styleIds returned by vds in exterior colors array.
    Given Actor wants to retrieve vin information for '<vin>'
    When Actor calls vds for vin
    Then user should see '<styles>' with '<genericDesc>' & '<description>' in exterior color in service response.
    Examples:
      | testCase | vin               | genericDesc | description             | styles                                                                                                                                                                  |
      | 1        | 5TFUY5F19KX801348 | White       | Super White             | 401273,401272,401271,401282,401281,401280,401285,401284,401283                                                                                                          |
      | 2        | 5TFUY5F19KX801348 | Beige       | Quicksand               | 401282,401281,401280,401285,401284,401283                                                                                                                               |
      | 3        | 5TFUY5F19KX801348 | Brown       | Smoked Mesquite         | 401285,401284,401283                                                                                                                                                    |
      | 4        | 1FT8W3BTXKED84286 | Yellow      | School Bus Yellow       | 398724,398725,398734,398735                                                                                                                                             |
      | 5        | 1FT8W3BTXKED84286 | Black       | Agate Black Metallic    | 398724,398725,398726,398727,398728,398729,398734,398735,398736,398737,398738,398739                                                                                     |
      | 6        | 1FT8W3BTXKED84286 | Gray        | Magnetic Metallic       | 398724,398725,398726,398728,398734,398735,398736,398738                                                                                                                 |
      | 7        | 4T1B21HK3KU515306 | Off-white   | Wind Chill Pearl        | 401569,401568,401567                                                                                                                                                    |
      | 8        | 4T1B21HK3KU515306 | Red         | Ruby Flare Pearl        | 401563,401562,401561,401569,401568,401567                                                                                                                               |
      | 9        | 4T1B21HK3KU515306 | Gray        | Midnight Black Metallic | 401563,401562,401561,401566,401565,401564,401569,401568,401567                                                                                                          |
      | 10       | 5TFCZ5AN5LX215802 | White       | Super White             | 408388,408389,408390,408391,408392,408393,408394,408395,408396,408397,408398,408399,408400,408401,408402,408403,408404,408405,408406,408407,408408,408412,408413,408414 |
      | 11       | 5TFCZ5AN5LX215802 | Green       | Army Green              | 408405,408404,408403,408408,408407,408406                                                                                                                               |
      | 12       | 5TFCZ5AN5LX215802 | Blue        | Voodoo Blue             | 408390,408389,408388,408393,408392,408391,408396,408395,408394,408399,408398,408397,408402,408401,408400                                                                |


  Scenario Outline: Validate multiple styleIds returned by vds in interior colors array.
    Given Actor wants to retrieve vin information for '<vin>'
    When Actor calls vds for vin
    Then user should see '<styles>' with '<genericDesc>' & '<description>' in interior color in service response.
    Examples:
      | testCase | vin               | genericDesc | description        | styles                                                                                                                        |
      | 1        | 1FT7W2BTXLEC85667 | Beige       | Medium Light Camel | 410050,410060,410049,410059                                                                                                   |
      | 2        | 1FT7W2BTXLEC85667 | Black       | Highland Tan       | 410053,410063                                                                                                                 |
      | 3        | 1FT7W2BTXLEC85667 | Gray        | Medium Earth Gray  | 410048,410058,410049,410059                                                                                                   |
      | 4        | 5TFUY5F17LX913261 | Gray        | Graphite           | 407473,407474,407475,407476,407477,407478                                                                                     |
      | 5        | 5TFUY5F17LX913261 | Black       | Black              | 407476,407477,407478,407503,407504,407505                                                                                     |
      | 6        | 5TFUY5F17LX913261 | Beige       | Sand Beige         | 407476,407477,407478                                                                                                          |
      | 7        | 5TFCZ5AN5LX215802 | Black       | Black/Orange       | 408391,408392,408393,408394,408395,408396,408397,408398,408399,408400,408401,408402                                           |
      | 8        | 5TFCZ5AN5LX215802 | Gray        | Cement             | 408388,408389,408390,408414,408413,408412,408393,408392,408391,408396,408395,408394,408399,408398,408397,408402,408401,408400 |
      | 9        | 5TDKZ3DC6JS914904 | Beige       | Bisque             | 395909,395910,395911,395912,395913,395914,395936,395937,395938                                                                |
      | 10       | 5TDKZ3DC6JS914904 | Gray        | Ash                | 395909,395910,395911,395912,395913,395914,395936,395937,395938                                                                |

  Scenario Outline: Validate the count of vehicles, exteriorColors, interiorColors & features (single styleId) returned by vds.
    Given Actor wants to retrieve vin information for '<vin>'
    When Actor calls vds for vin
    Then user should see '<count>' of '<result>' for vehicles, exteriorColors, interiorColors & features (single styleId) in service response.
    Examples:
      | testCase | vin               | result         | count |
      | 1        | 5TFCZ5AN5LX215802 | vehicles       | 24    |
      | 2        | 5TFCZ5AN5LX215802 | exteriorColors | 9     |
      | 3        | 5TFCZ5AN5LX215802 | interiorColors | 7     |
      | 4        | 1FT8W3BTXKED84286 | vehicles       | 12    |
      | 5        | 1FT8W3BTXKED84286 | exteriorColors | 19    |
      | 6        | 1FT8W3BTXKED84286 | interiorColors | 6     |
      | 7        | JTEBU5JR4J5492846 | vehicles       | 18    |
#Commented out test case 8 until https://jira.autodata.net/browse/VDS-735 is resolved.
#      | 8        | JTEBU5JR4J5492846 | exteriorColors | 9     |
      | 9        | JTEBU5JR4J5492846 | interiorColors | 3     |
      | 10       | 1FDUF4HT9LDA08922 | vehicles       | 8     |
      | 11       | 1FDUF4HT9LDA08922 | exteriorColors | 16    |
      | 12       | 1FDUF4HT9LDA08922 | interiorColors | 2     |