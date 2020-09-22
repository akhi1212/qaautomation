Feature: Retrieve a vehicle by VIN and verify boxStyle value is being populated in the service response.

  Scenario Outline: Validate boxStyle returned by vds for a vin
    Given Actor wants to retrieve vin information for '<vin>'
    When Actor calls vds for vin
    Then user should see the boxStyle '<boxStyle>' in service response for '<styleId>'

    #The fist 6 VINs are for trucks where the boxStyle field is expected to be populated.
#The next 3 VINs ID are for car, van, and SUV vehicles where the boxStyle field is expected to be none.
    Examples:
      | vin                 | boxStyle      |styleId|
      | 1GT49PEY1LF100771   | Regular Side  |405263 |
      | 3C6UR5JJ3KG543649   | Regular Side  |405149 |
      | 1GC4YPEY8LF130420   | Regular Side  |405288 |
      | 1FT7W2BT0HEB36644   | Regular Side  |385442 |
      | 1FTPW04V79KB06630   | Flareside     |305777 |
      | 1FTFW1RG1KFC59255   | Styleside     |403577 |
      | KL4MMGSL8LB060620   |               |409131 |
      | WA1VAAGE6KB021561   |               |404329 |
      | SADCJ2GX2KA354810   |               |401104 |
