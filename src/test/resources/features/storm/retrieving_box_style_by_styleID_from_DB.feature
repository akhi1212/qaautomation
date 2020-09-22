Feature: Query the DB directly by styleID and verify the boxStyle value is being populated by the etl service.
  
  Scenario Outline: Validate RVE scripts's box style value by DB query
    Given Actor wants to get a valid connection to the database
    When Actor wants to retrieve vehicle information from the DB for '<styleId>'
    Then Actor should see the 'boxStyle' as '<boxStyle>' in the query response

#The fist 6 styleID are for trucks where the boxStyle field is expected to be populated.
#The blank expected results for styleId 104652 & 410756 are for trucks that have bed deletes.
#The next 3 style ID are for car, van, and SUV vehicles where the boxStyle field is expected to be blank.
    Examples:
      | styleId |   boxStyle    |
      | 104652  |               |
      | 401271  | Regular Side  |
      | 305777  |   Flareside   |
      | 410756  |               |
      | 409445  | Regular Side  |
      | 280111  | Flare Side    |
      | 409973  |               |
      | 405729  |               |
      | 411413  |               |