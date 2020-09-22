Feature: Query the DB directly by styleID and verify the Feature, Tech Specs, and Packages categories are being populated by the correct featureCode values.

  Scenario Outline: Validate RVE scripts's category values by DB query
    Given Actor wants to get a valid connection to the database
    When Actor wants to retrieve vehicle information from the DB for '<styleID>'
    Then user should see a response and the json '<jsonNotation>' response should be '<currentSetting>'
    Examples:
      | styleID | jsonNotation           | currentSetting |
      | 367387  | features.featureCode   | Feature        |
      | 367387  | techSpecs.featureCode  | TechSpec       |
      | 367387  | packages.featureCode   | Package        |