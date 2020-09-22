Feature: Retrieve the count of features vehicle by VIN having multiple styleIds which are populated in the service response.

  @Pending
  Scenario Outline: Validate the count of features returned by vds.
    Given Actor wants to retrieve vin information for '<vin>'
    When Actor calls vds for vin
    Then user should see '<count>' of '<result>' for multiple <styleIds> in service response.

  # The count for features is set with a placeholder and the feature file will be implemented once the install cause
    # VDS-454 ticket is completed
    Examples:
      | testCase | vin               | result   | count         | styleIds                                                                                                                                                                |
      | 1        | 5TFCZ5AN5LX215802 | features | -placeholder- | 408388,408389,408390,408391,408392,408393,408394,408395,408396,408397,408398,408399,408400,408401,408402,408403,408404,408405,408406,408407,408408,408412,408413,408414 |
      | 2        | 1FT8W3BTXKED84286 | features | -placeholder- | 400496,400497,400498,400499,400500,400501,400506,400507,400508,400509,400510,400511                                                                                     |
      | 3        | JTEBU5JR4J5492846 | features | -placeholder- | 394513,394514,394515,394516,394517,394518,394519,394520,394521,394522,394523,394524,394525,394526,394527,394528,394529,394530                                           |
      | 4        | 1FDUF4HT9LDA08922 | features | -placeholder- | 409990,409991,409994,409995,409998,409999,410002,410003                                                                                                                 |
      | 5        | 1GTH5BEN1L1237731 | features | -placeholder- | 408388,408389,408390,408391,408392,408393,408394,408395,408396,408397,408398,408399,408400,408401,408402,408403,408404,408405,408406,408407,408408,408412,408413,408414 |
      | 6        | 1GKKNXLS6LZ207531 | features | -placeholder- | 407941                                                                                                                                                                  |
      | 7        | 1GKS2CKJ3LR232428 | features | -placeholder- | 406676                                                                                                                                                                  |
      | 8        | 1GTW7AFG6L1220533 | features | -placeholder- | 407930                                                                                                                                                                  |
