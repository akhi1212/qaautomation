##Retrieve a vehicle by vin and verify ADAS feature as isAdas True is being populated in the response
Feature: retrieving_adas_feature_true_by_vin
  @Pending
  Scenario Outline: Validate  isAdas is True returned by vds for a vin.
    Given user wants to retrieve vin information for '<vin>'
    When user calls vds for vin
    Then user should see the '<id>','<key>','<sectionId>','<subSectionId>','<name>','<description>',  '<isAdasFeature>', as isAdas in the response for '<styleId>'.
    Examples:
      ## 1GC1KUEY1KF149554 >> build data vin
      ## 5YJ3E1EA5KF328931 >> Catalog data vin
      ## JTDKARFU9K3101964 >> engineered data vin
      | vin               | id    | key                  | sectionId | subSectionId | name                                                                  | description                        | isAdasFeature | styleId                     |
      | 1GC1KUEY1KF149554 | 21610 | 21610-OIC0502        | 2         | 12110        | Vehicle systems monitor                                               | Systems monitor                    | true          | 398859                      |
      | 1GC1KUEY1KF149554 | 15580 | 15580-OEA0103        | 2         | 12070        | Cruise control with steering wheel mounted controls                   | Cruise control                     | true          | 398859                      |
      | 1GC1KUEY1KF149554 | 12630 | 12630-HAC0202        | 2         | 12160        | Conventional right rear passenger door                                | Passenger doors rear right         | true          | 398859                      |
      | 1GC1KUEY1KF149554 | 19440 | 19440-FMB0302        | 6         | 16150        | Hill start assist                                                     | Hill start assist                  | true          | 398859                      |
      | 1GC1KUEY1KF149554 | 16470 | 16470-OID1603        | 6         | 12110        | Tire specific low air pressure warning                                | Low tire pressure warning          | true          | 398859                      |
      | 1GC1KUEY1KF149554 | 14150 | 14150-LFA0302        | 6         | 16120        | Front seatbelt pretensioners                                          | Seatbelt pretensioners             | true          | 398859                      |
      | 1GC1KUEY1KF149554 | 16650 | 16650-OIE0502        | 6         | 16010        | Lane Departure Warning                                                | Lane departure                     | true          | 398859                      |
      | 1GC1KUEY1KF149554 | 16680 | 16680-OIE0802        | 6         | 16010        | Forward Collision Alert                                               | Forward collision warning          | true          | 398859                      |
      | 1GC1KUEY1KF149554 | 19590 | 19590-OIE0403        | 6         | 16110        | Ultrasonic front and rear parking sensors                             | Parking sensors                    | true          | 398859                      |
      | 1GC1KUEY1KF149554 | 19560 | 19560-OIC1002        | 6         | 16050        | Rear mounted camera                                                   | Rear camera                        | true          | 398859                      |
      | 1GC1KUEY1KF149554 | 16640 | 16640-HEA0903HEB0903 | 3         | 13080        | Exterior mirror LED spot lights                                       | Exterior mirror spot lights        | true          | 398859                      |
      | 5YJ3E1EA5KF328931 | 21610 | 21610-OIC0502        | 2         | 12110        | Vehicle systems monitor                                               | Systems monitor                    | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 15580 | 15580-OEA0103        | 2         | 12070        | Cruise control with steering wheel mounted controls                   | Cruise control                     | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 12630 | 12630-HAC0202        | 2         | 12160        | Conventional right rear passenger door                                | Passenger doors rear right         | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 19580 | 19580-OIC1502        | 2         | 16050        | Forward facing traffic camera                                         | Traffic camera                     | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 15500 | 15500-ODC0203        | 7         | 17030        | Integrated navigation system with voice activation                    | Integrated navigation              | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 19440 | 19440-FMB0302        | 6         | 16150        | Hill start assist                                                     | Hill start assist                  | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 16470 | 16470-OID1603        | 6         | 12110        | Tire specific low air pressure warning                                | Low tire pressure warning          | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 19450 | 19450-HOA1102        | 6         | 16060        | Auto high-beam headlights                                             | Auto high-beam headlights          | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 16650 | 16650-OIE0503        | 6         | 16010        | Emergency Lane Departure Avoidance                                    | Lane departure                     | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 16670 | 16670-OIE0702        | 6         | 16010        | Blind spot warning                                                    | Blind spot                         | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 16680 | 16680-OIE0803        | 6         | 16010        | Forward collision mitigation                                          | Forward collision warning          | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 16690 | 16690-OIE0902        | 6         | 16010        | Rear collision warning                                                | Rear collision warning             | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 16740 | 16740-OIE1402        | 6         | 16010        | External acoustic pedestrian alert                                    | External acoustic pedestrian alert | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 19590 | 19590-OIE0403        | 6         | 16011        | Front and rear parking sensors                                        | Parking sensors                    | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 16370 | 16370-OIC0702        | 6         | 16050        | Front mounted camera                                                  | Front camera                       | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 16390 | 16390-OIC0902        | 6         | 16050        | Right side camera                                                     | Right camera                       | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 19540 | 19540-OIC0802        | 6         | 16050        | Left side camera                                                      | Left camera                        | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 19560 | 19560-OIC1002        | 6         | 16050        | Rear mounted camera                                                   | Rear camera                        | true          | 404853,406450,406451,406452 |
      | 5YJ3E1EA5KF328931 | 15590 | 15590-OEA0203        | 2         | 12070        | Traffic-Aware Cruise Control with stop and go                         | Adaptive cruise control            | true          | 406450,406451,406452        |
      | 5YJ3E1EA5KF328931 | 16700 | 16700-OIE1003        | 6         | 16010        | Pedestrian impact prevention                                          | Pedestrian detection               | true          | 406450,406451,406452        |
      | 5YJ3E1EA5KF328931 | 15600 | 15600-OEA0303        | 6         | 16010        | Hands-on cruise control with lane change                              | Autonomous cruise control          | true          | 406451,406452               |
      | 5YJ3E1EA5KF328931 | 16720 | 16720-OIE1203        | 6         | 16010        | Traffic sign recognition with speed limiter feature                   | Traffic sign information           | true          | 406451,406452               |
      | 5YJ3E1EA5KF328931 | 19590 | 19590-OIE0407        | 6         | 16110        | Autopark automated parking assistance                                 | Parking sensors                    | true          | 406451,406452               |
      | 5YJ3E1EA5KF328931 | 19590 | 19590-OIE0407        | 6         | 16110        | Autopark automated parking assistance                                 | Parking sensors                    | true          | 406451,406452               |
      | JTDKARFU9K3101964 | 21610 | 21610-OIC0502        | 2         | 12110        | Vehicle systems monitor                                               | Systems monitor                    | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 15580 | 15580-OEA0103        | 2         | 12070        | Cruise control with steering wheel mounted controls                   | Cruise control                     | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 15590 | 15590-OEA0203        | 2         | 12070        | Full-Speed Range Dynamic Radar Cruise Control (DRCC) with stop and go | Adaptive cruise control            | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 12630 | 12630-HAC0202        | 2         | 12160        | Conventional right rear passenger door                                | Passenger doors rear right         | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 15500 | 15500-ODC0203        | 7         | 17030        | Integrated navigation system with voice activation                    | Integrated navigation              | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 19440 | 19440-FMB0302        | 6         | 16150        | Hill Start Assist Control hill start assist                           | Hill start assist                  | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 16310 | 16310-OIC0102        | 6         | 12110        | Head-up display                                                       | Head up display                    | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 16470 | 16470-OID1602        | 6         | 12110        | Low tire pressure warning                                             | Low tire pressure warning          | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 14150 | 14150-LFA0302        | 6         | 16120        | Front seatbelt pretensioners                                          | Seatbelt pretensioners             | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 12620 | 12620-HOA1002        | 6         | 16060        | Directionally adaptive headlights                                     | Adaptive headlights                | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 19450 | 19450-HOA1102        | 6         | 16060        | Auto high-beam headlights                                             | Auto high-beam headlights          | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 16650 | 16650-OIE0503        | 6         | 16010        | Lane Departure Alert (LDA) w/Steering Assist                          | Lane departure                     | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 16670 | 16670-OIE0702        | 6         | 16010        | Blind Spot Monitor w/Lane Change Assist                               | Blind spot                         | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 16680 | 16680-OIE0803        | 6         | 16010        | Toyota Safety Sense P forward collision mitigation                    | Forward collision warning          | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 16690 | 16690-OIE0902        | 6         | 16010        | Rear Cross-Traffic Alert (RCTA) collision warning                     | Rear collision warning             | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 16700 | 16700-OIE1003        | 6         | 16010        | Pedestrian impact prevention                                          | Pedestrian detection               | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 16710 | 16710-OIE1102        | 6         | 16010        | Driver Monitoring System                                              | Driver attention alert             | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 16740 | 16740-OIE1402        | 6         | 16010        | External acoustic pedestrian alert                                    | External acoustic pedestrian alert | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 19590 | 19590-OIE0407        | 6         | 16110        | Automated parking assistance                                          | Parking sensors                    | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 17200 | 17200-OUA0402        | 6         | 16160        | Rain detecting wipers                                                 | Rain detecting wipers              | true          | 404156,404157,404158        |
      | JTDKARFU9K3101964 | 19560 | 19560-OIC1002        | 6         | 16050        | Rear mounted camera                                                   | Rear camera                        | true          | 404156,404157,404158        |

