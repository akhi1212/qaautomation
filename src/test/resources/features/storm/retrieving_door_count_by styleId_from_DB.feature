Feature: Query the DB directly by styleID and verify the number of doors value is being populated by the etl service.
  
  Scenario Outline: Validate RVE scripts's doors value by DB query
    Given Actor wants to get a valid connection to the database
    When Actor wants to retrieve vehicle information from the DB for '<styleId>'
    Then Actor should see the 'doors' as '<doors>' in the query response

#This is a mix of styleID for 2, 3, & 4 doors in a variety of body styles; sedan, coupe, convertible, van, truck.
    Examples:
      | styleId | doors |
      | 411474  | 2     |
      | 398284  | 2     |
      | 407343  | 4     |
      | 408442  | 4     |
      | 405778  | 3     |
      | 329736  | 4     |
      | 327419  | 2     |
      | 327427  | 4     |
      | 327433  | 4     |
      | 409502  | 3     |
      | 405054  | 4     |