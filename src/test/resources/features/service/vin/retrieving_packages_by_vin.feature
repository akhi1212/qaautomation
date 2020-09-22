Feature: Retrieve packages list for Build Data, Catalog and Engineered data vins in vds response are being populated.


  Scenario Outline: Validate vin return package list.
    Given user wants to retrieve vin information for '<vin>'
    When user calls vds for vin
    Then user should  see packages value '<id>', '<key>', '<sectionId>', '<subSectionId>', '<name>', '<description>' in service response for '<styles>'
    Examples:
      | vin               | id     | key            | sectionId | subSectionId | name                        | description                 | styles                                                  |
     ##build data vin
      | 1GC0WLE70LF212551 | 103660 | 103660-BES2402 | 29        | 111250       | Safety Package              | Safety Package              | 405223                                                  |
      | 1GC0WLE70LF212551 | 100920 | 100920-BCA0902 | 29        | 111100       | Convenience Package         | Convenience Package         | 405223                                                  |
      | 1GC0WLE70LF212551 | 101370 | 101370-BEE1202 | 29        | 111120       | Essential Package           | Essential Package           | 405223                                                  |
      | 4S3BWAA60L3016959 | 104900 | 104900-BCA3302 | 29        | 111290       | Wheel Package               | Wheel Package               | 409110                                                  |
      | 4S3BWAA60L3016959 | 102840 | 102840-BEP1802 | 29        | 111230       | Popular Package             | Popular Package             | 409110                                                  |
      | 4S4WMARDXL3448397 | 102840 | 102840-BEP1802 | 29        | 111230       | Popular Package             | Popular Package             | 406690                                                  |
     ##catalog data vin
      | 2C3CCAAG3JH151454 | 104790 | 104790-BCA3202 | 29        | 111280       | Value Package               | Value Package               | 392909                                                  |
      | 2C3CCAAG3JH151454 | 101060 | 101060-BED1202 | 29        | 111110       | Driver Convenience Package  | Driver Convenience Package  | 392909                                                  |
      | 2C3CCAAG3JH151454 | 102730 | 102730-BEP0702 | 29        | 111230       | Premium                     | Premium                     | 392909                                                  |
      | 1GNSCHKCXJR136338 | 104220 | 104220-BET0102 | 29        | 111260       | Texas Edition               | Texas Edition               | 392680                                                  |
      | 1GNSCHKCXJR136338 | 103460 | 103460-BES0402 | 29        | 111250       | Signature                   | Signature                   | 392680                                                  |
      | 1GNSCHKCXJR136338 | 101420 | 101420-BCA1102 | 29        | 111120       | Entertainment Package       | Entertainment Package       | 392680                                                  |
      | 1GNSCHKCXJR136338 | 102330 | 102330-BEM0102 | 29        | 111200       | Midnight                    | Midnight                    | 392680                                                  |
      | 1GNSCHKCXJR136338 | 102500 | 102500-BEM1802 | 29        | 111200       | Max Tow Package             | Max Tow Package             | 392680                                                  |
      | 1GNSCHKCXJR136338 | 103390 | 103390-BER3102 | 29        | 111200       | Rally Sport Truck (RST)     | Rally Sport Truck (RST)     | 392680                                                  |
      | 1GNSCHKCXJR136338 | 102300 | 102300-BCA1802 | 29        | 111190       | Luxury Package              | Luxury Package              | 392680                                                  |
      | 1GC0KREG8KF231149 | 100920 | 100920-BCA0902 | 29        | 111100       | Convenience Package         | Convenience Package         | 404174                                                  |
      | 1GC0KREG8KF231149 | 101370 | 101370-BEE1202 | 29        | 111120       | Essential Package           | Essential Package           | 404174                                                  |
      | 1G1PC5SB1E7428104 | 104570 | 104570-BCA2602 | 29        | 111260       | Technology Package          | Technology Package          | 357400                                                  |
      | 1G1PC5SB1E7428104 | 103660 | 103660-BES2402 | 29        | 111250       | Safety Package              | Safety Package              | 357400                                                  |
      | 1G1PC5SB1E7428104 | 100380 | 100380-BCA0202 | 29        | 111080       | Appearance Package          | Appearance Package          | 357400                                                  |
      ##engineered Data
      | 4T1K61AK9LU900451 | 100980 | 100980-BED0402 | 29        | 111110       | Driver Assist Package       | Driver Assist Package       | 408156                                                  |
      | 4T1K61AK9LU900451 | 101520 | 101520-BEF0702 | 29        | 111130       | Fleet Driver Assist Package | Fleet Driver Assist Package | 408156                                                  |
      | 4T1K61AK9LU900451 | 100380 | 100380-BCA0202 | 29        | 111080       | Appearance Package          | Appearance Package          | 408156                                                  |
      | 4T1K61AK9LU900451 | 100380 | 100380-BCA0202 | 29        | 111080       | Appearance Package          | Appearance Package          | 408156                                                  |
      | 1FTFW1E52LFB37638 | 103680 | 103680-BES2602 | 29        | 111250       | Sport Appearance            | Sport Appearance            | 409613,409614,409615,409624,409625,409626               |
      | 1FTFW1E52LFB37638 | 103750 | 103750-BES3302 | 29        | 111250       | STX Appearance              | STX Appearance              | 409613,409624                                           |
      | 1FTFW1E52LFB37638 | 100700 | 100700-BEC0802 | 29        | 111100       | Chrome Appearance           | Chrome Appearance           | 409613,409614,409615,409616,409624,409625,409626,409627 |
      | 1FTFW1E52LFB37638 | 101810 | 101810-BEH1302 | 29        | 111150       | Heavy Duty Payload Package  | Heavy Duty Payload Package  | 409624,409625                                           |
      | 1FTFW1E52LFB37638 | 104700 | 104700-BCA3102 | 29        | 111270       | Utility Package             | Utility Package             | 409615,409626                                           |
      | JTDKARFU9K3101964 | 102010 | 102010-BEL0302 | 29        | 111190       | Limited                     | Limited                     | 404156,404157,404158                                    |
      | JTDKARFU9K3101964 | 102940 | 102940-BEP2802 | 29        | 111230       | Premium Convenience Package | Premium Convenience Package | 404156,404157,404158                                    |
      | 5TFUY5F18LX934832 | 104830 | 104830-BEW0302 | 29        | 111290       | Work Truck                  | Work Truck                  | 407475                                                  |
      | 5TFUY5F18LX934832 | 100470 | 100470-BEB0502 | 29        | 111090       | Black Out Edition           | Black Out Edition           | 407475                                                  |
