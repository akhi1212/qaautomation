Feature: Retrieve a vehicle by VIN and verify buildDate, buildMSRP, wmiCountry, wmiManufacturer, & mfrModelCode values are being populated in the service response.

  Scenario Outline: Validate vehicle information data returned by vds for a vin
    Given User wants to retrieve vin information for '<vin>'
    When User calls vds for vin
    Then User should see the '<buildDate>', '<buildMSRP>', '<wmiCountry>', '<wmiManufacturer>', '<mfrModelCode>' in service response the vin.

    #This feature does not apply to catalogData VIN. I have included VIN for each US buildData & engineeredData source with some that have null data points.

    Examples:
      | vin               | buildDate  | buildMSRP | wmiCountry    | wmiManufacturer                         | mfrModelCode |
      | 1GC0KREG8KF231149 | 02/18/2019 | 41600.0   | United States | General Motors                          | CK25903      |
      | 1G11F5RR7DF102103 | 01/26/2012 |           | United States | General Motors                          | 1GC69        |
      | 4S4BSANC4G3301760 |            | 0.0       | United States | Subaru of Indiana Automotive Inc.       | GDF          |
      | JF2SKAGC1KH584973 | 07/15/2019 | 26695.0   | Japan         | Subaru Corporation                      | KFF          |
      | 1N4BL3AP9HC274505 | 06/01/2017 | 36415.0   | United States | Nissan Motor Mfg Corp USA               | 13617        |
      | 3N1CE2CP4FL397701 | 11/18/2014 | 19855.0   | Mexico        | Nissan Mexicana SA de CV                | 11015        |
      | 2C4RC1AG3JR229313 | 02/10/2018 |           | Canada        | FCA Canada Inc                          | RUCE53       |
      | 1C6SRFGT8KN566597 | 09/02/2018 |           | United States | FCA US LLC                              | DT6L98       |
      | 5XYP2DHC2LG039914 | 08/14/2019 |           | United States | Kia Motors Manufacturing Georgia Inc    | J4422        |
      | KNDPM3AC2L7687944 | 04/22/2019 |           | South Korea   | Kia Motors Corp                         | 42222        |
      | WBS8M9C52J5K99569 | 05/29/2018 | 66500.0   | Germany       | BMW M GmbH Gesellschaft fuer            | 18TN         |
      | 5UXKR0C59J0X97760 | 12/18/2017 | 59250.0   | United States | BMW Manufacturing Co LLC                | 18XG         |
      | JM3KFACM7J0312174 | 11/13/2017 | 28950.0   | Japan         | Mazda Motor Corp                        | CX5TR2A      |
      | JM1NDAB71H0122078 | 02/14/2017 | 25790.0   | Japan         | Mazda Motor Corp                        | MX5SP6P      |
      | 5NPE24AF1GH398763 | 02/19/2016 | 22930.0   | United States | Hyundai Motor Manufacturing Alabama LLC | 28402F4P     |
      | KMHC85LC8HU049231 | 07/06/2017 | 28560.0   | South Korea   | Hyundai Motor Co                        | N0542F4S     |
      | JTDKARFU9K3101964 | 07/04/2020 | 36787.0   | Japan         | Toyota Motor Corp                       | 1227         |
      | 5TDDZRBHXLS008851 | 03/21/2020 | 51454.0   | United States | Toyota Motor Manufacturing Indiana Inc  | 6956         |
      | 1FTFW1E55LFB63070 | 03/30/2020 | 56530.0   | United States | Ford Motor Company                      | W1E          |
      | MAJ3P1TE9JC199884 | 03/30/2020 | 25286.0   | India         | Ford India Ltd                          | P1T          |

