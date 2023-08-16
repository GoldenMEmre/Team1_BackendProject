Feature: As an administrator, I want to access the Alumni Events information with a given ID through API connection.

  Scenario: [TC001] When a valid authorization information and correct data (id) are sent in the
  POST body to the api/alumniEventsId endpoint, the expected status code is 200, and
  the message in the response body should be "Success."
    Given "ADMIN" Page User sets "api/alumniEventsId" parameters
    Then User sends a POST request for id 12
    Then Execute a verification for a valid authorization

  Scenario: [TC002] When invalid authorization information or invalid data (id) are sent in the POST body
  to the api/alumniEventsId endpoint, the expected status code is 403, and the message
  in the response body should be "failed."
    Given "ADMIN" Page User sets "api/alumniEventsId" parameters
    Then User sends a POST request for id 232323
    Then Execute a verification for an invalid authorization

    Scenario: [TC003] The content of the list data in the response body should be validated.
      Given "ADMIN" Page User sets "api/alumniEventsId" parameters
      Then User sends a POST request for id 12
      Then Validate content of the response body
