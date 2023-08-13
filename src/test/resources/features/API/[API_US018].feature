Feature: As an administrator, I want to access the Book Issue List through API connection.

  Scenario: When a valid authorization information is used and a GET request is sent to the api/bookIssueList endpoint,
  the expected status code is 200, and the message in the response body should be "Success."

    When "ADMIN" Page User sets "api/bookIssueList" parameters
    Then User sends a get request
    Then It is validated that the status code is 200 and the response message is Success

  Scenario: [TC_002] GET Request Failed Response for the Visitor Purpose List

    Given "Tuba" Page User sets "api/visitorsPurposeList" parameters
    Then User sends a get request
    Then Execute a verification for an invalid authorization


