Feature: Verify extra connection objects not showing in the response.

  Scenario Outline: Verify extra object "User": "readonly", "jdbc/insuranceQuoteDataSource": objects" not showing in the response.
    Given user hit url
    When user calls vds to see the response
    Then user should not see '<vehicle_vac>' and '<insurancequote>'

    #all objects1 and object2  mentioned in the ticket
    Examples:
      |vehicle_vac                                                                               | insurancequote                                                                                                                                          |
      |"jdbc/vehicleVacDataSource", "Server": "lnoc-q1cp-xmy1.autodatacorp.org","User": "readonly", "Database": "vehicle_vac"| "jdbc/insuranceQuoteDataSource", "Server": "lnoc-q1cp-xmy1.autodatacorp.org","User": "readonly","Database": "insurancequote"|
