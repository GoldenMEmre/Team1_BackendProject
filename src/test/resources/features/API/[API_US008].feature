Feature: As an administrator, I want to access the alumni events information between the
  specified start date and end date through API connection.

  # TC001 FAILED!!
  Scenario: [TC001] When valid authorization information and correct data (start, end) are sent in the POST body
  to the api/alumniEventsByDateRange endpoint, the expected status code is 200, and the message in the
  response body should be "Success."
  Given "ADMIN" Page User sets "api/alumniEventsByDateRange" parameters
  Then User sends a POST request for start date "2021-01-14 00:00:00" and end date "2023-03-15 23:59:00"
  Then Execute a verification for a valid authorization

    Scenario: [TC002] When invalid authorization information or invalid data (start, end) are sent in the POST body
    to the api/alumniEventsByDateRange endpoint, the expected status code is 403, and the message in the
    response body should be "failed."
      Given "OGUN" Page User sets "api/alumniEventsByDateRange" parameters
      Then User sends a POST request for start date "2021-01-14 00:00:00" and end date "2023-03-15 23:59:00"
      Then Execute a verification for an invalid authorization

      Scenario: [TC002] When valid authorization information and correct data are sent in the POST body to the
      api/alumniEventsByDateRange endpoint, the content of the data in the response body should be validated.
        Given "ADMIN" Page User sets "api/alumniEventsByDateRange" parameters
        Then User sends a POST request for start date "2021-01-14 00:00:00" and end date "2023-03-15 23:59:00"
        Then Validate the content of the data in the response body