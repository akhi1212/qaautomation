Feature: Retrieve Runtime CRM service version number


  Scenario: Validate get version operation returns the Runtime CRM version number
    Given Corey wants to retrieve the runtime crm version number
    When he calls the get version operation
    Then he should see the version number in the response

#  Background:
#    Given 'Corey' has access to the service
#    And is targeting the Connections resource


#  Scenario: Verify the response from the version endpoint
#    Given a request for the resource is made
#    Then the request should be successful and the response should be valid