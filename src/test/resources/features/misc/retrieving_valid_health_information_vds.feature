Feature: Retrieve the health from vds webservice


  Scenario: Validate get health operation returns by vds
    Given Corey wants to retrieve the health from vds webservice
    When he calls vds to get health operation
    Then he should see the vds health result in the response