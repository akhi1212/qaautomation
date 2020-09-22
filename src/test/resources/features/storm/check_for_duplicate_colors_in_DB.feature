Feature: Query the DB directly by styleID and verify that there are not duplicate colors.

    #The thought behind the feature file is to count the number of instances for each color and confirm that it is 1.
  Scenario Outline: Verify RVE scripts is not creating duplicate colors
    Given Actor wants to get a valid connection to the database
    When Actor wants to retrieve vehicle information from the DB for '<styleId>'
    Then Actor should see the 'code' as '<code>', 'name' as '<name>', 'genericName' as '<genericName>', 'primary' as '<primary>' with no duplicates in the query response

    Examples:
      | styleId | code | name                      | genericName                  | primary |
      | 398727  | UM   | Agate Black Metallic      | Black                        | true    |
      | 398727  | N1   | Blue Jeans Metallic       | Blue                         | true    |
      | 398727  | E2   | Magma Red Metallic        | Red                          | true    |
      | 398727  | Z1   | Oxford White              | White                        | true    |
      | 398727  | RR   | Ruby Red Met Tinted CC    | Red                          | true    |
      | 398727  | UG   | White Platinum Met TC     | White                        | true    |
      | 398727  | D1   | Stone Gray                | Gray                         | false   |
      | 398727  | D1   | Stone Gray Metallic       | Gray                         | true    |
      | 398727  | SP   | Java                      | Brown                        |         |
      | 391070  | G1E  | Long Beach Red Met Tint   | Red                          | true    |
      | 391070  | G26  | Sebring Orange Tintcoat   | Orange                       | true    |
      | 391070  | G7Q  | Watkins Glen Gray Met     | Gray                         | true    |
      | 391070  | G8G  | Arctic White              | White                        | true    |
      | 391070  | G9F  | Ceramic Matrix Gray Met   | Gray                         | true    |
      | 391070  | GAN  | Blade Silver Metallic     | Silver                       | true    |
      | 391070  | GBA  | Black                     | Black                        | true    |
      | 391070  | GC6  | Corvette Racing Yellow    | Yellow                       | true    |
      | 391070  | GGA  | Black Rose Metallic       | Red                          | true    |
      | 391070  | GKZ  | Torch Red                 | Red                          | true    |
      | 391070  | GTR  | Admiral Blue Metallic     | Blue                         | true    |
      | 391070  | 00T  | Blue Convertible Top      | Blue Convertible Top         |         |
      | 391070  | 21T  | Kalahari Convertible Top  | Kalahari Convertible Top     |         |
      | 391070  | 37T  | Gray Convertible Top      | Gray Convertible Top         |         |
      | 391070  | 41T  | Black Convertible Top     | Black Convertible Top        |         |
      | 391070  | 80T  | Spice Red Convertible Top | Spice Red Convertible Top    |         |
      | 391070  | 145  | Gray                      | Gray                         |         |
      | 391070  | 196  | Jet Black                 | Black                        |         |
      | 391070  | 706  | Adrenaline Red            | Red                          |         |
      | 391070  | 198  | Jet Black                 | Black                        |         |