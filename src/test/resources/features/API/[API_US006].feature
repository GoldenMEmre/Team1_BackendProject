Feature: As an administrator, I want to access the Session List through API connection.

  Scenario: [TC001] When a valid authorization information is sent with a GET request to the api/sessionList endpoint,
  the expected status code is 200, and the message in the response body should be "Success."
    Given "ADMIN" Page User sets "api/sessionList" parameters
    Then User sends a get request
    Then Execute a verification for a valid authorization

    Scenario: [TC002] When invalid authorization information is sent with a GET request to the api/sessionList endpoint,
    the expected status code is 403, and the message in the response body should be "failed."
      Given "OGUN" Page User sets "api/sessionList" parameters
      Then User sends a get request
      Then Execute a verification for an invalid authorization

      Scenario: [TC003] The content of the lists in the response body should be validated to contain data with ID "11,"
      where the session is "2017-18," is_active is "no," created_at is "2017-04-20 02:41:37,"
      and updated_at is "0000-00-00."
        Given "ADMIN" Page User sets "api/sessionList" parameters
        Then User sends a get request
        Then Execute verification for given informations
