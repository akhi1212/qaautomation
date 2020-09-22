Feature: retrieving_techSpecs_by_styleId_from_DB
  #Query the DB directly by styleID and verify the techSpec values are being populated by the etl service.

  Scenario Outline: Validate RVE scripts's techSpec values by DB query
    Given Actor wants to get a valid connection to the database
    When Actor wants to retrieve techSpecs from the DB for '<styleId>'
    Then Actor should see the 'featureCode' as '<featureCode>', 'subSectionName' as '<subSectionName>', 'featureIdName' as '<featureIdName>', 'featureName' as '<featureName>', 'icCodeAnswers' as '<icCodeAnswers>' in the query response

    Examples:
      | styleId | featureCode | subSectionName        | featureIdName                           | featureName  | icCodeAnswers |
      | 406491  | TechSpec    | Weights               | Curb weight                             | 4,970 lbs.   | RBA01=497000  |
      | 406491  | TechSpec    | Trailering            | Towing capacity                         | 6,600 lbs.   | RBB01=660000  |
      | 406491  | TechSpec    | Interior Measurements | Head room first-row                     | 43"          | RCD01=4303    |
      | 406491  | TechSpec    | Exterior Measurements | Pickup box depth                        | 22.4"        | RDA04=2240    |
      | 406491  | TechSpec    | Exterior measurements | Vehicle turning radius                  | 24.75'       | REB04=2475    |
      | 406491  | TechSpec    | Exterior measurements | Min ground clearance                    | 8"           | REC07=795     |
      | 406491  | TechSpec    | Engine specs          | Displacement                            | 325 cu.in.   | FAC01=32513   |
      | 406491  | TechSpec    | Transmission          | First gear ratio                        | 4.56         | FCD01=456     |
      | 406491  | TechSpec    | Transmission          | Second gear ratio                       | 2.97         | FCD02=297     |
      | 406491  | TechSpec    | Transmission          | Third gear ratio                        | 2.08         | FCD03=208     |
      | 406491  | TechSpec    | Transmission          | Fourth gear ratio                       | 1.69         | FCD04=169     |
      | 406491  | TechSpec    | Transmission          | Fifth gear ratio                        | 1.27         | FCD05=127     |
      | 406491  | TechSpec    | Transmission          | Sixth gear ratio                        | 1            | FCD06=100     |
      | 406491  | TechSpec    | Transmission          | Reverse gear ratio                      | 3.82         | FCD07=382     |
      | 414840  | TechSpec    | Battery               | Battery rating                          | 650CCA       | FBE01=65000   |
      | 414840  | TechSpec    | Brakes                | Front brake diameter                    | 13"          | FMC01=1300    |
      | 414840  | TechSpec    | Interior Measurements | Leg room first-row                      | 41.1"        | RCC01=4110    |
      | 414840  | TechSpec    | Interior Measurements | Hip room second-row                     | 64.8"        | RCE02=6480    |
      | 414840  | TechSpec    | Interior Measurements | Interior cargo volume                   | 32.3 cu.ft.  | RDB01=3230    |
      | 414840  | TechSpec    | Interior Measurements | Interior cargo volume with seats folded | 87.5 cu.ft.  | RDB02=8750    |
      | 414840  | TechSpec    | Interior Measurements | Interior cargo area height              | 47.6"        | RDB04=4760    |
      | 414840  | TechSpec    | Interior Measurements | Interior cargo area min width           | 48.8"        | RDB08=4880    |
      | 414840  | TechSpec    | Engine specs          | Displacement                            | 220 cu.in.   | FAC01=21993   |
      | 414840  | TechSpec    | Exterior measurements | Wheelbase                               | 121.6"       | REB01=12160   |
      | 414840  | TechSpec    | Exterior measurements | Vehicle body height                     | 69.9"        | REA03=6990    |
