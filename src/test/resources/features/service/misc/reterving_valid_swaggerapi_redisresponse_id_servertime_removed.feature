Feature: Verify  swagger api is not broken for vin description service and return valid http status code 200.

## default url : http://lcoa-dvvd-xap1:8080/vin-description-service/v2/vinDescription
  Scenario: Validate default swagger api is not broken and return http status 200.
    Given user wants to hit swagger api url
    When user hit valid swagger api url
    Then user should see http status code 200 ok and content should not have id, server time, redis response.

## swagger.json : http://lcoa-dvvd-xap1:8080/vin-description-service/v2/vinDescription/swagger.json
  Scenario: Validate swagger.json url is not broken and return http status 200.
    Given user wants to hit swagger api url
    When user hit valid swagger.json api url with 'swagger.json'
    Then user should see http status code 200 ok and content should not have id, server time, redis response.

## swagger.yaml : http://lcoa-dvvd-xap1:8080/vin-description-service/v2/vinDescription/swagger.yaml
  Scenario: Validate swagger.yaml url is not broken and return http status 200.
    Given user wants to hit swagger api url
    When user hit valid swagger.yaml api url with 'swagger.yaml'
    Then user should see http status code 200 ok and content should not have id, server time, redis response.