Feature: As an administrator, I want to access the Session List through API connection.
  Scenario: When a valid authorization information is sent with a GET request to the api/sessionList endpoint,
  the expected status code is 200, and the message in the response body should be "Success."
    Given "ADMIN" Page User sets "api/sessionList" parameters
    Then User sends a get request and verify status code and message
