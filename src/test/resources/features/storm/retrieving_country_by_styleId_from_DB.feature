Feature: Query the DB directly by styleID and verify the country value for the style is being populated by the etl service.

  Scenario Outline: Validate RVE scripts's country value by DB query
    Given Actor wants to get a valid connection to the database
    When Actor wants to retrieve vehicle information from the DB for '<styleId>'
    Then Actor should see the 'country' as '<country>' in the query response

    Examples:
      |styleId  |country|
      | 405159  |  US   |
      | 408537  |  CA   |
      | 398336  |  US   |
      | 409280  |  CA   |
      | 374438  |  US   |
      | 383147  |  US   |
      | 409182  |  CA   |
      | 399145  |  CA   |
      | 379752  |  CA   |
      | 397081  |  CA   |
      | 377755  |  US   |