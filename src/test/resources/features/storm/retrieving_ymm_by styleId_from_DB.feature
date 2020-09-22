Feature: Query the DB directly by styleID and verify the Year, Make, and Model values are being populated by the etl service.

  Scenario Outline: Validate RVE scripts's year, make, and model values by DB query
    Given Actor wants to get a valid connection to the database
    When Actor wants to retrieve vehicle information from the DB for '<styleId>'
    Then user should see the '<year>','<make>' and '<model>' in the query response

#The first 10 styleID are for US vehicles; the next 10 styleID are for CA vehicles.
    Examples:
      | styleId | year | make       | model             |
      | 407713  | 2020 | Ram        | 1500              |
      | 403574  | 2019 | Ford       | F-150             |
      | 397868  | 2018 | Acura      | RLX               |
      | 390320  | 2017 | Alfa Romeo | Giulia Quadrifoglio |
      | 376923  | 2016 | Audi       | S3                |
      | 370939  | 2015 | BMW        | 7 Series          |
      | 358491  | 2014 | Buick      | LaCrosse          |
      | 349547  | 2013 | Cadillac   | Escalade          |
      | 325744  | 2010 | Dodge      | Viper             |
      | 410189  | 2020 | FIAT       | 124 Spider        |
      | 401227  | 2019 | Genesis    | G90               |
      | 393714  | 2018 | GMC        | Canyon            |
      | 385561  | 2017 | Honda      | Ridgeline         |
      | 375963  | 2016 | Hyundai    | Veloster          |
      | 371902  | 2015 | INFINITI   | Q70               |
      | 356711  | 2014 | Jaguar     | F-TYPE            |
      | 353717  | 2013 | Jeep       | Grand Cherokee    |
      | 337025  | 2012 | Kia        | Forte             |
      | 329029  | 2011 | Land Rover | Range Rover Sport |
      | 322350  | 2010 | Lexus      | IS 250            |