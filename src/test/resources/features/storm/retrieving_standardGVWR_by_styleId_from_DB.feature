Feature: Query the DB directly by styleID and verify the standardGVWR value is being populated by the etl service.
  
  Scenario Outline: Validate RVE scripts's standardGVWR value by DB query
    Given Actor wants to get a valid connection to the database
    When Actor wants to retrieve vehicle information from the DB for '<styleId>'
    Then Actor should see the 'standardGVWR' as '<standardGVWR>' in the query response

#This is a mix of styleID from a variety of vehicle types like sedan, coupe, convertible, van, truck., etc
    Examples:
      | styleId | standardGVWR |
      | 411474  |     4497     |
      | 398284  |              |
      | 407343  |     5300     |
      | 408442  |     4475     |
      | 405778  |     3814     |
      | 329736  |     3818     |
      | 327419  |     6200     |
      | 327427  |     6700     |
      | 327433  |     6800     |
      | 409502  |     8670     |
      | 405054  |     5995     |