Feature: Retrieve the health from vin id cassandra


  Scenario: Validate get health operation returns by vin id cassandra
    Given Corey wants to retrieve the health from vin id cassandra
    When he calls the get health operation
    Then he should see the result in the response